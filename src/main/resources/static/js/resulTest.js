document.addEventListener("DOMContentLoaded", () => {
  const sections = document.querySelectorAll(".result-container section");
  sections.forEach((sec, i) => {
    sec.style.opacity = 0;
    setTimeout(() => {
      sec.style.transition = "opacity 0.8s ease";
      sec.style.opacity = 1;
    }, i * 400);//delay para las secciones
  });

  //mensaje final tipo toast
  setTimeout(() => {
    const toast = document.createElement("div");
    toast.textContent = "Resultado cargado con éxito";
    toast.className = "toast-message";
    document.body.appendChild(toast);
    setTimeout(() => toast.remove(), 3000);
  }, 2000);
});


//para animar la barra de progreso segun la puntuacion
document.addEventListener("DOMContentLoaded", () => {
  const scoreElement = document.getElementById("scoreValue"); //span con la puntuacion
  const progressBar = document.getElementById("progressBar"); //div de la barra
  const total = 30;
  const score = parseInt(scoreElement.textContent);
  const percentage = (score / total) * 100;

  //animar la barra desde 0 hasta el porcentaje
  progressBar.style.width = "0%";
  setTimeout(() => {
    progressBar.style.width = percentage + "%";
  }, 500);

  //función flecha para asignar color según rango
  const setColor = (score) => {
    if (score <= 4) return "#27AE60";     // verde mínimo
    if (score <= 9) return "#2ECC71";     // verde intenso
    if (score <= 14) return "#F39C12";    // naranja
    if (score <= 21) return "#E74C3C";    // rojo
    return "#8E44AD";                     // granate oscuro
  };

  progressBar.style.backgroundColor = setColor(score);
});
//uncion para animar el contador de puntuacion
const animateScore = (element, target) => {
  let current = 0;
  const interval = setInterval(() => {
    current++;
    element.textContent = current;
    if (current >= target) clearInterval(interval);
  }, 50);
};
//uso de la funcion
document.addEventListener("DOMContentLoaded", () => {
  const scoreElement = document.querySelector(".result-score span");
  const targetScore = parseInt(scoreElement.textContent);
  scoreElement.textContent = "0"; // inicia desde cero
  animateScore(scoreElement, targetScore);
});

