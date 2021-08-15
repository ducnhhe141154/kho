<%-- 
    Document   : TKThang
    Created on : Mar 31, 2021, 12:02:24 AM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script>
    function submitForm()
    {
        document.getElementById("frmSearch").submit();
    }
</script>
<!DOCTYPE html>
<html style="background-color: #cccccc">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thống kê theo tháng</title>
        <link href="css/searchxuat.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
          <a href="main"><button style="font-size: 20px;background-color: #e2e2e2;padding:10px">Home</button></a>
        <form action="thang" method="post">
            <h1>Thống kê theo tháng</h1>
            <h3 style="text-align: center">Năm : <input type="txt" name ="nam" value = "2021"> </h3>
            <div class="search">
                <div class="main"  >
                    <table>
                        <c:forEach begin="1" end="12" var="i">
                            <tr>
                                <td>Tháng ${i}</td>
                                <td><button name="thang" value="${i}">Xem</button></td> 
                            </tr>
                        </c:forEach>  
                    </table>
                </div>
            </div>
        </form>
    </body>
</html>
