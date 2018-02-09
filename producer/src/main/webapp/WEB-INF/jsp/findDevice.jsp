<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr>
<th/>Node Name
<th/>IP Address
<th/>Terminal IP
<th/>Port
</tr>

 <c:forEach var="device" items="${list}" >
        <tr>
            <td><c:out value="${device.node}"/></td>
            <td><c:out value="${device.ipAddress}"/></td>
            <td><c:out value="${device.terminalIP}"/></td>
            <td><c:out value="${device.port}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>