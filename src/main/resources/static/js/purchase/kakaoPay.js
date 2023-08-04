$(function() {
	$('#kakaobutton').click(function() {
		$.ajax({
			url: "/purchase/kakaopay",
			type: "post",
			dataType: "json",
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


