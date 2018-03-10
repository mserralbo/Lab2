<%-- 
    Document   : index
    Created on : Mar 5, 2018, 12:51:04 AM
    Author     : Miriam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <table border="1">
            <td><a href="studentInfo.jsp">Student Info</a></td>
            <td><a href="./AllStudents">All Students</a></td>
        </table>
        <br />
        
        <form action="./StudentServlet" method="POST">
         <table>
             <tr>
                 <td>Student ID:</td>
                 <td><input type="int" name="id" value="${student.id}"/></td>
             </tr>
             <tr>
                 <td>Name:</td>
                 <td><input type="text" name="name" value="${student.name}"/></td>
             </tr>
            <tr>
                 <td>Surname:</td>
                 <td><input type="text" name="surname" value="${student.surname}"/></td>
             </tr>
             <tr>
                 <td>Group:</td>
                 <td><input type="int" name="group" value="${student.group}"/></td>
             </tr>
             <tr>
                 <td>Age:</td>
                 <td><input type="text" name="age" value="${student.age}"/></td>
             </tr>
             <tr>
                 <td>Specialty:</td>
                 <td><input type="text" name="specialty" value="${student.specialty}"/></td>
             </tr>
             <tr>
                 <td colspan="2"><input type="Submit" name="operation" values="Add" />
                 <input type="Submit" name="operation" values="Edit" />
                 <input type="Submit" name="operation" values="Delete" />
                 <input type="Submit" name="operation" values="Search" /></td>
              </tr>
        </table>
            
        </form>
        
    </body>
</html>
