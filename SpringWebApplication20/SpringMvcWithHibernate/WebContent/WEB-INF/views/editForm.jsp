<%@ page import="com.tadigital.entity.Vendor" language="java" %>

<html>
	<head>
		<title>Spring Website</title>
	</head>
	
	<body>
	<%
		Vendor v = (Vendor)session.getAttribute("EDIT_VENDOR");
	%>
		<form action="updateVendor" method="post">
			<label>Name</label>
			<input type="text" name="name" value="<%= v.getName() %>" />
			<br>
			<label>Username</label>
			<input type="text" name="uname" value="<%= v.getUname() %>" />
			<br>
			<br>
			<input type="submit" value="Update" />
		</form>
	</body>
</html>