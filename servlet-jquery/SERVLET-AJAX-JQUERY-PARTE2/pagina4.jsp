<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script src="http://d3js.org/d3.v3.min.js"></script>
	
	<style type="text/css">
		#carregando{
			display: none;
		}
	</style>
	
	<script>
		$(document).ready(function(){
			
			$("#botao1").click(function(){
				var vnome = $("#nome").val();
				var vidade = $("#idade").val();
				if(vnome == "" && vidade == ""){
					alert("Please fill out the form");
				}
				else if(vnome == ""){alert("name field is required");}
				else if(vidade == ""){alert("idade field is required");}
				else{
					/*
					 $.post( URL, data, callback);
					 The callback parameter is defined for a function to be executed if the request gets
					 succeeded. O parâmetro callback é definido para uma função a ser executada se a solicitação 
					 for bem-sucedida. This contains two sub parameters, the first one holds the returned
					 data from the requested page and second one holds the status of the request
					*/
					$.post("pagina5.jsp",{nome: vnome, idade: vidade}, function(response, status){
						alert("Response: "+response+"\n\nStatus: "+status);
						$("#conteudo").html(response);
					});
				}
			});
				
		});
	</script>
</head>
<body>

<form name="formulario1" id="formulario1" method="post">
	<table>
		<tr>
			<td>Nome: </td>
			<td><input type="text" name="nome" id="nome" value="" /></td>
		</tr>
		<tr>
			<td>Idade: </td>
			<td><input type="text" name="idade" id="idade" value="" /></td>
		</tr>
		<tr>
			<td><button id="botao1">Enviar</button></td>
		</tr>
	</table>
</form>

<div id="carregando">
	<img alt="" src="imagens/ajax-loader.gif">
</div>

<div id="conteudo">

</div>


</body>
</html>