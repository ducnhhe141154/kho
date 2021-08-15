<%-- 
    Document   : searchxuat
    Created on : Mar 26, 2021, 2:37:30 PM
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
        <title>Tra cứu Đơn Xuất</title>
        <link href="css/searchxuat.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
        <a href="main"><button style="font-size: 20px;background-color: #e2e2e2;padding:10px">Home</button></a>
        <h1>Tra Cứu Đơn Xuất</h1>
        <div class="search">
            <form action="searchxuat" method="Post" id="frmSearch">
                Tháng : <input onchange="submitForm()" type="number" name="thang" value="${requestScope.date}" min="1" max ="12"/><br><br>
            </form>
        </div >
        <div class="main" >
            <table>
                <tr>
                    <td>STT</td>
                    <td>Ngày</td>
                    <td>Note</td>
                    <td>Chi tiết</td>
                </tr>
                <c:forEach items="${requestScope.hoadon}" var="hd">
                    <tr>
                        <td>${hd.id}</td>
                        <td>${hd.date}</td>
                        <td>${hd.note}</td>
                        <td>
                            <form action="showxuat" method="Post">
                                <input type ="hidden" name="id" value="${hd.id_details}"/>
                                <input type ="hidden" name="date" value="${requestScope.date}"/>
                                <button type="submit" class="w3-button" style="width:auto;">Chi tiết</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
