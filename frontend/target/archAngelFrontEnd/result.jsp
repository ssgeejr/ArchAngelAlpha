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
</style>
</head>

<body>

<table  style="width:100%">
<tr>
<td style="text-align: center; vertical-align: middle; color: #000080;">
<img alt="" src="archangel-logo.png" height="80" width="95">
<h2> OMIM Microservice Sample 
Project ArchAngel </h2>
</td>
</tr>
<tr>
<td class="auto-style2">
<form action="/query" method="post">
	<div class="auto-style1">
	<select name="fieldDos" id="input1" style="width: 125px">
	<option selected>City</option>
	<option>ID</option>
	</select><br>

<input name="fieldDos" type="text" id="input2" style="width: 125px"/><br>

<!--  <button type="submit" onclick="UserAction()">Search</button> -->

<button type="submit" name="Search">Fetch ID</button>


	</div>


</form>

</td>
</tr>
</table>

<h2>&nbsp;</h2>



</p>
<%= request.getAttribute("result").toString() %>




</body>
</html>
