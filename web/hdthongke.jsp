<%-- 
    Document   : hdthongke
    Created on : Mar 18, 2021, 2:45:07 PM
    Author     : Admin
--%>

<%@page import="java.sql.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%int i = 1;%>
<!DOCTYPE html>
<html lang="vn" style="overflow-y: scroll;"> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hóa đơn xuất hàng</title>
        <link href="css/HoaDonThongKe.css" rel="stylesheet" type="text/css"/>
    </head> 
    <body>
        <a  href="main"><button style="font-size: 20px;background-color: #e2e2e2">&larr;</button></a> <br>
        <div style="background-color: white">
            <br>
            <h4>Nhà phân phối Chăn - Ga Gối Đệm Kim Cương Tuấn Anh</h4>
            <h4>Sông Hồng - Everon - Liên Á -Kim Đan</h4>
            <h1 style="text-align: center;">Phiếu xuất kho </h1>
            <p>Cơ sở 1: Xuân Mai - Hà Nội</p>
            <p>Cơ sở 1: Chương Mỹ - Hà Nội</p>
            <div style=" width: 70%;margin-left: 15%">
                <form id="form2" action="hdthongke" method="Post">
                    <table>
                        <tr>
                            <th>STT</th>
                            <th>Loại Hàng</th>
                            <th>Số Lượng</th>
                            <th>Đơn giá</th>
                            <th>Thành tiền</th>
                        </tr>
                        <c:forEach items="${sessionScope.list}" var ="mh">
                            <tr style="border: solid  1px">
                                <td><%=i%></td>
                                <td>${mh.name}</td>
                                <td>${mh.soluong}</td>
                                <td>${mh.dongia}00 VND</td>
                                <td>${mh.total}00 VND</td>
                            </tr>
                            <input type="hidden" <%=i++%>/>
                        </c:forEach>

                        <tr style="border: solid  1px">
                            <td><%=i%></td>
                            <td><select name="loaihang">
                                    <c:forEach items="${requestScope.mhs}" var="m">
                                        <option value="${m.name}">${m.name}</option>
                                    </c:forEach>
                                </select></td>
                            <td><input type="number" name ="soluong" value="1" max="1000" min ="0"/></td>
                            <td></td>
                            <td></td>
                        </tr>

                    </table>
                    <button onclick="document.getElementById('form2').prototype.submit()">+</button><br><br>
                    <p style="font-style: oblique;float: left">Tổng tiền : ${requestScope.tongtien}00 VND</p>
                </form>
                <form id="form1" action ="addthongke" method="Post"> 
                    <p style="margin-left : 470px; font-size: large"> Ngày <input type="date" name="date"/></p>
                    Note: <input type="text" name ="note"/>
                    <br><br>
                    Ảnh:   <input type="file" name="file"/>
                    <button style="margin-left:530px; margin-bottom: 30px   " onclick="document.getElementById('form1').prototype.submit()">Lưu hóa đơn</button>
                </form> 
            </div>
        </div>
    </body>


</html>
