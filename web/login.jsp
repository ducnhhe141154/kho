<%-- 
    Document   : login
    Created on : Mar 15, 2021, 5:07:06 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="css/css.css"rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <form action="login" method="Post">
            <div class="imgcontainer">
                <img src="image/loginLogo.png"alt="Avatar" class ="avatar" />
            </div>

            <div class="container">
 <c:if test="${check eq false}">
                    <script>
                        window.alert("Wrong password or username !!");
                    </script>
                </c:if>
                <label for="uname"><b>Username</b></label>
                <input type="text" placeholder="Enter Username" name="uname" required>

                <label for="psw"><b>Password</b></label>
                <input type="password" placeholder="Enter Password" name="psw" required>

                <button type="submit">Login</button>
               
            </div>
        </form>

    </body>
</html>




