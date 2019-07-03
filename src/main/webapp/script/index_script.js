function hide(){
	var ingelogd = localStorage.ingelogd;
	
	if (ingelogd === "true"){
		document.getElementById("admin_menu").style.display = 'block';
		document.getElementById("huizer_menu").style.display = 'block';
		document.getElementById("uitloggen").style.display = 'block';
		document.getElementById("inloggen").style.display = 'none';
	} else {
		document.getElementById("admin_menu").style.display = 'none';
		document.getElementById("huizer_menu").style.display = 'none';
		document.getElementById("uitloggen").style.display = 'none';
		document.getElementById("inloggen").style.display = 'block';
	}
}

hide();

function page_checker() {
	location.href = "inloggen.html";
}

function uitloggen() {
	localStorage.setItem("ingelogd", "false");
	hide();
}