<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link href="resources/css.css" rel="stylesheet">
    <title> TodoList </title>
</head>

<body>
<div class="main">
    <div class="notebook">

        <div class="main-head">
            <div class="container clearfix">
                <nav class="nav">
                    <form id="auth_form" method="POST" action="auth.html">
                        <ul>
                            <li>
                                <div><a href="main.html" class="logo"></a></div>
                            </li>
                            <li>Имя</li>
                            <li><input type="text" name="name" class="box" size="24" form="auth_form"></li>
                            <li>Пароль</li>
                            <li><input type="password" name="password" class="box" size="24" form="auth_form"></li>

                            <li><a href="#" onclick="document.getElementById('auth_form').submit(); return false;"
                                   class="btn-box box-enter">Вход</a></li>
                            <li><a href="registrationPage.html" class="btn-box box-regist">Регистрация</a></li>
                        </ul>
                    </form>
                </nav>
            </div>
        </div>
        <a href="define.html">Определить даннные</a>
        <a href="rssfeed.html">Экспорт в RSS</a>

        <div class="plans">
            Планируйте свой день <br> вместе с TODOLIST
        </div>

        <div class="why"></div>
    </div>


    <div class="main-container">

        <div class="bg"></div>

        <div class="features-row clearfix">
            <div class="func-icon"></div>
            <div class="features-item">
                <div class="features-title">Функциональный</div>
                С помощью TODOLIST, <br> ваш список задач всегда с вами. <br> В любое время!
            </div>
        </div>

        <div class="features-row clearfix">
            <div class="design-icon"></div>
            <div class="features-item-left">
                <div class="features-title">Простой</div>
                Ваши задачи - ваша жизнь. <br> оставайтесь организованными <br> с помощью прекрасного, <br> интуитИвного
                списка задач TODOLIST.
            </div>
        </div>

        <div class="bg2"></div>

        <div class="conclusion">
            TODOLIST везде с вами <br> узнайте о нас больше!
        </div>

        <div class="footer">
            <div class="container clearfix">
                <div class="logo"></div>
                <div class="logo-itmo"></div>
                <div class="group">P3320</div>
            </div>
        </div>

    </div>

</div>
</body>
</html>
