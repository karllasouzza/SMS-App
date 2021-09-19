let text = document.getElementById("text");
let content = document.getElementById("content");
let form = document.querySelector("form");

form.onsubmit = (event) => {
  event.preventDefault();
  Chamada.enviaSms(text.value, content.value);
};
