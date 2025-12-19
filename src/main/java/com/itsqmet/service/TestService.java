package com.itsqmet.service;

import com.itsqmet.entity.TestAnsiedad;
import com.itsqmet.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private TestRepository testRepository;

    //Listar todos los tests
    public List<TestAnsiedad> mostrarTests(){
        return testRepository.findAll();
    }

    // Buscar test por id
    public Optional<TestAnsiedad> buscarTest(Long id) {
        return testRepository.findById(id);
    }

    // Guardar nuevo test (CON CÁLCULO DE PUNTUACIÓN)
    public TestAnsiedad guardarTest(TestAnsiedad testAnsiedad) {
        // Calcular puntuación total
        int puntuacion = testAnsiedad.getPregunta1() + testAnsiedad.getPregunta2() +
                testAnsiedad.getPregunta3() + testAnsiedad.getPregunta4() +
                testAnsiedad.getPregunta5() + testAnsiedad.getPregunta6() +
                testAnsiedad.getPregunta7() + testAnsiedad.getPregunta8() +
                testAnsiedad.getPregunta9() + testAnsiedad.getPregunta10();

        testAnsiedad.setPuntuacionTotal(puntuacion);

        // Determinar nivel de ansiedad basado en la puntuación
        String nivel;
        if (puntuacion <= 4) {
            nivel = "Ansiedad Mínima";
        } else if (puntuacion <= 9) {
            nivel = "Ansiedad Leve";
        } else if (puntuacion <= 14) {
            nivel = "Ansiedad Moderada";
        } else if (puntuacion <= 21) {
            nivel = "Ansiedad Severa";
        } else {
            nivel = "Ansiedad Muy Severa";
        }

        testAnsiedad.setNivelAnsiedad(nivel);

        return testRepository.save(testAnsiedad);
    }

    // Actualizar test por id
    public TestAnsiedad actualizarTest(Long id, TestAnsiedad testAnsiedad) {
        TestAnsiedad testExistente = buscarTest(id)
                .orElseThrow(() -> new RuntimeException("El Test de Ansiedad no existe"));

        // Actualizar cada respuesta
        testExistente.setPregunta1(testAnsiedad.getPregunta1());
        testExistente.setPregunta2(testAnsiedad.getPregunta2());
        testExistente.setPregunta3(testAnsiedad.getPregunta3());
        testExistente.setPregunta4(testAnsiedad.getPregunta4());
        testExistente.setPregunta5(testAnsiedad.getPregunta5());
        testExistente.setPregunta6(testAnsiedad.getPregunta6());
        testExistente.setPregunta7(testAnsiedad.getPregunta7());
        testExistente.setPregunta8(testAnsiedad.getPregunta8());
        testExistente.setPregunta9(testAnsiedad.getPregunta9());
        testExistente.setPregunta10(testAnsiedad.getPregunta10());

        // Recalcular puntuación y nivel
        return guardarTest(testExistente);
    }

    // Eliminar test por id
    public void eliminarTest(Long id) {
        TestAnsiedad testAnsiedad = buscarTest(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "El Test de Ansiedad no existe"));
        testRepository.delete(testAnsiedad);
    }
}
