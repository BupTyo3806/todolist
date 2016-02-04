<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <title>Регистрация</title>
    <link rel="stylesheet" type="text/css" href="resources/registration.css">
    <link href='https://fonts.googleapis.com/css?family=PT+Sans:400,700&subset=latin,cyrillic' rel='stylesheet' type='text/css'>
</head>
<body>
<div class="container">
    <form action="registration.html" method="post">
        <div class="name">
            <label for="name">Имя</label>
            <input type="text"  id="name" name="name" required >
        </div>
        <div class="password">
            <label for="password">Пароль</label>
            <input type="password"  id="password" name="password" required >
        </div>
        <input type="submit" value="Зарегистрироваться">
    </form>
</div>
</body>
</html>