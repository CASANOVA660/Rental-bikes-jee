<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Our Bikes</title>
    <meta charset="utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico" type="image/x-icon" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
	<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-migrate-1.1.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
	<script src="${pageContext.request.contextPath}/js/scroll_to_top.js"></script>
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.equalheights.js"></script>
	<script src="${pageContext.request.contextPath}/js/superfish.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.mobilemenu.js"></script>
	<script src="${pageContext.request.contextPath}/js/touchTouch.jquery.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.tools.min.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/font/font-awesome.css" type="text/css" media="screen">
</head>
<body>
<div class="main">
    <div class="div-content">  
        <div class="top_section">
            <div class="container_12">
                <div class="grid_12">
                    <div class="clear"></div>
                </div>
            </div>
        </div>

        <!-- Header Section -->
        <header>
            <div class="container_12">
                <div class="grid_12">
                    <h1><a href="index.jsp"><img src="images/logo.png" alt="Gear"></a></h1>
                    <nav>
                        <ul class="sf-menu header_menu">
                            <li><a href="index.jsp">Home<strong></strong></a></li>
                            <li><a href="about.jsp">About<strong></strong></a></li>
                            <li><a href="events.jsp"><span></span>Club events<strong></strong></a></li>
                            <li><a href="gallery.jsp">Gallery<strong></strong></a></li>
                            <li><a href="blog.jsp">Blog<strong></strong></a></li>
                            <li><a href="contact.jsp">Contacts<strong></strong></a></li>
                            <li><a href="signin.jsp">Sign In<strong></strong></a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </header>

        <!-- Bikes Section -->
        <div class="container_12">
            <div class="grid_12">
                <h2>Our Bikes</h2>
                <div class="wrapper">
                    <c:forEach var="bike" items="${bikes}">
                        <div class="grid_4 alpha">
                            <div class="box_1 maxheight7">
                                <img src="images/${Bike.image}" alt="${Bike.name}">
                                <div class="box_1_pad">
                                    <p class="txt1 fleft">${Bike.name}</p>
                                    <p class="txt2">${Bike.description}</p>
                                    <p class="txt3">Available: <c:choose>
                                        <c:when test="${Bike.available}">Yes</c:when>
                                        <c:otherwise>No</c:otherwise>
                                    </c:choose></p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>

        <!-- Footer Section -->
        <footer>
            <div class="footer_priv">
                <div class="container_12">
                    <div class="grid_12">
                        <ul class="soc_icons">
                            <li><a href="#"><i class="icon-facebook"></i></a></li>
                            <li><a href="#"><i class="icon-google-plus"></i></a></li>
                            <li><a href="#"><i class="icon-twitter"></i></a></li>
                            <li><a href="#"><i class="icon-rss"></i></a></li>
                        </ul>
                        <p class="txt_priv"><span class="color2">GEAR</span> &copy; 2013 | <a href="privacy.jsp">Privacy Policy</a></p>
                    </div>
                </div>
            </div>
        </footer>
    </div>
</div>
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
