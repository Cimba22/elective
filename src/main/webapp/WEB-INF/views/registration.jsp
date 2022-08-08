<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Registration</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

</head>

<body>
<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>
<div class="container">

    <h2>User Register Form</h2>
    <div class="col-md-6 col-md-offset-3">

        <form action="<%=request.getContextPath()%>/register" method="post">

            <div class="form-group">
                <label for="username">User Name:</label> <input type="text" class="form-control" id="username" placeholder="User Name" name="username" required>
            </div>

            <div class="form-group">
                <label for="name">First Name:</label> <input type="text" class="form-control" id="name" placeholder="First Name" name="firstName" required>
            </div>

            <div class="form-group">
                <label for="surname">Last Name:</label> <input type="text" class="form-control" id="surname" placeholder="last Name" name="lastName" required>
            </div>

            <div class="form-group">
                <label for="password">Password:</label> <input type="password" class="form-control" id="password" placeholder="Password" name="password" required>
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>

        </form>
    </div>
</div>
<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
</body>

</html>