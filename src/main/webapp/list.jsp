<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page import="guest.*" %>

<jsp:useBean id="guestDao" type="guest.GuestDao" scope="request"/>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="utf-8"/>
    <title>Список задач</title>
    <link rel="stylesheet" type="text/css" href="resources/style.css">
    <link href='https://fonts.googleapis.com/css?family=PT+Sans:400,700&subset=latin,cyrillic' rel='stylesheet'
          type='text/css'>
</head>
<body>
<div class="container">
    <div class="menu">
        <a class="logo" href="main.html"><img src="resources/images/logo.png"></a>
        <a class="menu_all_tasks" href="allTasks.html">Все задачи</a>
        <a class="menu_important_tasks" href="importantTasks.html">Важные</a>
        <a class="menu_done_tasks" href="executedTasks.html">Выполненные</a>
        <a class="menu_notdone_tasks" href="notExecutedTasks.html">Невыполненные</a>

        <div class="action_panel">
            <form id="important_form" method="post" action="changeStatus.html">
                <input id="important_id" type="hidden" name="id" value="">
                <input type="hidden" name="status" value="1">
                <a href="#" onclick="document.getElementById('important_form').submit(); return false;">Пометить как важное</a>
            </form>
            <form id="execute_form" method="post" action="changeStatus.html">
                <input id="execute_id" type="hidden" name="id" value="">
                <input type="hidden" name="status" value="2">
                <a href="#" onclick="document.getElementById('execute_form').submit(); return false;">Пометить как выполненное</a>
            </form>
            <form id="not_execute_form" method="post" action="changeStatus.html">
                <input id="not_execute_id" type="hidden" name="id" value="">
                <input type="hidden" name="status" value="0">
                <a href="#" onclick="document.getElementById('not_execute_form').submit(); return false;">Пометить как невыполненное</a>
            </form>
            <form id="sharing_form" method="post" action="sharing.html">
                <input id="sharing_id" type="hidden" name="id" value="">
                <a href="#" onclick="document.getElementById('sharing_form').submit(); return false;">Открыть для чтения</a>
            </form>
            <form id="delete_form" method="post" action="deleteTask.html">
                <input id="delete_id" type="hidden" name="id" value="">
                <a href="#" onclick="document.getElementById('delete_form').submit(); return false;">Удалить задачу</a>
            </form>
        </div>
    </div>
    <div class="tasks">
        <c:forEach var="task" items="${tasks}">
            <div id="${task.id}" onclick="selectTask(this, $(this).attr('id'))" class="
            <c:choose>
    <c:when test="${task.status == 0}">
       task notdone_task
    </c:when>
    <c:when test="${task.status == 2}">
       task done_task
    </c:when>
    <c:when test="${task.status == 1}">
       task important_task
    </c:when>
            </c:choose>" style="
            <c:if test="${task.sharing == true}">
                    border: 2px solid #000;
                    </c:if>">
                <div class="text">
                    <p>${task.text}</p>
                </div>
                <div class="date">
                    <p>${task.userName}
                    </p>
                    <p>${task.date}</p>
                </div>
            </div>
        </c:forEach>
        <c:if test="${addTask == true}">
            <form method="post" action="addTask.html">
                <input type="submit" value="">
                <input type="text" name="text" placeholder="Добавить задачу" required>
            </form>
        </c:if>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>
    var taskId = null;
    function selectTask(object, id) {
        if (id == taskId) {
            $('[id = ' + taskId + ']').css('background-color', 'rgba(255, 254, 99, 0.0');
            taskId = null;
            $(".action_panel").hide();
            return;
        }
        if (taskId != null) {
            $('[id = ' + taskId + ']').css('background-color', 'rgba(255, 254, 99, 0.0');
        }
        $(".action_panel").show();
        taskId = id;
        $('#important_id').val(taskId);
        $('#execute_id').val(taskId);
        $('#not_execute_id').val(taskId);
        $('#sharing_id').val(taskId);
        $('#delete_id').val(taskId);
        $(object).css('background-color', 'rgba(255, 254, 99, 0.57');
    }
</script>
</body>
</html>