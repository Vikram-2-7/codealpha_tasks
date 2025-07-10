<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="frontend.pages.reserve.Booking"%>
<%@page import="Booking"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Booking Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container py-5">
        <h2 class="mb-4 text-primary">Your Booking Details</h2>
        <%
            List<Booking> bookings = (List<Booking>) request.getAttribute("bookings");
            if (bookings == null || bookings.isEmpty()) {
        %>
            <div class="alert alert-warning">No bookings found for the provided mobile number.</div>
        <%
            } else {
        %>
            <table class="table table-bordered table-striped">
                <thead class="table-dark">
                    <tr>
                        <th>Name</th>
                        <th>Check-in</th>
                        <th>Check-out</th>
                        <th>Room Type</th>
                        <th>Payment Method</th>
                        <th>Transaction ID</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (Booking b : bookings) {
                    %>
                    <tr>
                        <td><%= b.getFname() %> <%= b.getSname() %></td>
                        <td><%= b.getCheckin() %></td>
                        <td><%= b.getCheckout() %></td>
                        <td><%= b.getRoomType() %></td>
                        <td><%= b.getPaymentMethod() %></td>
                        <td><%= b.getTransactionId() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        <%
            }
        %>
        <a href="javascript:history.back()" class="btn btn-secondary mt-3">Back</a>
    </div>
</body>
</html>
