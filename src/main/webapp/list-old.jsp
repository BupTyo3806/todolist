<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page import="guest.*" %>

<%--<jsp:useBean id="guestDao" type="guest.GuestDao" scope="request" />--%>
<jsp:useBean id="guest" type="guest.Guest" scope="request"/>

<!DOCTYPE html>

<html>
<head>
    <title>Список</title>
    <link rel="stylesheet" href="resources/style.css">
</head>
<body>
<%= guest %>
<hr>
<form method="post" action="addTask.html">
    Text: <input type="text" name="text" required>
    <input type="submit" value="Add"/>
</form>
<table border="2">
    <thead>
    <tr>
        <th>ID</th>
        <th>TEXT</th>
        <th>AUTHOR</th>
        <th>STATUS</th>
        <th>CREATION DATE</th>
        <th>STATUS 0</th>
        <th>STATUS 1</th>
        <th>STATUS 2</th>
        <th>Общий доступ</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}
            </td>
            <td>${task.text}
            </td>
            <td>${task.userId}
            </td>
            <td>${task.status}
            </td>
            <td>${task.date}
            </td>
            <td>
                <form method="post" action="changeStatus.html">
                    <input type="hidden" name="id" value="${task.id}">
                    <input type="hidden" name="status" value="0">
                    <input type="submit" value="0">
                </form>
            </td>
            <td>
                <form method="post" action="changeStatus.html">
                    <input type="hidden" name="id" value="${task.id}">
                    <input type="hidden" name="status" value="1">
                    <input type="submit" value="1">
                </form>
            </td>
            <td>
                <form method="post" action="changeStatus.html">
                    <input type="hidden" name="id" value="${task.id}">
                    <input type="hidden" name="status" value="2">
                    <input type="submit" value="2">
                </form>
            </td>
            <td>
                <form method="post" action="sharing.html">
                    <input type="hidden" name="id" value="${task.id}">
                    <input type="submit" value="Открыть">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<a href="allTasks.html">Все записи</a>
<a href="notExecutedTasks.html">Невыполненные</a>
<a href="executedTasks.html">Выполненные</a>
<a href="importantTasks.html">Важные</a>
</body>
</html>