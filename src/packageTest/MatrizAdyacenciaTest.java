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
	
	
	/*a. Crear un método llamado agregarElementoTest, que verifique que
	luego de agregar un elemento este elemento exista dentro de la matriz*/
	
	@Test
	public void agregarElementoTest() {
		int posicionColuma=1;
		int posicionFila=2;
		matrizAdyacencia.agregarElemento(posicionFila, posicionColuma);
		assertTrue(matrizAdyacencia.existeElemento(posicionFila, posicionColuma));
		assertTrue(matrizAdyacencia.existeElemento(posicionColuma, posicionFila));
	}
	
	
	/*b. Crear un método llamado agregarElementoSimetriaTest, que
	verifique que luego de agregar un elemento, ese exista en su posición
	opuesta/simétrica. Ejemplo, si agrego un elemento en la posición [2,3],
	verificar que se haya agregado el elemento [3,2]*/
	
	@Test
	public void agregarElementoSimetriaTest() {
		for (int i = 0; i < tamanioMatriz; i++) {
			for (int j = 0; j < tamanioMatriz; j++) {
				matrizAdyacencia.agregarElemento(i, j);
				assertTrue(matrizAdyacencia.existeElemento(i, j));
				assertTrue(matrizAdyacencia.existeElemento(j, i));
			}
		}
	}
	
	
	/*f. Crear un método llamado existenTodosLosElementoTest Verificar que
	si se completan todos las posiciones de la matriz, todos estos elementos
	se hayan guardado correctamente en su posición original y en su
	simetrico.*/
	
	@Test
	public void existenTodosLosElementoTest() {		
		for (int i = 0; i < tamanioMatriz; i++) {
			for (int j = 0; j < tamanioMatriz; j++) {
				matrizAdyacencia.agregarElemento(i, j);
				assertTrue(matrizAdyacencia.existeElemento(i, j));
				assertTrue(matrizAdyacencia.existeElemento(j, i));
			
			}
		}
	}
	
}
