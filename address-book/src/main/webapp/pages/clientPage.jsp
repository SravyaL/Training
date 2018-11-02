<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<html>
<head>
<title>Contacts List</title>
<link href="styles/site.css" rel="stylesheet"/>
</head>
<body>
	<h3>Contacts List</h3>
	<a href="addContact">Add Contact</a>
	<c:choose>
		<c:when test="${contacts eq null or contacts.size() eq 0}">
			<h3>No records found!</h3>
		</c:when>
		<c:otherwise>
			<table>
				<tr>
					<th>Contact#</th>
					<th>Name</th>
					<th>Mobile</th>
					<th>Email</th>
					<th>Date of Birth</th>
				</tr>
				<c:forEach items="${contacts}" var="contact">
				<tr>
				<th>${contact.contactId}</th>
					<th>${contact.fnm}${contact.lnm}</th>
					<th>${contact.mobileNumber}</th>
					<th>${contact.emailId}</th>
					<th>${contact.dateOfBirth}</th>
				</tr>
				</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>
</body>
</html>