<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Cart-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style2.css?version=1">
</head>
<body>
	<div class="container">
	  <div align="center">
		<h2>My Cart</h2>
		<table>

			<tr style="background-color: #7CB342">
				<th>ID</th>
				<th>Quantity</th>
				<th>Cargo</th>
				<th>Product Name</th>
				<th>Product Brand</th>
				<th>Product Color</th>
			</tr>

			<c:forEach items="${cart}" var="cart" varStatus="status">

				<!-- create an "update" link with Cart.Product id -->
				<c:url var="updateLink" value="/cart/update">
					<c:param name="id" value="${cart.id}" />
				</c:url>

				<!-- create an "delete" link with Cart.Product id -->
				<c:url var="deleteLink" value="/cart/delete">
					<c:param name="id" value="${cart.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'lightgray':'#FFFAF0'}">
					<td>${cart.id}</td>
					<td>${cart.quantity}</td>
					<td>${cart.cargo}</td>
					<td>${cart.product.name}</td>
					<td>${cart.product.brand}</td>
					<td>${cart.product.color}</td>
					<td>
						<!-- show the links -->

						<a class="update" href="${pageContext.request.contextPath}/cart/update/${cart.id}">Update Product</a>
						<a class="delete" href="${pageContext.request.contextPath}/cart/delete/${cart.id}">Delete Product</a>
					</td>

				</tr>

			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/cart/new">Add Product</a>
		<p><a class="normal" href="${pageContext.request.contextPath}/cart/confirm">Confirm Cart</a>
		<p><a class="normal" href="${pageContext.request.contextPath}">HomePage</a>
	  </div>
	</div>
</body>
</html>