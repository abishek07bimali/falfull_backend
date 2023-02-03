var attempt = 3;

function validate(){
var username = document.getElementById("Email").value;
var password = document.getElementById("Password").value;
if ( Email == "pokhrelsrijan5@gmail.com" && Password == "sp12345"){
alert ("Login successfully");
window.location = "index.html"; 
return false;
}
else{
attempt --;
alert("You have left "+attempt+" attempt;");

if( attempt == 0){
document.getElementById("Email").disabled = true;
document.getElementById("Password").disabled = true;
document.getElementById("Submit").disabled = true;
return false;
}
}
}