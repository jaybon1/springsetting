let index = { // 여기서는 이벤트 리스너를 바인딩만 하고
	init : function() {
		
		$("#btn-save").on("click", ()=> { // 리스너
			this.save(); // 콜백
		});
		
	},
	
	save: function() { // 실제 로직은 여기서 실행
		
		let data ={
				title : $("#title").val(),
				content : $("#content").val(),
				userId : $("#userId").val()
		};
		
		$.ajax({ // 주소는 RESTAPI 방식대로 적어야한다 
			
			type:"post",
			url: "/post",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",  // http에서는
																// Content-Type
																// 라고 씀
			dataType: "json"  // 스프링은 응답할때 스트링일 경우 무조건 json으로 응답한다
			
		}).done((resp)=>{
			
			alert("글쓰기 성공");
			console.log(resp);
			location.href="/";
			
		}).fail((error)=>{
			
			alert("글쓰기 실패");
			console.log(error);
			
		});
		
	}
}

index.init();