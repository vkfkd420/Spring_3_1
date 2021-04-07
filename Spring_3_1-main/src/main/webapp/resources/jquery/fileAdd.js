/**
 * 
 */

let count=0;

$("#add").click(function(){
	if(count < 5){
		let contents = $("#sample").html();
		$("#files").append(contents);
		count++;//count=count+1;
	}else {
		alert("최대 5개만 가능");
	}
});

$("#del").click(function(){
	$("#files").empty();
});

$("#files").on("click",".delete",function(){
	$(this).parent().remove();
	count--;
})