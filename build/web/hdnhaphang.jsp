<%-- 
    Document   : hdnhaphang
    Created on : Mar 28, 2021, 10:32:33 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%int i = 1;%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hóa đơn xuất hàng</title>
        <link href="css/HoaDonThongKe.css" rel="stylesheet" type="text/css"/>
        <script>
            function submitForm()
            {
                document.getElementById("frmSearch").submit();
            }
        </script>
    </head> 

    <body>
        <a href="main"><button style="font-size: 20px;background-color: #e2e2e2">&larr;</button></a>
        <div style="background-color: white">
            <div style="float: right">
                <h2>Công ty CPĐT & Thương mại ${requestScope.nameck}</h2>
            </div>
            <br>
            <form action="hdnhap" method="get" id="frmSearch">
                Số phiếu : <input name="sophieu" type="text" value="${requestScope.sophieu}"><br>
                Kho: <select name="chukho" onchange="submitForm()">
                    <c:forEach items="${requestScope.chukho}" var="ck">
                        <c:if test="${ck.name eq requestScope.nameck}">
                            <option selected="select">${requestScope.nameck}</option>
                        </c:if>
                        <c:if test="${ck.name ne requestScope.nameck}">
                            <option value="${ck.id}">${ck.name}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </form>
            <h1 style="text-align: center" >Phiếu Nhập Kho</h1>
            <div style=" width: 70%;margin-left: 15%">
                <form id="form2" action="hdnhap" method="Post">
                    <input type="hidden" name ="sophieu" value="${requestScope.sophieu}"/>
                    <input type="hidden" name ="nameck" value="${requestScope.nameck}"/>
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
                <form id="form1" action ="addnhap" method="Post"> 
                      <input type="hidden" name ="nameck" value="${requestScope.nameck}"/>
                       <input type="hidden" name ="sophieu" value="${requestScope.sophieu}"/>
                    <p style="margin-left : 470px; font-size: large"> Ngày <input type="date" name="date"/></p>
                    Chiết Khấu : <input type="text" name ="chietkhau"/><br><br>
                    Note: <input type="text" name ="note"/>
                    <br><br>
                    Ảnh:   <input type="file" name="file"/>
                    <button style="margin-left:530px; margin-bottom: 30px   " onclick="document.getElementById('form1').prototype.submit()">Lưu hóa đơn</button>
                </form> 
            </div>

        </div>
    </body>


</html>
