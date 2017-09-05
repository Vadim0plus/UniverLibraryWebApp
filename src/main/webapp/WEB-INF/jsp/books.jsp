<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--
  Created by IntelliJ IDEA.
  User: Vadim
  Date: 05.09.2017
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book list</title>
</head>
<body>
    <table>
        <tr>
            <td width="150">Name</td>
            <td width="300">Description</td>
        </tr>
        <c:forEach items="${bookList}" var="book">
            <tr>
                <td><c:out value="${book.name}" /></td>
                <td><c:out value="${book.desc}" /></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
