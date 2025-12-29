document.addEventListener("DOMContentLoaded", () => {
  const progressBar = document.getElementById("progressBar");
  const totalQuestions = 10;
  const inputs = document.querySelectorAll(".test-options input[type='radio']");

  inputs.forEach(input => {
    input.addEventListener("change", () => {
      //contador de preguntas
      let answered = 0;
      for (let i = 1; i <= totalQuestions; i++) {
        const radios = document.querySelectorAll(`[name="pregunta${i}"]`);
        if ([...radios].some(r => r.checked)) {
          answered++;
        }
      }
      //calcular porcentaje
      const progress = (answered / totalQuestions) * 100;
      progressBar.style.width = progress + "%";
    });
  });
});
document.addEventListener("DOMContentLoaded", () => {
  const progressBar = document.getElementById("progressBar");
  const totalQuestions = 10;
  const inputs = document.querySelectorAll(".test-options input[type='radio']");
  const resultButton = document.querySelector(".btn-test-submit");

  inputs.forEach(input => {
    input.addEventListener("change", () => {
      let answered = 0;
      for (let i = 1; i <= totalQuestions; i++) {
        const radios = document.querySelectorAll(`[name="pregunta${i}"]`);
        if ([...radios].some(r => r.checked)) {
          answered++;
        }
      }

      const progress = (answered / totalQuestions) * 100;
      progressBar.style.width = progress + "%";

      //accion a relizar al completar las diez preguntas
      if (progress === 100) {
        progressBar.style.backgroundColor = "#219150";
        resultButton.disabled = false; // activa el botón
        alert("¡Has completado todas las preguntas! Ahora puedes calcular tu resultado.");
      }
    });
  });

  //deshabilitamos el boton para el resultado
  resultButton.disabled = true;
});
