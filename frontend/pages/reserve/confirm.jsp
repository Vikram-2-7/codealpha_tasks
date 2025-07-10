<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <title>Booking Confirmation</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.6/dist/css/bootstrap.min.css" rel="stylesheet">
  <link rel="stylesheet" href="<%=request.getContextPath()%>/frontend/pages/reserve/confirm.css">
</head>
<body class="bg-light">
  <div class="container py-5">
    <div class="card shadow p-4">
      <h2 class="text-success text-center mb-4">Booking Successful!</h2>
      <p><strong>Name:</strong> <%=request.getAttribute("fname")%> <%=request.getAttribute("sname")%></p>
      <p><strong>Check-in:</strong> <%=request.getAttribute("checkin")%></p>
      <p><strong>Check-out:</strong> <%=request.getAttribute("checkout")%></p>
      <p><strong>Mobile:</strong> <%=request.getAttribute("mobile")%></p>
      <p><strong>Room Type:</strong> <%=request.getAttribute("roomType")%></p>
      <div class="text-center mt-4">
        <a href="<%=request.getContextPath()%>/frontend/pages/reserve/reserve.html" class="btn btn-primary">Book Again</a>
      </div>
    </div>
  </div>
</body>
</html>
