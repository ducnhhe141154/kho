<%-- 
    Document   : showimg
    Created on : Mar 26, 2021, 2:57:22 PM
    Author     : Admin
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
        <head>
            <link href="css/HoaDonThongKe.css" rel="stylesheet" type="text/css"/>
            <%int i = 1;%>
            <style>

                .search{
                    text-align: center;
                }


                /* Full-width input fields */

                /* Set a style for all buttons */
                body button {
                    background-color: #999999;
                    color: white;
                    padding: 14px 20px;
                    margin: 8px 0;
                    border: none;
                    cursor: pointer;
                    width: 100%;
                }

                button:hover {
                    opacity: 0.8;
                }

                /* Extra styles for the cancel button */
                .cancelbtn {
                    width: auto;
                    padding: 10px 18px;
                    background-color: #999999;
                }



                .container {
                    text-align: center;

                }

                span.psw {
                    float: right;
                    padding-top: 16px;
                }

                /* The Modal (background) */
                .modal {
                    display: none; /* Hidden by default */
                    position: fixed; /* Stay in place */
                    z-index: 1; /* Sit on top */
                    left: 0;
                    top: 0;
                    width: 100%; /* Full width */
                    height: 100%; /* Full height */
                    overflow: auto; /* Enable scroll if needed */
                    background-color: rgb(0,0,0); /* Fallback color */
                    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
                }

                /* Modal Content/Box */
                .modal-content {
                    margin: 2% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                    height: 100%;
                    width: 60%;/* Could be more or less, depending on screen size */ 
                    background-image:url('image/abc.jpg');
                    overflow: hidden;
                    background-size: cover;
                    background-position: center;
                }

                /* The Close Button (x) */
                .close {
                    position: absolute;
                    right: 25px;
                    top: 0;
                    color: #000;
                    font-size: 35px;
                    font-weight: bold;
                }

                .close:hover,
                .close:focus {
                    color: red;
                    cursor: pointer;
                }

                /* Add Zoom Animation */
                .animate {
                    -webkit-animation: animatezoom 0.6s;
                    animation: animatezoom 0.6s
                }

                @-webkit-keyframes animatezoom {
                    from {-webkit-transform: scale(0)} 
                    to {-webkit-transform: scale(1)}
                }

                @keyframes animatezoom {
                    from {transform: scale(0)} 
                    to {transform: scale(1)}
                }

                /* Change styles for span and cancel button on extra small screens */
                @media screen and (max-width: 300px) {
                    span.psw {
                        display: block;
                        float: none;
                    }   
                }

            </style>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Hóa đơn xuất hàng</title>
        </head> 
       
        <body> <div style="background-color: white">
            <div class="main">
                <br>
                <h4>Nhà phân phối Chăn - Ga Gối Đệm Kim Cương Tuấn Anh</h4>
                <h4>Sông Hồng - Everon - Liên Á -Kim Đan</h4>
                <p style="text-align: center;font-size: 40px;font-style:initial ">Phiếu xuất hàng </p>
                <p style="margin-left : 400px; font-size: large;font-style: initial"> Ngày : ${requestScope.hds.date}</p>
                <div style=" width: 70%;margin-left: 15%">
                    <table>
                        <tr>
                            <th>STT</th>
                            <th>Loại Hàng</th>
                            <th>Số Lượng</th>
                            <th>Giá</th>
                        </tr>
                        <c:forEach items="${requestScope.dhds}" var="h">
                            <tr style="border: solid  1px">
                                <td><%=i++%></td>
                                <td>${h.name}</td>
                                <td>${h.soluong}</td>
                                <td>${h.total}00 VND</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td></td>
                            <td>Tổng tiền : ${requestScope.hds.tongtien}00 VND<br><br></td>
                        </tr>
                    </table><br>
                    <div style="float: left"> Note: ${hds.note}<br><br>
                        Ảnh: <button class="w3-button" onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Show ảnh</button>
                    </div>  
                    <div style="float: right">Chủ kho</div>


                    <div id="id01" class="modal" style="overflow-style: scrollbar;">
                        <form class="modal-content animate">

                            <div class="container">
                                <button type ="button" onclick="document.getElementById('id01').style.display = 'none'" class="cancelbtn">Xong</button>
                            </div>
                        </form>
                    </div>
                </div>

            </div>
            </div>

        </body>
   
</html>
