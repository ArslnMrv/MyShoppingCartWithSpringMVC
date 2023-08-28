<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Add Product</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style2.css?version=1">
</head>
<body>
	<div class="container">
		<div align="center">
			<h2>Add / Update Cart</h2>
			<table>
				<form:form modelAttribute="cart" action="saveCart" method="post">
					<form:hidden path="id" />
					<tr>
                    	<td class="cartprop"><b>Product Name:</b></td>
                    	<td><form:input path="product.name" size="30" /></td>
                    	<td><form:errors path="product.name" class="error" /></td>
                    </tr>
					<tr>
                         <td class="cartprop"><b>Product Brand:</b></td>
                         <td><form:input path="product.brand" size="30" /></td>
                         <td><form:errors path="product.brand" class="error" /></td>
                    </tr>
                    <tr>
                        <td class="cartprop"><b>Product Color:</b></td>
                        <td><form:input path="product.color" size="30" /></td>
                        <td><form:errors path="product.color" class="error" /></td>
                    </tr>

					<tr>
						<td class="cartprop"><b>Quantity:</b></td>
						<td><form:input path="quantity" size="30" /></td>
						<td><form:errors path="quantity" class="error" /></td>
					</tr>

					<tr>
						<td class="cartprop"><b>Cargo:</b></td>
						<td><form:input path="cargo" size="30" /></td>
						<td><form:errors path="cargo" class="error" /></td>
					</tr>

					<tr>
						<td></td>
						<td align="center"><form:button>Submit</form:button></td>
						<td></td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>
</body>
</html>