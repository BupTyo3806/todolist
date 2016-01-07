<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>

<html>
<head>
    <title>Главная страница</title>
</head>

<body>
Регистрация
<form method="POST" action="registration.html">
    Name: <input type="text" name="name" required/>
    Password: <input type="text" name="password" required/>
    <input type="submit" value="Add"/>
</form>
<hr>
Авторизация
<form method="POST" action="auth.html">
    Name: <input type="text" name="name" required/>
    Password: <input type="text" name="password" required/>
    <input type="submit" value="Add"/>
</form>

</body>
</html>
