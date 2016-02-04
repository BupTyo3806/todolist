<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>

<html>
<head>
    <title>Главная страница</title>
</head>

<body>
<a href="registrationPage.html">Регистрация</a>
<hr>
Авторизация
<form method="POST" action="auth.html">
    Name: <input type="text" name="name" value="test" required/>
    Password: <input type="text" name="password" value="test" required/>
    <input type="submit" value="Add"/>
</form>
<a href="define.html">Определить даннные</a>
<a href="rssfeed.html">Экспорт в RSS</a>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</body>
</html>
