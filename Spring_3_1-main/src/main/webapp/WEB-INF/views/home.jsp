<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<c:import url="./template/bootStrap.jsp"></c:import>

<link rel="stylesheet" href="./resources/css/test.css">
<title>Home6</title>
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>
	
	<button class="b" >BUTTON </button>
	<button id="btn" class="b">CLICK</button>
	<button id="btn2" class="b">CLICK2</button>
	<h1 id="t">version 3</h1>
	<ol id="result">
		<li>A</li>
	</ol>
	<select id="mon">
	
	</select>

	<script type="text/javascript">
		$("#btn2").click(function(){
			$("#result").append('<a href="#"><li>go</li></a>');
		})
		
		$("#btn").click(function(){
			for(let i =1; i<13; i++){
				$("#mon").appened("<option>"+i+"</option>");
			}
		})
	</script>



 	<!-- <script type="text/javascript">


	let btn2 = document.getElementById("btn2");
	
	btn2.addEventListener("click",function(){
		alert("btn2");
	});
	
	$("#btn").click(function(){
		alert("jquery");
	});
	
	btn.onclick=go;

	
</script>
 -->

</body>
</html>