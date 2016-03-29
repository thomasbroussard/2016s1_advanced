<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@page import="fr.tbr.iamcore.datamodel.Identity"%>
<%@page import="java.util.List"%>
<%@page import="fr.tbr.iamcore.services.dao.impl.IdentityJDBCDAO"%>
<%@page import="fr.tbr.iamcore.services.dao.IdentityDAOInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
</head>
<body>
	<p><%="output test"%></p>
	<p>output test</p>
	<%if (session != null) {%>
	<h1>You're connected</h1>
	<%} else {%>
	<h1>You have to connect again</h1>
	<%}	%>
	<ul>
		<%	IdentityDAOInterface dao = new IdentityJDBCDAO();
			List<Identity> identities = dao.readAll();
			for (Identity identity : identities) {	%>
		<li><%=identity.toString()%></li>
		<%	}%>
	</ul>
	
	<table>
		<thead>
			<tr>
				<td>Index</td>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Date</td>
			</tr>
		
		</thead>
		<tbody>
		<% for (Identity identity : identities) {	%>
		<tr>
				<td><%=identity.getId() %></td>
				<td><%=identity.getFirstName() %></td>
				<td><%=identity.getLastName() %></td>
				<td><%=identity.getEmail() %></td>
				<td><%=String.valueOf(identity.getBirthDate()) %></td>
			</tr>
		<%	}%>
		</tbody>
	
	
	</table>
</body>
</html>