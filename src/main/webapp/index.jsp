<!--java ile geliştirilen bir wep uygulaması web.xml ile configure edilir. spring mvc de java classları ile config edilecek bu yuzden dosya silindi -->
<!--tomcat ilk kez index.jsp dosyasını çalıştırır -->
<!-- index.jsp güncellendi -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<%@page isELIgnored="false" %>
<title>Your Shopping Home</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css?version=1">

</head>


<body>
<div class="container">
<h1>YOUR SHOPPING HOME</h1>
                                      <!--h1 ilk başlık, h2 ikinci başlık, p tag ı yeni satır, a tag ı yazılan metni linke dönüştürür-->
<p><a class="normal" href="${pageContext.request.contextPath}/message/">Help</a></p>    <!-- müsteri hizmetleri mesajı  -->
<p><a class="normal" href="${pageContext.request.contextPath}/todaysdeals/">Special Deals For You</a></p>  <!-- kampanyalı urunler listesinin gösterilmesi  -->
<p><a class="normal" href="${pageContext.request.contextPath}/cart/">My Cart</a></p>   <!-- sepet işlemleri, add/update, delete, submit(??)  -->
</div>
</body>
</html>
