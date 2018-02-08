<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 28/1/18
  Time: 7:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Song</title>
</head>
<body>
<form method="post" action="/harmonia_backend_v1_war_exploded/MainServlet">
    Username : <input type="text" name="name" /><br />
    Email : <input type="text" name="email" /><br />
    Password : <input type="password" name="password" /><br />
    <input type="submit" />
</form>
</body>
</html>
