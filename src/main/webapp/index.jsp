<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="./resources/css/style.css">
    <title>Elective</title>
</head>

<body>

<div class = "container">
    <div class="login-container">
        <form class = "login" action="login" method="POST">
            <label>
                <input name = "email" type="text" placeholder="  email@email.com">
            </label>
            <label>
                <input name = "password" type="password" placeholder="  password">
            </label>
            <button class="sing-in" type="submit">Sing in</button>
            <button class="sing-up">Sing up</button>
<%--            <input type="submit" class="sub" value="login"/>--%>
        </form>
    </div>
</div>

</body>
</html>