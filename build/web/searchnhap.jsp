<%-- 
    Document   : searchnhap
    Created on : Mar 29, 2021, 4:01:22 AM
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
        <title>Tra cứu Đơn Nhập</title>
        <link href="css/searchxuat.css" rel="stylesheet" type="text/css"/>
    </head>
    <body> 
        <a href="main"><button style="font-size: 20px;background-color: #e2e2e2;padding:10px">Home</button></a>
        <h1>Tra Cứu Đơn Nhập</h1>
        <div class="search">
            <form action="searchnhap" method="Post" id="frmSearch">
                Số phiếu : <input type="text" onchange="submitForm()" name="sophieu" value="${requestScope.sophieu}"/>
            </form>
        </div >
        <div class="main" >
            <table>
                <tr>
                   
                    <td>Số phiếu</td>
                     <td>Nhà phân phối</td>
                    <td>Ngày</td>
                    <td>Note</td>
                    <td>Chi tiết</td>
                </tr>
                <c:forEach items="${requestScope.hoadon}" var="hd">
                    <tr>
                        <td>${hd.sophieu}</td>
                        <c:forEach items="${chukho}" var ="ck">
                            <c:if test="${ck.id eq hd.idchukho}">
                               <td>${ck.name}</td> 
                            </c:if>
                        </c:forEach>
                       
                        <td>${hd.date}</td>
                        <td>${hd.note}</td>
                        <td>
                            <form action="shownhap" method="Post">
                                <input type ="hidden" name="id" value="${hd.id_details}"/>
                                <input type ="hidden" name="sophieu" value="${requestScope.sophieu}"/>
                                <button type="submit" class="w3-button" style="width:auto;">Chi tiết</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </body>
</html>
