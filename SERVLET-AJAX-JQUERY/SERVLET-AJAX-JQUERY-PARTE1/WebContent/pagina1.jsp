<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/estiloGeral.css">
	<link rel="stylesheet" href="css/base/jquery.ui.all.css">
	<link rel="stylesheet" href="css/jquery.dataTables.css">
	<link rel="stylesheet" href="css/jquery.ketchup.css">
	
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery.ui.core.js"></script>
	<script type="text/javascript" src="js/jquery.ui.widget.js"></script>
	<script type="text/javascript" src="js/jquery.ui.tabs.js"></script>
	<script type="text/javascript" src="js/jquery.ui.dialog.js"></script>
	<script type="text/javascript" src="js/jquery.ui.button.js"></script>
	<script type="text/javascript" src="js/jquery.ui.mouse.js"></script>
	<script type="text/javascript" src="js/jquery.ui.position.js"></script>
	<script type="text/javascript" src="js/jquery.ui.draggable.js"></script>
	<script type="text/javascript" src="js/jquery.ddslick.js"></script>
	<script type="text/javascript" src="js/jquery.ddslick.js"></script>
	<script type="text/javascript" src="js/jquery.ketchup.all.min.js"></script>
	
	
	<script type="text/javascript" src="js/jquery.dataTables.js"></script>
	<script>
		$(document).ready(function(){
			$("#tabelaAnimais").dataTable();
		});
		
		
		$(function(){
			
			$("#tabs").tabs();//tabs=guias -> A single content area with multiple panels, each associated with a header in a list
			$("#dialogo").dialog();
			
			//Botões Topo da Página
			$("#btnNovo").button();
			$("#btnSalvar").button();
			$("#btnAtualizar").button({disabled: true});
			$("#btnExcluir").button({disabled: true});
			
			
			// ddSlick ComboBox
			var ddSlickData = [
				{
					text: "Administrador",
					value: 1,
					selected: false,
					description: "Administrador"
				},
				{
					text: "Contador",
					value: 2,
					selected: false,
					description: "Contador"
				},
				{
					text: "Operador",
					value: 3,
					selected: false,
					description: "Operador"
				}
			]
			
			$("#ddSlickComboBox").ddslick({
				data: ddSlickData,
				width: 300,
				selectText: "Escolha:"

			});
			
			//JQuery Ketchup
			$("#form1").ketchup();
			
		});
	</script>
</head>
<body>

	<div id="botoesTopoDaPagina">
		<input id="btnNovo" type="reset" value="Novo" />	
		<input id="btnSalvar" type="submit" value="Salvar" />
		<input id="btnAtualizar" type="submit" value="Atualizar" />
		<input id="btnExcluir" type="submit" value="Excluir" />
	</div>
	
	<!--
	********************************************************************************************************
 	********************************************************************************************************
 	********************************************************************************************************
 	-->
 	

	<div id="tabs">
	<!--
	********************************************************************************************************
 	********************************************************************************************************
 	********************************************************************************************************
 	-->
		<ul>
			<li><a href="#a">Menu1</a></li>
			<li><a href="#b">Menu2</a></li>
			<li><a href="#c">Menu3</a></li>
		</ul>
		<!--
		********************************************************************************************************
	 	********************************************************************************************************
	 	********************************************************************************************************
	 	-->
		<form action="">
			<div id="a">
				<table>
					<tr>
						<td><label>Selecione:</label>			
						<td>
							<div id="ddSlickComboBox"></div>
						</td>
					</tr>
					<tr>
						<td><label for="nomeUsuario">Nome:</label></td>
						<td><input id="nomeUsuario" type="text" name="nome" data-validate="validate(required, username, minlength(3))"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Confirmar" /></td>
					</tr>
				</table>
			</div>
		</form>
		<!--
		********************************************************************************************************
	 	********************************************************************************************************
	 	********************************************************************************************************
	 	-->
		<div id="b">
			<table id="tabelaAnimais">
				<thead>
					<tr>
						<td>Nome</td>
						<td>Animal</td>
						<td>Idade</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>Joice</td>
						<td>Vaca</td>
						<td>23</td>
					</tr>
					<tr>
						<td>Joice</td>
						<td>Vaca</td>
						<td>23</td>
					</tr>
					<tr>
						<td>Juliana</td>
						<td>Cabra</td>
						<td>23</td>
					</tr>
				</tbody>
			</table>
		</div>
		<!--
		********************************************************************************************************
	 	********************************************************************************************************
	 	********************************************************************************************************
	 	-->
	 	<form action="">
			<div id="c">
				<table>
					<tr>
						<td><label>Selecione:</label>			
						<td>
							<select>
								<option value="">Cenoura</option>
								<option value="">Repolho</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label>Nome:</label></td>
						<td><input type="text" name="nome" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Confirmar" /></td>
					</tr>
				</table>
			</div>
		</form>
	<!--
	********************************************************************************************************
 	********************************************************************************************************
 	********************************************************************************************************
 	-->
	</div>
	<!--
	********************************************************************************************************
 	********************************************************************************************************
 	********************************************************************************************************
 	-->
 	<div id="dialogo" title="Quer mandar bala">
 		<p>Vá em frente</p>
 	</div>
	
</body>
</html>