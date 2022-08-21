<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
		<tr>
			<th>Id</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Photo</th>
		</tr>
		<c:if test="${! empty registers}">
			<tr>
				<td>${registers.id}</td>
				<td>${registers.firstName}</td>
				<td>${registers.lastName}</td>
				<td>${registers.email}</td>
				<td><img width="100" height="100" src="data:image/jpeg;base64,${registers.base64}"></td>
			</tr>
		</c:if>
	</table>
</body>
</html>