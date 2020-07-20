let index = {
	init : function() {
		let _this = this;
		$("#btn-save").on("click", function() {
			alert("btn-save 클릭됨");
			console.log(this);
			_this.save();
		});
	},
	
	save: function() {
		alert("btn-save 로직 실행");
	}
}

index.init();