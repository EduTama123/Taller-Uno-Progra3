    // Funcionalidad del acordeón
    function toggleAccordion(header) {
    const content = header.nextElementSibling;
    const arrow = header.querySelector('svg');

    if (content.classList.contains('active')) {
    content.classList.remove('active');
    arrow.style.transform = 'rotate(0deg)';
} else {
    // Cerrar otros acordeones
    document.querySelectorAll('.accordion-content.active').forEach(el => {
    el.classList.remove('active');
    el.previousElementSibling.querySelector('svg').style.transform = 'rotate(0deg)';
});

    content.classList.add('active');
    arrow.style.transform = 'rotate(180deg)';
}
}

    // Abrir primer acordeón por defecto
    document.addEventListener('DOMContentLoaded', function() {
    const firstAccordion = document.querySelector('.accordion-header');
    if (firstAccordion) {
    toggleAccordion(firstAccordion);
}
});
