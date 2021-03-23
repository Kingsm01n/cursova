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
       Tournaments
    </h1>
    <div align="center">
        <form action="/tournamentsByTeam" modelAttribute="teamName">
            <b>Team name</b>
            <input name="teamName" type="text"/>
            <input type="submit" value="find"/>
        </form>
            <table width="50%">
                  <tr>
                    <td style="border: 2px solid black">Name</td>
                    <td style="border: 2px solid black">Date</td>
                    <td style="border: 2px solid black">Time</td>
                    <td style="border: 2px solid black">Winner</td>
                  </tr>
                      <c:forEach items="${tournaments}" var="tournaments">
                              <tr>
                                         <th style="border: 2px solid black">${tournaments.name}</th>
                                         <th style="border: 2px solid black">${tournaments.date}</th>
                                         <th style="border: 2px solid black">${tournaments.time}</th>
                                         <th style="border: 2px solid black">${tournaments.result.winner.name}</th>
                                         <th>
                                            <form action="tournament/${tournaments.id}">
                                                <input type="submit" value="Check"/>
                                            </form>
                                         </th>
                              </tr>
                      </c:forEach>
            </table>
    </div>
   </body>
</html>