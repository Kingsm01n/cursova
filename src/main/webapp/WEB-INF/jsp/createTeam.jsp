<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
   </head>
   <body>
    <h1 align="center">
       Create team
    </h1>
    <div align="center">
        <form action="/teamCreatedProcess" modelAttribute="team" method="post">
            <input type="text" name="name"/>
            <input type="submit" value="Create"/>
            <br/>
            <br/>
            <b> Users </b>
            <br/>
            <table width="50%">
                <tr>
                    <td/>
                    <td  style="border: 2px solid black"> Login </td>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <th><input type="checkbox" name="userId" value="${user.id}"/></th>
                        <th style="border: 2px solid black" width="95%">${user.login}</th>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
   </body>
</html>