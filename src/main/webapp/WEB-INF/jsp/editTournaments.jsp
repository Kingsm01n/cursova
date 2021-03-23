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
                                            <form action="tournamentEdit/${tournaments.id}" method="delete">
                                                <input type="submit" value="Edit"/>
                                            </form>
                                            <form action="tournamentDelete/${tournaments.id}">
                                                <input type="submit" value="Delete"/>
                                            </form>
                                         </th>
                              </tr>
                      </c:forEach>
            </table>
            <form action="/adminMain">
                <input type="submit" value="Back"/>
            </form>
    </div>
   </body>
</html>