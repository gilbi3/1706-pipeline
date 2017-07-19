/**
 * 
 */

window.onload = function() {
	loadInfoView();
}


function loadInfoView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
			document.getElementById("infoView").addEventListener('click', loadInfoView, false);
			document.getElementById("register-trigger").addEventListener('click', loadRegisterView, false);
			loadUserInfo();
		}
	}
	xhr.open("GET", "viewUserInfo", true);
	xhr.send();
}

var parsed_user;
var current_user_firstname;
var current_user_lastname;
function loadUserInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("Getting Teacher Info");
			console.log(xhr.responseText);
			parsed_user = JSON.parse(xhr.responseText);
			console.log(parsed_user)
			current_user_firstname = parsed_user["first_name"];
			current_user_lastname = parsed_user["last_name"];
			$('#teachername').text("Name: " + current_user_firstname + " " + current_user_lastname);
			$('#username').text("Username: " + parsed_user["username"]);
			$('#user_id').text("ID: " + parsed_user["id"]);
			$('#password').text("Password: " + parsed_user["pw"]);
			$('#role').text("User Role ID: " + parsed_user["user_role_id"] + " (Teacher)");
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}


function loadRegisterView() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			document.getElementById("view").innerHTML = xhr.responseText;
		}
	}
	xhr.open("GET", "viewRegisterForm", true);
	xhr.send();
}
