if (localStorage.activation1 !== "true"){
	alert("Je moet inloggen");
	location.href = "inloggen.html";
}

function page_checker() {
	location.href = "inloggen.html";
}

function uitloggen(){
	localStorage.clear();
	location.href = "index.html";
}

function show_form(active) {
	
	if (active === 'true') { 
		
		document.getElementById('aanvragers_c').innerHTML = '';
			
		var table = document.createElement("table");
			
		fetch('restservices/verzoek/alles')
		.then(response => response.json())
		.then(function vullen(myJson) {
			for(let verzoek of myJson) {
				var verzoeknummer = document.createElement("td");
				var verzoeknaam = document.createElement("td");
				var toevoegen = document.createElement("button");
				toevoegen.setAttribute("type", "button");
				var verwijderen = document.createElement("button");
			    verwijderen.setAttribute("type", "button");
			    verwijderen.setAttribute("class", "verwijder");
				var row = document.createElement("tr");
				
				verzoeknummer.appendChild(document.createTextNode(verzoek.verzoekId));
				verzoeknaam.appendChild(document.createTextNode(verzoek.voorletter + " " + verzoek.tussenvoegsel + " " + verzoek.achternaam));
				toevoegen.appendChild(document.createTextNode("Toevoegen"));
				verwijderen.appendChild(document.createTextNode("Verwijderen"));
				
				row.addEventListener('click', function() {
					document.getElementById("naam").innerHTML = verzoek.voorletter+ " " +verzoek.tussenvoegsel + " " + verzoek.achternaam;
					document.getElementById("geboorte2").innerHTML = verzoek.geboortedatum;
					document.getElementById("zelfbeschrijving").innerHTML = verzoek.zelfbeschrijving;
				});
				
				verwijderen.addEventListener('click', function() {
					var id = verzoek.verzoekId;
					fetch('restservices/verzoek/verwijderen/'+id, {method: 'DELETE'})
					.then(function (request) {
						if (request.ok) {
							console.log("verzoek is verwijderd");
							alert("verzoek is verwijderd!")
						} else { 
							console.log("Er is iets verkeerd");
							alert("Er is een fout opgetreden!!");
						}
					})
				});
				
				toevoegen.addEventListener("click", function toevoegen() {
					var ovoorlet= verzoek.voorletter;
					var otussen = verzoek.tussenvoegsel;
					var oachter = verzoek.achternaam;
					var orol = "lid";
					var ogeslacht = verzoek.geslacht;
					var ogbnm = verzoek.gebruikersnaam;
					var ogeboorte = verzoek.geboortedatum;
					var opostcode = verzoek.postcode;
					var ohuisnum = verzoek.huisnummer;
					var ostraat = verzoek.straatnaam;
					var otoevoeging = verzoek.toevoeging;
					var oplaats = verzoek.plaats;
					var otele = verzoek.telefoonnummer;
					var oemail = verzoek.email;
					var data = {voorletter :ovoorlet,
							tussenvoegsel:otussen,
							achternaam: oachter,
							rol:orol,
							geslacht: ogeslacht,
							gebruikersnaam:ogbnm,
							geboortedatum:ogeboorte,
							postcode:opostcode,
							huisnummer:ohuisnum,
							straatnaam:ostraat,
							toevoeging:otoevoeging,
							plaats:oplaats,
							telefoonnummer:otele,
							email:oemail};
				
					let formData = new FormData();
					for (var k in data) {
						formData.append(k, data[k]);
					};
					let encData = new URLSearchParams(formData.entries());
					
					fetch("restservices/persoon/toevoegen", {method: 'POST', body: encData})
					.then(response => response.json())
					.then(function (myJson){
						for (let response of myJson){
							if (response.toegevoegd == false){
								alert("Het is niet gelukt om een lid toe te voegen!!!");
							} else {
								alert("De lid is succesvol toegevoegd.");
							}
						}
					});
				});
				
				row.appendChild(verzoeknummer);
				row.appendChild(verzoeknaam);
				row.appendChild(toevoegen);
				row.appendChild(verwijderen);
				
				table.appendChild(row);
			}
		})
		
		document.getElementById('aanvragers_c').appendChild(table);
		document.getElementById("toonleden").style.display ='none';
		document.getElementById("toonaanvragen").style.display = 'contents';	
	} else {
		
		document.getElementById('leden_c').innerHTML = '';
		
		var table = document.createElement("table");
		
		fetch('restservices/persoon/leden')
		.then(response => response.json())
		.then(function vull(myJson){
			for (let lid of myJson){
				var lidnummer = document.createElement("td");
				var lidnaam = document.createElement("td");
				var info = document.createElement("button");
			    info.setAttribute("type", "button");
				var verwijderen = document.createElement("button");
				verwijderen.setAttribute("type","button");
				verwijderen.setAttribute("class", "verwijder");
				var row = document.createElement("tr")
				
				lidnummer.appendChild(document.createTextNode(lid.id));
				lidnaam.appendChild(document.createTextNode(lid.voorletter + " " + lid.tussenvoegsel + " " + lid.achternaam));
				info.appendChild(document.createTextNode("info opvragen"));
				verwijderen.appendChild(document.createTextNode("verwijderen"));
				
				
				info.addEventListener('click', function(){
					document.getElementById("voorletter").value = lid.voorletter;
					document.getElementById("tussenvoegsel").value = lid.tussenvoegsel;
					document.getElementById("achternaam").value = lid.achternaam;
					document.getElementById("gebruikersnaam").value = lid.gebruikersnaam;
					document.getElementById("geboorte").value = lid.geboorte;
					document.getElementById("postcode").value = lid.postcode;
					document.getElementById("huisnummer").value = lid.huisnummer;
					document.getElementById("straat").value = lid.straatnaam;
					document.getElementById("toevoeging").value = lid.toevoeging;
					document.getElementById("plaats").value = lid.plaats;
					document.getElementById("telefoon").value = lid.telefoonnummer;
					document.getElementById("email").value = lid.email;
					sessionStorage.setItem('w',lid.wachtwoord);
					if (lid.geslacht === 'M'){
						document.getElementById('M').checked = true;
					} else {
						document.getElementById('V').checked = true;
					}
				});
				
				verwijderen.addEventListener('click', function() {
					var gebruiker = lid.gebruikersnaam;
					fetch('restservices/persoon/verwijderen/'+gebruiker, {method: 'DELETE'})
					.then(function (request) {
						if (request.ok) {
							console.log("lid is verwijderd");
							alert("Lid is verwijderd!")
						} else { 
							console.log("Er is iets verkeerd");
							alert("Er is een fout opgetreden!!");
						}
					})
				});
				
				row.appendChild(lidnummer);
				row.appendChild(lidnaam);
				row.appendChild(info);
				row.appendChild(verwijderen);
				
				table.appendChild(row);
			}
		})
		
		document.getElementById('leden_c').appendChild(table);
		document.getElementById("toonleden").style.display ='contents';
		document.getElementById("toonaanvragen").style.display = 'none';
	}
}

document.querySelector("#wijzigbutton").addEventListener('click', function(){
	var formData = new FormData(document.querySelector('#toonleden'));
	formData.append('rol','lid');
	formData.append('wachtwoord', sessionStorage.w);
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
