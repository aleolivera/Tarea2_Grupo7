package packageTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

public class MatrizAdyacenciaTest {
	
	final byte tamanioMatriz = 4; // Acá elegimos el tamaño 4x4, pero se puede modificar
	MatrizAdyacencia matrizAdyacencia = new MatrizAdyacencia(tamanioMatriz);
	
	@BeforeEach
	public void beforeEachTest() { // Setea toda la matriz en false
		for (int i = 0; i < tamanioMatriz; i++) {
			for (int j = 0; j < tamanioMatriz; j++) {
				matrizAdyacencia.eliminarElemento(i, j);
			}
		}
	}
	
	@Test
	public void agregarElementoTest() {
		
		for (int i = 0; i < tamanioMatriz; i++) {
			for (int j = 0; j < tamanioMatriz; j++) {
				matrizAdyacencia.agregarElemento(i, j);
				assertTrue(matrizAdyacencia.existeElemento(i, j));
			}
		}
		
	}
}
