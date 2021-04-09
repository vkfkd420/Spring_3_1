/**
 * 
 */
let num = $("#comments").attr("title");
getList();
function getList(){
$.get("../comments/commentsList?num="+num,function(data){
	console.log(data);
	$("#comments").html(data.trim());
});
}
$("#comments").on("click", "#remove",function(){
	const ar = [];
	$(".del").each(function(){
		let ch = $(this).prop("checked");
		if(ch){
			ar.push($(this).val());
		}
	});
	
	$.ajax({
		type:"GET",
		url:"../comments/commentsDelete",
		traditional: true,
		data:{num:ar},
		success:function(data){
			alert(data);
		}
		
	});
	
	$.post("../comments/commentsDelete?",{num:ar},function(data){
		alert(data);
	});
	
})


$("#write").click(function(){
	let writer = $("#writer").val();
	let contents = $("#contents").val();
	
	$.post("../comments/commentsInsert", 
	{
		num:num,
		writer:writer,
		contents:contents
		
	}, 
	function(data){
		data = data.trim();
		if(data==1){
			alert('등록 성공');
			$("#writer").val('');
			$("#contents").val('');
			getList();
		}else{
			alert('등록 실패');
		}
	});
	


});