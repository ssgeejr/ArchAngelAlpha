<%@ page
		language="java"
		contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"
		%>
<%
	String searchresult = "";
	try{searchresult = request.getAttribute("result").toString();}catch(Exception ex){}
%>
<!DOCTYPE html>
<html>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<style type="text/css">
.auto-style1 {
	text-align: center;
}
.auto-style2 {
	border: 1px solid #000080;
}
select , input{
    background: #EAF3D1;}
button {
    background-color: #EAF3D1;}

</style>
</head>

<body>

<table  style="width:100%">
<tr>
<td style="text-align: center; vertical-align: middle; color: #000080;">
<img alt="" src="archangel-logo.png" height="80" width="95">
<h2> OMIM Microservice Sample Project: ArchAngel </h2>
</td>
</tr>
<tr>
<td class="auto-style2">
<form action="/query" method="post">
	<div class="auto-style1">
	<select name="fieldUno" id="input1" style="width: 125px">
	<option selected value="0">City</option>
	<option value="1">ID</option>
	</select><br>
	<input name="fieldDos" type="text" id="input2" style="width: 125px"/><br>
	<button type="submit" style="width: 115px" name="Search">Search</button>	
	</div>
</form>
</td>
</tr>
</table>
<div class="auto-style1">
</p>
<%= searchresult %>
</div>



</body>
</html>
