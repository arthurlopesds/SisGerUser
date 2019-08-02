<!DOCTYPE html>
<%@page import = "br.com.model.Cliente" %>
<%@page import = "java.util.List" %>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
<link rel="stylesheet" href="css/styles.css">
<script>

function confirma(pi){
	if(window.confirm("Tem certeza que deseja excluir?"))
	location.href="cliente?i="+ pi;
	
}

</script>
<link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css'>
</head>
<body>
<h1>SISTEMA DE GERENCIAMENTO DE USUÁRIOS</h1>


<%
	Object msg = request.getAttribute("msg");
	if(msg!=null){
		String msgStr = (String)msg;%>
		<div id="alertCad"><i style='font-size:24px' class='far'>&#xf058;</i>       <%out.print(msg);%></div><br>
<%	}
	
%>

<form method="post" action="cliente">
	<fieldset>
	 	<legend>Cadastro</legend>
		Login: <input id = "login" type="text" value="" name="login"/><br><br>
		Senha: <input type="password" value="" name="senha"><br><br>
		Status: <input type="radio" name="statusCad" value="ativo">ativo  <input type="radio" name="statusCad" value="inativo">inativo<br><br>
				 <input type="submit" value="Cadastrar"/><br><br>
	</fieldset>

</form>

<div>

<br>
<table>
<thead>
<tr>
<th>LOGIN</th>
<th>SENHA</th>
<th>STATUS</th>
<th>  </th>
</tr>
</thead>
<tbody>
<tr>
<% 
List<Cliente> lista = (List<Cliente>)request.getAttribute("lista");
int i = 0; 
for (Cliente c:lista){
	
%>
	<td><% out.print(c.getLogin()); %></td>
	<td><% out.print(c.getSenha()); %></td>
	<td><% out.print(c.getStatus()); %></td>
	<td><%out.print("<a id='btn' href='javascript:confirma("+i+")'>excluir</a>"); %></td>
	<%i++; %>
</tr>

<%} %>
</tbody>
</table>
</div>
<br>
<form method="get" action="cliente">
<fieldset>
		<legend>Busca</legend>
		Status: <input type="text" name="status"/>
		<input type="submit" value="Buscar"/>
</fieldset>
</form>

<div>
<br>
<table>

<%
if (request.getAttribute("listaStatus")!=null){
	
	String stsBusca = (String)request.getAttribute("statusBusca"); %>
	<thead>
	<tr>
	<th><%out.print(stsBusca.toUpperCase());%></th>
	</tr>
	</thead>
	

<%
	List<String> lista2 = (List<String>)request.getAttribute("listaStatus");
	for(String status:lista2){
%>
<tbody>
<tr>
<td><%out.print(status + "</br>");%></td>
</tr>
</tbody>
		

	<%}
}
%>
</table>
</div>
</body>
</html>