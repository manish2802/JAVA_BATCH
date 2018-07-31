$(document).ready(function() {
	// process the form
	$("#formo").on('submit', (function(event) {
		
	 
		console.log('hii');
		event.preventDefault(); // avoid to execute the actual submit of the
		// form.
		var fname = $("#fname").val();
		var lname = $("#lname").val();
		var dob = $("#dob").val();
		var gender = $("#gender").val();
		var mno = $("#mno").val();
		var address = $("#address").val();
		var city = $("#city").val();
		var state = $("#state").val();
		var panno = $("#panno").val();
        debugger;
       
		$.ajax({
			type : "POST",
			url : "create",
			data : {
				fname : fname,
				lname : lname,
				dob : dob,
				gender : gender,
				mno : mno,
				address : address,
				city : city,
				state : state,
				panno : panno
			},
			success : function(responseText) {
				debugger;
				console.log(responseText);
				document.getElementById("success").innerHTML = responseText;

			}
		});
	}));
});