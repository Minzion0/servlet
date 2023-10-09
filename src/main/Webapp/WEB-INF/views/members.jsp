<%@ page import="hello.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: 이민용
  Date: 2023-10-09
  Time: 오전 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
  <thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
  </thead>
  <tbody>
  <c:forEach var="itme" items="${members}">
    <tr>
      <td>${itme.id}</td>
      <td>${itme.username}</td>
      <td>${itme.age}</td>

    </tr>
  </c:forEach>
  </tbody>
</table>

</body>
</html>
