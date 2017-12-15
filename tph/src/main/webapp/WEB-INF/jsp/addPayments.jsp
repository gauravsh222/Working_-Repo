<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment System</title>
</head>
<body>

<form id="myform" method="post">
<table>
	<tr>
<td>Name : <td/>
<td><input type="text" name="name"/><br/> <td/>
<tr/>
<tr>
<td>Amount : <td/>
<td><input type="text" name="amount"/><br/><td/>
<tr/>

<tr>
<td>Payment Method : <td/>
<td><input type="radio" name="paymentType" value="card" onclick="selectPaymentType(this)"/> Card 
<input type="radio" name="paymentType" value="cheque" onclick="selectPaymentType(this)"/>Cheque
 <td/>
<tr/>
<tr id="number">
<td>Card Number : <td/>
<td><input type="text" name="number"/><br/><td/>
<tr/>
<tr id="creditCardType" >
<td>Credit Card Type : <td/>
<td><input type="text" name="creditCardType"/><br/><td/>
<tr/>
<tr id="chequeNumber">
<td>Cheque Number : <td/>
<td><input type="text" name="chequeNumber"/><br/><td/>
<tr/>
<tr id="chequeIssuedBank">
<td>Cheque Issued Bank : <td/>
<td><input type="text" name="chequeIssuedBank"/><br/><td/>
<tr/>
<tr>
<td  colspan="3" align="center">
<input type="submit" value="Submit">
<td/>
<tr/>
</table>
</form>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 

<script type="text/javascript" >
	function selectPaymentType(paymentType) {
		if(paymentType.value == "cheque") {
			$('#creditCardType').hide();
			$('#number').hide();
			$('#chequeNumber').show();
			$('#chequeIssuedBank').show();
			$('#myform').attr('action', '/tph/cq');
		} else {  
			$('#creditCardType').show();
			$('#number').show();
			$('#chequeNumber').hide();
			$('#chequeIssuedBank').hide();
			$('#myform').attr('action', '/tph/cc');
		}
	}
</script>
</html>