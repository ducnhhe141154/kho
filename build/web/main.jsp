<%-- 
    Document   : main
    Created on : Mar 15, 2021, 6:57:31 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <title>Home</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lato">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <style>
        body,h1,h2,h3,h4,h5,h6 {font-family: "Lato", sans-serif}
        .w3-bar,h1,button {font-family: "Montserrat", sans-serif}
        .fa-anchor,.fa-coffee {font-size:200px}
        body,h1,h2,h3,h4,h5,h6 {font-family: "Raleway", sans-serif}

        body, html {
            height: 100%;
            line-height: 1.8;
        }

        /* Full height image header */
        .bgimg-1 {
            background-position: center;
            background-size: cover;
            background-image: url("image/background.png");
            min-height: 100%;
        }

        .w3-bar .w3-button {
            padding: 16px;
        }
    </style>
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}

        /* Set a style for all buttons */
        button {
            background-color: #4CAF50;
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
        table tr td{
            text-align: center;
            border: 1px solid;
        }
        table{
            width: 100%;
        }
        h1{ 
            text-align: center;
        }
        /* Center the image and position the close button */


        .container {
            padding: 10px;
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
            padding-top: 60px;
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
            border: 1px solid #888;
            width: 30%; /* Could be more or less, depending on screen size */
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
    <body>
        <header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
            <div class="w3-display-left w3-text-white" style="padding:48px">
                <span class="w3-jumbo w3-hide-small">Chăn Ga Tấn Dũng</span><br>
                <span class="w3-large">Chất lượng tạo thương hiệu</span>
                <p><a href="https://www.youtube.com/" class="w3-button w3-white w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-off">Learn more and start today</a></p>
            </div>

        </header>
        <div class="w3-top">
            <div style="background-color: #cccccc">
                <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-red" href="javascript:void(0);" onclick="myFunction()" title="Toggle Navigation Menu"><i class="fa fa-bars"></i></a>
                <a href="main" class="w3-bar-item w3-button w3-padding-large w3-white">Home</a>
                <div class="w3-dropdown-hover w3-hide-small">
                    <button class="w3-button" title="Hóa Đơn Nhập">Hóa đơn nhập(Inport)<i class="fa fa-caret-down"></i></button>     
                    <div class="w3-dropdown-content w3-card-4 w3-bar-block">
                        <a href="hdnhap" class="w3-bar-item w3-button">Thêm hóa đơn nhập hàng</a>
                        <a href="searchnhap" class="w3-bar-item w3-button">Tra cứu</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-hide-small">
                    <button class="w3-button" title="Hóa Đơn Xuất">Hóa đơn xuất(Export)<i class="fa fa-caret-down"></i></button>     
                    <div class="w3-dropdown-content w3-card-4 w3-bar-block">
                        <a href="hdthongke" class="w3-bar-item w3-button">Thêm thống kê hôm nay</a>
                        <a href="searchxuat" class="w3-bar-item w3-button">Tra cứu</a>
                         <a href="TKThang.jsp" class="w3-bar-item w3-button">Doanh thu tháng</a>
                    </div>
                </div>
                <div class="w3-dropdown-hover w3-hide-small">
                    <button class="w3-button" onclick="document.getElementById('id01').style.display = 'block'" style="width:auto;">Kho</button>
                    <div id="id01" class="modal" style="overflow-style: scrollbar;">
                        <form class="modal-content animate" action="/action_page.php" method="post">
                            <div class="container">
                                <h1>Kho</h1>
                                <table style="border: 2px solid;size: 900px">
                                    <tr>
                                        <td>Id</td>
                                        <td>Loại hàng</td>
                                        <td>Số lượng trong kho</td>
                                    </tr>
                                    <c:forEach items="${requestScope.kho}" var ="k">
                                        <tr style="text-align: center;border: 1px solid; padding: 8px;">
                                            <td>${k.idsp}</td>
                                            <td>${k.namesp}</td>
                                            <td>${k.soluong}</td>
                                        </tr>
                                    </c:forEach>
                                </table>
                                      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Xong</button>
                            </div>
                        </form>
                    </div>

                </div>
                <div class="w3-dropdown-hover w3-hide-small">
                    <a href="login.jsp"><button class="w3-button">Đăng xuất(${sessionScope.account.username})</button></a> 
                </div>
            </div>
        </div>

    </body>
</html>
