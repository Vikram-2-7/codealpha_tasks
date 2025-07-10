package frontend.pages.reserve;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        // Retrieve form parameters
        String fname = req.getParameter("fname");
        String sname = req.getParameter("sname");
        String guest = req.getParameter("guest");
        String checkin = req.getParameter("checkin");
        String checkout = req.getParameter("checkout");
        String mobile = req.getParameter("mobile");
        String pwd = req.getParameter("pwd");
        String roomType = req.getParameter("roomType");
        String paymentMethod = req.getParameter("paymentMethod");
        String transactionId = req.getParameter("transactionId");

        System.out.println("paymentMethod=" + paymentMethod);
        System.out.println("transactionId=" + transactionId);

        
        System.out.println("fname=" + fname);
        System.out.println("sname=" + sname);
        System.out.println("checkin=" + checkin);
        System.out.println("checkout=" + checkout);
        System.out.println("mobile=" + mobile);
        System.out.println("pwd=" + pwd);
        System.out.println("guest=" + guest);
        System.out.println("paymentMethod=" + paymentMethod);
        System.out.println("transactionId=" + transactionId);

        boolean insertSuccess = false;

       
        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO bookings (fname, sname, checkin, checkout, mobile, pwd, roomType, paymentMethod, guest , transactionId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fname);
            ps.setString(2, sname);
            ps.setString(3, checkin);
            ps.setString(4, checkout);
            ps.setString(5, mobile);
            ps.setString(6, pwd);
            ps.setString(7, roomType);
            ps.setString(8, paymentMethod);
            ps.setString(9, guest);
            ps.setString(10, transactionId);


            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("✅ Booking inserted successfully!");
                insertSuccess = true;
            } else {
                System.out.println("⚠️ Booking insert failed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database insert failed", e);
        }

        if (!insertSuccess) {
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Could not insert booking.");
            return;
        }

      
        req.setAttribute("fname", fname);
        req.setAttribute("sname", sname);
        req.setAttribute("checkin", checkin);
        req.setAttribute("checkout", checkout);
        req.setAttribute("mobile", mobile);
        req.setAttribute("pwd", pwd);
        req.setAttribute("roomType", roomType);
        req.setAttribute("paymentMethod", paymentMethod);
        req.setAttribute("guest", guest);
        req.setAttribute("transactionId", transactionId);

        req.getRequestDispatcher("/frontend/pages/reserve/confirm.jsp").forward(req, res);
    }
}
