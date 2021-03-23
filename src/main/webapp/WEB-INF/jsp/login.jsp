<!DOCTYPE HTML>
<html>
   <head>
      <meta charset="UTF-8" />
      <title>Welcome</title>
   </head>
   <body>
    <h1 align="center">
       Login
    </h1>
    <div align="center">
        <form method="post" action="processLogin" modelAttribute="user">
            <label>Username</label>
            <input name="login" style="margin-bottom: 5px"/>
    	    <br/>
            <label>Password</label>
            <input name="password" type="text" style="margin-bottom: 5px"/>
            </br>
            <input type="submit" value="Login" style="width:15%"/>
      </form>
    </div>
   </body>
</html>