function page_checker() {
	location.href = "inloggen.html";
}


document.getElementById("aanmelden").addEventListener('click', function() {
	var formData = new FormData(document.getElementById("formulierinschrijven"));
	var encData = new URLSearchParams(formData.entries());
	alert();
	    
	fetch('restservices/verzoek/toevoegen', { method:'POST', body:encData} )
	.then(response => response.json())
	.then(function(myJson) {
		if (myJson == "") {
			alert("leeg verzoek");
		} else {
			alert(myJson);
		}; 
	});
});


