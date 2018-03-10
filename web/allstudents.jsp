<%-- 
    Document   : allstudents
    Created on : Mar 5, 2018, 1:18:16 AM
    Author     : Miriam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All Students</title>
    </head>
    <body>
        <table border="1">
            <th>Student ID</th> 
            <th>Student Name</th>
            <th>Surname</th>
            <th>Age</th> 
            <th>Group</th> 
            <th>Specialty</th> 
            <c:forEach items="${requestScope.list}" var="student">
            <tr>
                <td><a href="./GetStudent?id=${student.studentID})">${student.studentID}</a></td>
                <td>${student.name}</td>
                <td>${student.surname}</td>
                <td>${student.age}</td>
                <td>${student.group}</td>
                <td>${student.specialty}</td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>
