<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@page import="guest.*" %>

<%--<jsp:useBean id="guestDao" type="guest.GuestDao" scope="request" />--%>
<jsp:useBean id="guest" type="guest.Guest" scope="request"/>
<jsp:useBean id="taskDao" type="guest.TaskDao" scope="request"/>

<!DOCTYPE html>

<html>
<head>
    <title>Список</title>
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
    </tr>
    </thead>
    <tbody>
    <% for (Task task : taskDao.getAllTasks()) {%>
    <tr>
        <td><%= task.getId() %>
        </td>
        <td><%= task.getText() %>
        </td>
        <td><%= task.getUserId() %>
        </td>
        <td><%= task.getStatus() %>
        </td>
        <td><%= task.getDate() %>
        </td>
        <td>
            <form>
                <input type="hidden" name="id" value="<% task.getId(); %>">
                <input type="hidden" name="status" value="0">
                <input type="submit" value="0">
            </form>
        </td>
        <td>
            <form>
                <input type="hidden" name="id" value="<% task.getId(); %>">
                <input type="hidden" name="status" value="1">
                <input type="submit" value="1">
            </form>
        </td>
        <td>
            <form>
                <input type="hidden" name="id" value="<% task.getId(); %>">
                <input type="hidden" name="status" value="2">
                <input type="submit" value="2">
            </form>
        </td>
    </tr>
    <%}%>
    </tbody>
</table>
<%--<hr><ol> --%>
<%--<% for (Guest guest : guestDao.getAllGuests()) { %>--%>
<%--<li> <%= guest %> </li>--%>
<%--<% } %>--%>
<%--</ol><hr>--%>
</body>
</html>