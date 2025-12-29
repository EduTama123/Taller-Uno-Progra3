document.addEventListener("DOMContentLoaded", () => {
  const elements = document.querySelectorAll(".hiddenTitle, .hiddenParagraph, .hiddenSubtitle");

  const observer = new IntersectionObserver(entries => {
    entries.forEach(entry => {
      if (entry.isIntersecting) {
        const directions = ["animate-left", "animate-right", "animate-top", "animate-bottom"];
        const randomDirection = directions[Math.floor(Math.random() * directions.length)];

        entry.target.classList.add(randomDirection);
        observer.unobserve(entry.target);
      }
    });
  }, { threshold: 0.5 });

  elements.forEach(el => observer.observe(el));
});




