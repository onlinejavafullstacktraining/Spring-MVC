<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Register</title>
</head>
<body>
	<h1>Create Account</h1>
	<form:form method="POST" commandName="register"
		action="registerProcess">
		<table>
			<tr>
				<td><form:label path="firstName">FirstName</form:label></td>
				<td><form:input path="firstName" /></td>
				<td><form:errors path="firstName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="lastName">LastName</form:label></td>
				<td><form:input path="lastName" /></td>
				<td><form:errors path="lastName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="userName">UserName</form:label></td>
				<td><form:input path="userName" /></td>
				<td><form:errors path="userName" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="password">Password</form:label></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="confirmPassword">ConfirmPassword</form:label></td>
				<td><form:password path="confirmPassword" /></td>
				<td><form:errors path="confirmPassword" cssClass="error"></form:errors></td>
			</tr>
			
			<tr>
				<td >
				 <input type="submit" value ="Submit"/>
				</td>
				
			</tr>
		</table>

	</form:form>
</body>
</html>