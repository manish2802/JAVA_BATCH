$(document).ready(function() {

	// for default page
	var defaultpage = $('#nav ul li .active');
	defaultpage.on($.ajax({
		type : "GET",
		url : "wc",
		success : function(responseText) {
			$('#welcome').html(responseText);
		}
	}));

	// for default page
	var defaultpage = $('#nav ul li .active');
	defaultpage.on($.ajax({
		type : "GET",
		url : "home",
		success : function(responseText) {
			$('#content').html(responseText);
		}
	}));

	// Set trigger and container variables
	var trigger = $('#nav ul li a'), container = $('#content');
	// Fire on click
	trigger.on('click', function() {
		// Set $this for re-use. Set target from data attribute
		var $this = $(this), target = $this.data('target');
		console.log(target);
		// Load target page into container
		// container.load(target + '.html');

		$.ajax({
			type : "GET",
			url : target,
			success : function(responseText, textStatus, request) {
				debugger;
				// alert(textStatus+''+request.getResponseHeader('session'));
				console.log(request.getResponseHeader('Content-Type'));
				$('#content').html(responseText);
			}
		});

		// Stop normal link behavior
		return false;
	});
});
