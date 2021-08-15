<%-- 
    Document   : ShowHDNhap
    Created on : Mar 29, 2021, 4:18:38 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%int i = 1;%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
        <link href="css/HoaDonThongKe.css" rel="stylesheet" type="text/css"/>
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
                background-color: white;

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
                overflow: hidden;
                background-size: cover;
                background-position: center;
            }
            .modal-content1 {
                margin: 2% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
                height: 100%;
                width: 30%;/* Could be more or less, depending on screen size */ 
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
    </head>
    <body>
        <div style="background-color: white">
            <div style="float: right;">
                <h3>Công ty CPĐT & Thương mại ${requestScope.chukho.name}</h3>

            </div>
            <br>
            .  Số phiếu : ${hds.sophieu} <br>
            .   Ngày: ${hds.date}
            <h1 style="text-align: center" >Phiếu Nhập Kho</h1>
            <div style=" width: 70%;margin-left: 15%">
                <table>
                    <tr>
                        <th>STT</th>
                        <th>Loại Hàng</th>
                        <th>Số Lượng</th>
                        <th>Đơn giá</th>
                        <th>Thành tiền</th>
                    </tr>
                    <c:forEach items="${requestScope.dhds}" var ="dt">
                        <tr style="border: solid  1px">
                            <td><%=i%></td>
                            <td>${dt.name}</td>
                            <td>${dt.soluong}</td>
                            <td>${dt.dongia}00 VND</td>
                            <td>${dt.total}00 VND</td>
                        </tr>
                        <input type="hidden" <%=i++%>/>
                    </c:forEach>

                </table><br>
                
                <h3>Tổng cộng: ${hds.tongtien}</h3><div style="float: right">Người nhập kho</div>
                <h3>Chiết Khấu: ${hds.chietkhau}</h3>
                <h3>Tổng thanh toán: ${tongthanhtoan}</h3>      

             
                Note : ${hds.note}<br>
                Liên hệ bảo hành: <button class="w3-button" onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;background-color: #00cc33">${chukho.name}</button>
               
                <br> Ảnh: <button class="w3-button" onclick="document.getElementById('id02').style.display = 'block'" style="width:auto;">Show</button>
            </div>
        </div>
        <div id="id01" class="modal" style="overflow-style: scrollbar;">
            <form class="modal-content1 animate">
                <div class="container">
                    <h1>${chukho.name}</h1>
                    <h3>Địa chỉ : ${chukho.sdt}</h3>
                    <h3>Số điện thoại : ${chukho.address}</h3>
                    <button type ="button" onclick="document.getElementById('id01').style.display = 'none'" class="cancelbtn">Xong</button>
                </div>
            </form>
        </div>
    </body>
</html>
