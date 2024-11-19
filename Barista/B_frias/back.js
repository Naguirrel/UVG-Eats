const menuBtn = document.querySelector(".menu-btn");
menuBtn.addEventListener("click", () => {
  console.log("Botón presionado");
  document.body.classList.toggle("open");
});
