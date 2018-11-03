<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tadigital.ecommerce.entity.Vendor" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<% Vendor v= (Vendor) session.getAttribute("EDITVENDOR"); %>
		<form action="edit" method ="post">
			<label>Username</label>
			<input type="text" name="uname" value="<%=v.getUname()%>" readonly />
			<br>
			<label>Password</label>
			<input type="password" name="password" value="<%=v.getPassword()%>" />
			<br>
			<input type="submit" value="Edit" />
		</form>

</body>
</html>