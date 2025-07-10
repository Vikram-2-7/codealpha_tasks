package frontend.pages.viewbooking;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import frontend.pages.reserve.Booking;
import frontend.pages.reserve.DBUtil;

@WebServlet("/view-bookings")
public class ViewBookingsServlet extends HttpServlet {

    private static final long serialVersionUID = 1L; 

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        String mobile = req.getParameter("mobile");
        if (mobile == null || mobile.trim().isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Mobile number is required.");
            return;
        }

        List<Booking> bookings = new ArrayList<>();

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "SELECT * FROM bookings WHERE mobile = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, mobile);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking b = new Booking();
                b.setFname(rs.getString("fname"));
                b.setSname(rs.getString("sname"));
                b.setCheckin(rs.getDate("checkin"));
                b.setCheckout(rs.getDate("checkout"));
                b.setMobile(rs.getString("mobile"));
                b.setRoomType(rs.getString("roomType"));
                b.setPaymentMethod(rs.getString("paymentMethod"));
                b.setTransactionId(rs.getString("transactionId"));
                bookings.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database error while fetching bookings", e);
        }

        req.setAttribute("bookings", bookings);
        req.getRequestDispatcher("/frontend/pages/reserve/viewbooking.jsp").forward(req, res);
    }
}
