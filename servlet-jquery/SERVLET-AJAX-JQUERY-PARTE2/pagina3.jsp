<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script src="http://d3js.org/d3.v3.min.js"></script>
	
</head>
<body>

<%
DateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
String dataFormatada = formatoData.format(new Date());
%>
<h1><%=dataFormatada %></h1>

<div id="boxTagClouds"></div>
<script>
var dataset = [

    {label: "2004", value: "12700"},
    {label: "2005", value: "13287"},
    {label: "2006", value: "12630"},
    {label: "2007", value: "7086"},
    {label: "2008", value: "8043"},
    {label: "2009", value: "2243"},
    {label: "2010", value: "8103"}
];


var colors = d3.scale.ordinal()
   .range(['#7cb5ec',
       '#FFB340',
       '#99D76A',
       '#FFA5C4',
       '#4F8055',
       '#F2CA7E',
       '#A6918A',
       '#8085e8',
       '#e4d354',
       '#91e8e1',
       '#BCD952',
       '#FFA184']);
   
//Formatação dos dados a partir do Sistema Internacional
var format = d3.format("s");       
   
var margin = {top: 40, right: 40, bottom: 40, left: 80},
width = 705 - margin.right - margin.left,
height = 300 - margin.top - margin.bottom;
var x = d3.scale.linear()
.domain([0,14000])
.range([0, width - (margin.left - margin.right)]);
var y = d3.scale.ordinal()
.domain(d3.range(dataset.length))
.rangeRoundBands([height - margin.top - margin.bottom, 0], .2);

//eixo X
var xAxis = d3.svg.axis()
.scale(x)
.orient("bottom")
.tickFormat(format)
.tickPadding(14);

//eixo Y
var yAxis = d3.svg.axis()
.scale(y)
.orient("left")
.tickSize(0)
.tickPadding(13);

//tooltip
var tooltip = d3.select("body")
.append("div")
.attr("class", "tooltip")
.style("position", "absolute")
.style("z-index", "10")
.style("opacity", 0);

var svg = d3.select("#boxTagClouds").append("svg")
.attr("width", "705px")
.attr("height", "300px")
.attr("class", "bar chart")
.append("g")
.attr("transform", "translate(" + margin.left + "," + margin.top + ")");

var bar = svg.selectAll(".bar")
.data(dataset.map(function(d){ return d.value; }))
	.enter()
	.append("g")
.attr("class", "bar");

//barras
bar.append("rect")
.attr("fill", function(d, i) { return colors(i); })
.attr("y", function(d, i) { return y(i); })
.attr("width", x)
.attr("height", y.rangeBand())

//mostra o tooltip ao passar o mouse sobre as barras
.on("mouseover", function(d, i){ 
	d3.select(this).style("opacity", 0.7)
   tooltip.html(dataset[i].label +": "+ format(dataset[i].value));
   return tooltip.transition()
.duration(50)
.style("opacity", 0.9);
})
.on("mouseout", function(d){       
	d3.select(this).style("opacity", 1)
	return tooltip.style("opacity", 0);
})
.on("mousemove", function(d){
return tooltip.style("top", (d3.event.pageY-10)+"px")
          .style("left", (d3.event.pageX+10)+"px");	
});

//rotulo das barras
bar.append("text")
.attr("text-anchor", "middle")
.attr("x", x)
.attr("y", function(d, i) { return y(i) + height * 0.05; })
.attr("dy", ".15em")
.attr("dx", ".25em")
.text(function(d, i){ return format(dataset[i].value); }); 

//titulo do grafico
svg.append("text")
.attr("x", width/7)
.attr("y", -15)
.text("Pessoas beneficiadas - Programa Segundo Tempo no Estado de Rondônia");

//eixo X
svg.append("g")
.attr("class", "x axis")
.attr("transform", "translate(0," + y.rangeExtent()[1] + ")")
.call(xAxis);

//titulo do eixo X
svg.append("text")
.attr("x", width/4)
.attr("y", height*0.9)
.text("Quantidade de Pessoas Beneficiadas");

//eixo Y
svg.append("g")
.attr("class", "y axis")
.call(yAxis)
	.selectAll("text")
.text(function(d) { return dataset[d].label; });

//titulo do eixo y
svg.append("text")
.attr("transform", "rotate(-90)")
   .attr("y", 0-margin.left)
   .attr("x",0 - (height*0.3))
   .attr("dy", "1em")
   .style("text-anchor", "middle")
   .text("Ano");

</script>
</body>
</html>