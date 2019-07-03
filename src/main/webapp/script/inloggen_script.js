function inloggen(){
	
	let formData = new FormData(document.querySelector("#login_form"));
	let encData = new URLSearchParams(formData);
	
	fetch('restservices/persoon/inloggen', {method:'POST', body: encData})
	.then(response => response.json())
	.then(function (myJson){
		
		for (persoon of myJson){
			
			if (persoon.rol === "admin"){
				
				localStorage.setItem("activation1", "true");
				location.href = "admin-pagina.html";
				
			} else if (persoon.rol === "lid"){
				
				localStorage.setItem("gebruiker", persoon.gebruikersnaam)
				localStorage.setItem("activation2", "true");
				location.href = "lid-pagina.html";
				
			} else {
				alert("Inloggegevens zijn fout!!!");
			}
		}
	});
};

function annuleren(){
	location.href = "index.html";
};

