let index = { //여기서는 이벤트 리스너를 바인딩만 하고
	init : function() {
		
		$("#btn-save").on("click", ()=> {
			this.save();
		});
		
		$("#btn-update").on("click", ()=> {
			this.update();
		});
		
	},
	
	save: function() { // 실제 로직은 여기서 실행
		alert("btn-save 로직 실행");
		let data ={
				username : $("#username").val(),
				password : $("#password").val(),
				email : $("#email").val()
		};
		alert("btn-save data");
		
		$.ajax({ // 공식!
			
			type:"post",
			url: "/auth/joinProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",  //http에서는 Content-Type 라고 씀
			dataType: "json"  // 스프링은 응답할때 스트링일 경우 무조건 json으로 응답한다
			
		}).done((resp)=>{
			console.log(resp);
		}).fail((error)=>{
			console.log(error);
		});
		
	},
	
	update: function() { // 실제 로직은 여기서 실행
		alert("btn-update 로직 실행");
	}
}

index.init();