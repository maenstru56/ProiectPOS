<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<div>
    <form method="post" action="AddUser">
        <div>
            <input type="text" name="username" />
        </div>
        <div>
            <input type="password" name="password" />
        </div>
        <div>
            <select name="roles" name="roles">
                <option value="1">Cashier</option>
                <option value="2">Director</option>
                <option value="3">Admin</option>
            </select>
        </div>
        <div>
            <input type="email" name="email" />
        </div>
        <div>
            <input type="submit" value="Add" />
        </div>
    </form>

<%--    <a href="hello-servlet">Hello Servlet</a>--%>
</div>
</body>
</html>