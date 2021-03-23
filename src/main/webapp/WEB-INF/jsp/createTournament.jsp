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
       Create tournament
    </h1>
    <div align="center">
        <form action="/tournamentCreatedProcess" modelAttribute="tournament" method="post">
            <input type="text" name="name"/>
            <input type="date" name="date"/>
            <input type="time" name="time"/>
            <input type="submit" value="Create"/>
            <br/>
            <br/>
            <b> Teams </b>
            <br/>
            <table width="50%">
                <tr>
                    <td/>
                    <td  style="border: 2px solid black"> Team name </td>
                </tr>
                <c:forEach items="${teams}" var="team">
                    <tr>
                        <th><input type="checkbox" name="teamId" value="${team.id}"/></th>
                        <th style="border: 2px solid black" width="95%">${team.name}</th>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </div>
   </body>
</html>