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
			/*jQuery oferece bastante funcionalidades Ajax que podem facilitar a tarefa de enviar e fazer
			  requisições assíncronas no servidor. */
			$("#trazerAjax").on("click", function(e){
				/*
				 As vezes colocamos uma tag de link <a>, mas apenas por motivos de semântica, porque
				 quando clicamos nesse link não queremos abrir uma nova página, queremos abrir uma janela
				 modal por exemplo, um pop-up. Porém uma tag de link <a> ao ser clicada por padrão irá 
				 tentar abrir um novo endereço ou âncora. Para evitar que isso aconteça nós usamos o método
				 preventDefault, que como o nome já dá ideia previne o comportamento default do objeto, ou 
				 seja cancela o comportamento que os elementos geralmente tem na página, então se o compor
				 tamento padrão de um link é abrir uma página, nós vamos cancelar isso.
				*/
				e.preventDefault();
				/*O  método mais simples de jQuery para carregar conteúdo através de Ajax é o load().
				  */
				$("#conteudo").load("pagina3.jsp");
			});
			
			$(document).ajaxStart(function(){
				/*
				 jQuery ajaxStart and ajaxComplete are two functions are very useful to show graphics while
				 the data is loading from server. The ajaxStart method works while the server fullfilling 
				 the service asked to it. The ajaxComplete method is called when the server fulfilled the
				 request. Your website contains a lot of AJAX requests using jQuery and you want to add a
				 global event at the start or finish of the AJAX request, eg add a spinning icon, or 
				 handle(lidar) all(com todos) AJAX erros. If you want to always show a loading element when
				 the ajax request starts and hide it when it's done you could use ajaxStart. Entao quando
				 começa qualquer solicitação ajax essa função é executada.
				*/
				$("#carregando").css("display", "block");
			});
			
			$(document).ajaxComplete(function(){
				//Quando termina qualquer solicitação ajax executa essa função
				$("#carregando").slideUp(1000);
			});
			
			$("#formulario1").on("submit", function(e){
				e.preventDefault();//previnir o comportamento padrão do submit que tentaria enviar para a "action"
				
				/*
				 jQuery $.post() method is used to request data(solicitar dados) from a webpage and to display
				 the returned result (sent from requested page enviado da página solicitada)
				
				 $.post() method sends request along with(junto com) some data using an HTTP POST request
				*/
				
				$.post("aaa.jsp", $("#formulario1").serialize(), function(response){
					$("#conteudo").html(response);
				});
				
			});
				
		});
	</script>
</head>
<body>
https://www.youtube.com/watch?v=Euz3Q7sH8mI
<a href="#" id="trazerAjax" >Carregar Ajax</a>

<div id="carregando">
	<img alt="" src="imagens/ajax-loader.gif">
</div>


<form name="formulario1" id="formulario1">
	<table>
		<tr>
			<td>Nome: </td>
			<td><input type="text" name="nome" id="nome" value="	" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Enviar" /></td>
		</tr>
	</table>
	
	
</form>


<div id="conteudo"><br/>
	
</div>

</body>
</html>