if (localStorage.activation2 !== "true"){
	alert("Je moet inloggen");
	location.href = "inloggen.html";
}

function onload(){
	document.getElementById("tooninfo").style.display = 'contents';
}

onload();


function page_checker() {
	location.href = "inloggen.html";
}

function uitloggen(){
	localStorage.clear();
	location.href = "index.html";
}

function invullen(){
fetch('restservices/persoon/ophalen/'+localStorage.gebruiker)
.then(response => response.json())
.then(function(myJson) {
	for (let persoon of myJson){
		document.getElementById('voorletter').value = persoon.voorletter;
		document.getElementById('tussenvoegsel').value = persoon.tussenvoegsel;
		document.getElementById('achternaam').value = persoon.achternaam;
		document.getElementById('gebruikersnaam').value = persoon.gebruikersnaam;
		document.getElementById('wachtwoord').value = persoon.wachtwoord;
		document.getElementById('geboorte').value = persoon.geboorte;
		document.getElementById('postcode').value = persoon.postcode;
		document.getElementById('huisnummer').value = persoon.huisnummer;
		document.getElementById('straat').value = persoon.straatnaam;
		document.getElementById('toevoeging').value = persoon.toevoeging;
		document.getElementById('plaats').value = persoon.plaats;
		document.getElementById('telefoon').value = persoon.telefoonnummer;
		document.getElementById('email').value = persoon.email;
		if (persoon.geslacht === 'M'){
			document.getElementById('M').checked = true;
		} else {
			document.getElementById('V').checked = true;
		}
	}
});
}
invullen();

document.querySelector("#wijzigbutton").addEventListener('click', function(){
	var formData = new FormData(document.querySelector('#tooninfo'));
	formData.append('rol','lid');
	var encData = new URLSearchParams(formData.entries());
	fetch('restservices/persoon/wijzigen',{method:'PUT', body:encData})
	.then(response => response.json())
	.then(function(myJson){
		for (let persoon of myJson){
			if (persoon.gebruikersnaam === 'ongeldig'){
				alert('De wijziging is niet gelukt');
			} else {
				alert('De wijziging is gelukt');
			}
		}
	})
})