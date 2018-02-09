<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="http://localhost:1020/api/producers/producer/publish" method="post">
<table>
	<tr>
<td>Node Name : <td/>
<td><input type="text" name="node"/><br/> <td/>
<tr/>
<tr>
<td>IP Address : <td/>
<td><input type="text" name="ipAddress"/><br/><td/>
<tr/>
<tr>
<td>Terminal IP : <td/>
<td><input type="text" name="terminalIP"/><br/><td/>
<tr/>
<tr>
<td>Port : <td/>
<td><input type="text" name="port"/><br/><td/>
<tr/>
<tr>
<td>
<input type="submit" value="Submit">
<td/>
<tr/>
</table>
</form>
</body>
</html>