/**
 * 
 */

window.onload = function() {
	loadUserInfo();
}

var parsed_user;
var current_user_firstname;
var current_user_lastname;
function loadUserInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		console.log(xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200) {
			console.log("Getting Student Info");
			console.log(xhr.responseText);
			parsed_user = JSON.parse(xhr.responseText);
			console.log(parsed_user)
			current_user_firstname = parsed_user["first_name"];
			current_user_lastname = parsed_user["last_name"];
			$('#studentname').text("Name: " + current_user_firstname + " " + current_user_lastname);
			$('#id').text("ID: " + parsed_user["id"]);
			$('#username').text("Username: " + parsed_user["username"]);
			$('#password').text("Password: " + parsed_user["pw"]);
			$('#role').text("User Role ID: " + parsed_user["user_role_id"] + " (Student)");
		}
	}
	xhr.open("GET", "getUserInfo", true);
	xhr.send();
}