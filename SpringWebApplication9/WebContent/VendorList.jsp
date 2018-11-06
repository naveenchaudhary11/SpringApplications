<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.tadigital.ecommerce.entity.Vendor" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<%! List<Vendor> vlist = null ; %>
	<%   vlist = (List<Vendor>) session.getAttribute("VENDORS"); %>
	
	
	
	
			<table style="width:10%">
  				<tr>
    				<th>Name</th>
    				<th></th>
    				<th></th>
  				</tr>
  				
  				<% 
  					for( Vendor v: vlist) {
  				%>
 				<tr>
    				<td><%=v.getUname() %></td>
    				<td><a href="vendoredit<%= v.getUname()%>">Edit</a></td>
    				<td><a href="vendordelete<%= v.getUname()%>">Delete</a></td>
 				</tr>
 				<%
  					}
 				
 				%>
 				
			</table>
			
		


</body>
</html>