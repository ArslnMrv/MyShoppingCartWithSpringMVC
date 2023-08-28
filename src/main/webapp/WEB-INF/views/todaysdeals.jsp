<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <!-- jstl  -->
<!--jstl-- jsp içinde daha az java kodu yazmamızı sağlayan bir yapı -->
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Student-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style2.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Deals</h2>
		<table>

			<tr style="background-color: #7CB342">
				<th>ID</th>
				<th>Name</th>
				<th>Brand</th>
				<th>Color</th>
			</tr>

			<c:forEach items="${dealsList}" var="todaysdeals" varStatus="status">

			    <!-- create an "add" link with todaydeals id -->
            	<c:url var="addLink" value="/cart/add">
            		<c:param name="id" value="${todaysdeals.id}" />
            	</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'lightgray':'#FFFAF0'}">
					<td>${todaysdeals.id}</td>
					<td>${todaysdeals.product.name}</td>
					<td>${todaysdeals.product.brand}</td>
					<td>${todaysdeals.product.color}</td>
					<td>
					   <!-- show the links -->
						<p><a class="add" href="${pageContext.request.contextPath}/cart/add/${todaysdeals.id}">Add To My Cart</a>
				    </td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>