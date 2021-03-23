<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
   </head>
   <body>
    <div align="center" model="${tournament}" var="tournament">
        <h2 align="center">Tournament ${tournament.id}</h2>
        <b>Name: </b>
        ${tournament.name}
        <br/>
        <b>Date: </b>
        ${tournament.date}
        <br/>
        <b>Time: </b>
        ${tournament.time}
        <br/>
        <b>Winner: </b>
        ${tournament.result.winner.name}
        <br/>
        <b>Teams:<b>
        <br/>
        <table width="50%">
            <tr>
                <td> Team name </td>
            </tr>
            <c:forEach items="${teams}" var="teams">
                    <tr>
                         <th style="border: 2px solid black">${teams.name}</th>
                    </tr>
            </c:forEach>
        </table>
        <form action="/tournaments">
            <input type="submit" value="Back"/>
        </form>
    </div>
   </body>
</html>