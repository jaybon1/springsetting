let index = { // 여기서는 이벤트 리스너를 바인딩만 하고
	init : function() {
		
		$("#btn-save").on("click", ()=> { // 리스너
			this.save(); // 콜백
		});
		
		$("#btn-login").on("click", ()=> { // 리스너
			this.login(); // 콜백
		});
		
		
	},
	
	save: function() { // 실제 로직은 여기서 실행
		
		let data ={
				username : $("#username").val(),
				password : $("#password").val(),
				email : $("#email").val()
		};
		
		$.ajax({ // 공식!
			
			type:"post",
			url: "/auth/joinProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",  // http에서는
																// Content-Type
																// 라고 씀
			dataType: "json"  // 스프링은 응답할때 스트링일 경우 무조건 json으로 응답한다
			
		}).done((resp)=>{
			
			alert("회원가입 성공");
			location.href="/";
			
		}).fail((error)=>{
			
			alert("회원가입 실패");
			console.log(error);
			
		});
		
	},
	
	login : function() { // 실제 로직은 여기서 실행
		
		let data ={
				username : $("#username").val(),
				password : $("#password").val()
		};
		
		$.ajax({ // 공식!
			
			type:"post", // 아이디 패스워드는 포스트로!
			url: "/auth/loginProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",  // http에서는
																// Content-Type
																// 라고 씀
			dataType: "json"  // 스프링은 응답할때 스트링일 경우 무조건 json으로 응답한다
			
		}).done((resp)=>{
			
			alert("로그인 성공");
			location.href="/";
			
		}).fail((error)=>{
			
			alert("로그인 실패");
			console.log(error);
			
		});
		
	}

}

index.init();