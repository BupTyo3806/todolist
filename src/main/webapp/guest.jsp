<%@page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="guest.*"%>
 
<%--<jsp:useBean id="guestDao" type="guest.GuestDao" scope="request" />--%>
<jsp:useBean id="guest" type="guest.Guest" scope="request" />
 
<!DOCTYPE html>
 
<html>
    <head>
        <title>JPA Guestbook Web Application Tutorial</title>
    </head>
 
    <body>
    <%= guest %>
 
        <%--<hr><ol> --%>
        <%--<% for (Guest guest : guestDao.getAllGuests()) { %>--%>
            <%--<li> <%= guest %> </li>--%>
        <%--<% } %>--%>
        <%--</ol><hr>--%>
	</body>
</html>