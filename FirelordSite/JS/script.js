console.log("estou ativo!");
document.getElementById("bt-img").addEventListener("click", changeBackground);
document.getElementById("signUpForm").addEventListener("submit", formStorage);
function changeBackground(){
    console.log("foi");
}
function formStorage(){
let username = document.getElementById("name").value;
let email = document.getElementById("email").value;
let password = document.getElementById("password").value;
let birthdate = document.getElementById("birthdate").value;
}