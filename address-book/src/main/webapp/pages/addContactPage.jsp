<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><html>
<head>
<title>Add Contact</title>
<link href="styles/site.css" rel="stylesheet"/>
</head>
<body>
	<h2>Contact Form</h2>


	<form:form modelAttribute="contact" action="addContact" method="POST">
		<table>
			<tr>
				<td><form:label path="fnm">First Name</form:label></td>
				<td><form:input path="fnm" /> <form:errors
						path="fnm"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="lnm">Last Name</form:label></td>
				<td><form:input path="lnm" /> <form:errors
						path="lnm"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="gender">Gender</form:label></td>
				<td><form:radiobuttons items="${genders}" path="gender" /> <form:errors
						path="gender"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="emailId">Email</form:label></td>
				<td><form:input path="emailId" /> <form:errors path="emailId"></form:errors>
				</td>
			</tr>
			<tr>
				<td><form:label path="mobileNumber">Mobile Number</form:label>
				</td>
				<td><form:input path="mobileNumber" /> <form:errors
						path="mobileNumber"></form:errors></td>
			</tr>
			<tr>
				<td><form:label path="dateOfBirth">Date Of Birth</form:label></td>
				<td><form:input type="date" path="dateOfBirth" /> <form:errors
						path="dateOfBirth"></form:errors></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: right">
					<button>Add Contact</button>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>