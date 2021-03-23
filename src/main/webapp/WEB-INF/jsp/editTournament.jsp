<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
   </head>
   <body>
    <div align="center">
        <form modelAttribute="tournament" action="/editTournamentProcess" method="POST">
            <input name="id" type="hidden" value="${tournament.id}"/>
            <h2 align="center">Tournament ${tournament.id}</h2>
            <b>Name: </b>
            <input type="text" name="name" value="${tournament.name}"/>
            <br/>
            <b>Date: </b>
            <input type="date" name="date" value="${tournament.date}"/>
            <br/>
            <b>Time: </b>
            <input type="time" name="time" value="${tournament.time}"/>
            <br/>
        <b>Winner: </b>
        <select name="resultTeam">
            <option value="${tournament.result.winner.id}">
                ${tournament.result.winner.name}
            </option>
            <c:forEach items="${teams}" var="team">
              <option value="${team.id}">
                  ${team.name}
              </option>
            </c:forEach>
        </select>
        <br/>
        <b>Teams:<b>
        <br/>
        <table width="50%">
            <tr>
                <td> </td>
                <td style="border: 2px solid black"> Team name </td>
            </tr>
            <c:forEach items="${tournament.teams}" var="teams">
                    <tr>
                         <th><input type="checkbox" name="teamIds" value="${teams.id}" checked/></th>
                         <th style="border: 2px solid black" width="95%">${teams.name}</th>
                    </tr>
            </c:forEach>
        </table>
            <input type="submit" value="Commit"/>
        </form>
        <form action="/editTournaments">
            <input type="submit" value="Back"/>
        </form>
    </div>
   </body>
</html>