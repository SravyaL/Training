<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@  taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<jsp:include page="./header.jsp" />
<main> 
<h1>Employee Form</h1>
<div class="container">
    <form:form action="saveEmp" modelAttribute="emp"
    method="POST">
        <div class="row">
            <div class="col-25">
                <form:label path="empId">EmployeeId</form:label>
            </div>
            <div class="col-75">
                <c:choose>
                    <c:when test="${emp.empId==0}">
                        <form:input path="empId" type="number" />
                    </c:when>
                    <c:otherwise>
                        <form:input path="empId" type="number" readonly="true" />
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <form:label path="ename">Name</form:label>
            </div>
            <div class="col-75">
                <form:input path="ename" />
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <form:label path="basic">Basic</form:label>
            </div>
            <div class="col-75">
                <form:input path="basic" type="decimal" />
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <form:label path="hra">HRA</form:label>
            </div>
            <div class="col-75">
                <form:input path="hra" type="decimal" />
            </div>
        </div>
        <div class="row">
            <div class="col-25">
                <form:label path="dept">Department</form:label>
            </div>
            <div class="col-75">
                <form:input path="dept"/>
            </div>
        </div>
        <div>
            <form:button type="submit">Save</form:button>
        </div>
    </form:form>
    </div>
</main>
<jsp:include page="./footer.jsp" />
