<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>

<html>
<head>
    <title>Главная страница</title>
</head>

<body>
Регистрация
<form method="post" action="registration.html">
    Name: <input id="reg-name" type="text" name="name" required>
    Password: <input id="reg-pass" type="text" name="password" required/>
    <input type="submit" value="Add"/>
</form>
<hr>
Авторизация
<form method="POST" action="auth.html">
    Name: <input type="text" name="name" required/>
    Password: <input type="text" name="password" required/>
    <input type="submit" value="Add"/>
</form>
<h1 id="result-text"></h1>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</body>
</html>
