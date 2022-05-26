let index={
	init: function(){
		$("#btn-save").on("click",()=>{//function(){}, ()=>{} this를 바인딩 하기위해
			this.save();
		});
	},
	
	save: function(){
		/*alert("회원가입 완료");*/
		let data={
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
		//ajax호출시 default가 비동기 호출
	$.ajax({//회원가입 수행 요청 
		type:"POST",
		url:"/auth/joinProc",
		data:JSON.stringify(data),//http body 데이터
		contentType:"application/json; charset=utf-8",
		dataType:"json"//서버에서 응답이 왔을 때 모든것이 문자열(생긴것이 JSON이라면)->js 오브젝트로 변경함
	}).done(function(resp){
		alert("회원가입이 완료되었습니다.");
		console.log(resp);
		location.href="/";
	}).fail(function(){
		alert(JSON.stringfy(error));
		
	})//ajax통신을 이용해서 3개 파라미터 json으로 변경하여 insert요청
		/*console.log(data);*/
	}
	
	
	
}

index.init();
