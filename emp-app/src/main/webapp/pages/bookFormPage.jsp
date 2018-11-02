<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@  taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="header.jsp" />
<main> 
<h1>Emplyoee Form</h1>
<form:form action="saveEmp" modelAttribute="emp"
	method="POST">
	<div>
		<form:label path="empId">EmpID</form:label>
		<c:choose>
			<c:when test="${emp.empId==0}">
				<form:input path="empId" type="number" />
			</c:when>
			<c:otherwise>
				<form:input path="empId" type="number" readonly="true" />
			</c:otherwise>
		</c:choose>

	</div>
	<div>
		<form:label path="ename">EmpName</form:label>
		<form:input path="ename" />
	</div>
	<div>
		<form:label path="basic">Basic</form:label>
		<form:input path="basic" type="decimal" />
	</div>
	<div>
		<form:label path="hra">Hra</form:label>
		<form:input path="hra" type="decimal" />
	</div>
	<div>
		<form:label path="dept">Department</form:label>
		<form:select path="dept">
			<form:option value="">-----Select--------</form:option>
			<form:options items="${possibDept}" />
		</form:select>
	</div>
	<div>
		<form:button type="submit">Save</form:button>
	</div>
</form:form> </main>
<jsp:include page="footer.jsp" />