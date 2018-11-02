<%@ taglib uri = "http://java.sun.com/jstl/core_rt"  prefix="c"%>
<jsp:include page = "header.jsp"/>
<main>
    <h3>Employee List</h3>
    <c:choose>
    <c:when test="${emps==null || emps.size()==0 }">
        <h4>No Employee Found</h4>
    </c:when>
    <c:otherwise>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Basic</th>
            <th>HRA</th>
            <th>Department</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${emps}" var="emp"> 
        <tr>
            <td>${emp.empId}</td>
            <td>${emp.ename}</td>
            <td>${emp.basic}</td>
            <td>${emp.hra}%</td>
            <td>${emp.dept}</td>
            <td>
                <a href = "editEmp?empId=${emp.empId}"><button>Edit</button></a>
                <a href = "deleteEmp?empId=${emp.empId}"><button>Delete</button></a>
            </td>
        </tr>
        </c:forEach>
        <tr>
            <td colspan=6 style="text-align:center;">${emps.size()} Employees(s) Found</td>
        </tr>
    </table>
    </c:otherwise>
    </c:choose>
</main>
<jsp:include page="footer.jsp"/>
