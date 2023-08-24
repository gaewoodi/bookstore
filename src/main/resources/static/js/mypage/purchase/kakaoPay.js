$(function() {
	$('#kakaobutton').click(function() {
		let regIdValue = document.querySelector(".regId").value;

		$.ajax({
			url: "/purchase/kakaopay",
			type: "post",
			dataType: "json",
			data: {
				"regIdValue": regIdValue
			},
			success: function(data) {
				var box = data.next_redirect_pc_url;
				window.open(box);
			},
			error: function(error) {
				alert(error);
			}
		});
	});
});


