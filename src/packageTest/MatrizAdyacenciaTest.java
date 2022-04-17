package packageTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frgp.utn.edu.ar.main.MatrizAdyacencia;

public class MatrizAdyacenciaTest {
	final byte tamanioMatriz = 3; // Tama�o m�nimo de Matriz 3x3
	MatrizAdyacencia matrizAdyacencia = new MatrizAdyacencia(tamanioMatriz);
	
	@BeforeEach
	public void beforeEachTest() { // Setea toda la matriz en false
		for (int i = 0; i < tamanioMatriz; i++) {
			for (int j = 0; j < tamanioMatriz; j++) {
				matrizAdyacencia.eliminarElemento(i, j);
			}
		}
	}
	
	
	/*a. Crear un m�todo llamado agregarElementoTest, que verifique que
	luego de agregar un elemento este elemento exista dentro de la matriz*/
	
	@Test
	public void agregarElementoTest() {
	
		matrizAdyacencia.agregarElemento(2,1);
		assertTrue(matrizAdyacencia.existeElemento(2, 1));
		assertTrue(matrizAdyacencia.existeElemento(1, 2));
	}
	
	
	/*b. Crear un m�todo llamado agregarElementoSimetriaTest, que
	verifique que luego de agregar un elemento, ese exista en su posici�n
	opuesta/sim�trica. Ejemplo, si agrego un elemento en la posici�n [2,3],
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
	
	/*c. Crear un m�todo llamado eliminarElementoTest, que verifique que
	luego de eliminar un elemento este elemento no exista dentro de la
	matriz*/
	
	@Test
	public void eliminarElementoTest(){
		
		 matrizAdyacencia.eliminarElemento(2, 1);
		 assertFalse(matrizAdyacencia.existeElemento(2, 1));	 		
	}
	
	
	/*d. Crear un m�todo llamado eliminarElementoSimetricoTest, que
	verifique que luego de eliminar un elemento tambi�n elimine su sim�trico.
	Ejemplo, si elimino el elemento de la posici�n [2,3], verificar que se haya
	eliminado el elemento [3,2]*/
	
	@Test	
	public void eliminarElementoSimetricoTest(){	
		 matrizAdyacencia.eliminarElemento(2, 1);	 
		 assertFalse(matrizAdyacencia.existeElemento(2, 1));
		 assertFalse(matrizAdyacencia.existeElemento(1, 2));	 		
	}
	
//	e. Crear un m�todo llamado contarRelacionesTest que verifique que el 
//	m�todo getCantidadRelaciones de la clase MatrizAdyacencia. Ejemplo:
//	Si agregamos tres elementos [2,3] [1,4] y [1,2] � hay un total de tres 
//	relaciones.
	
	@Test
	public void contarRelacionesTest() {

		matrizAdyacencia.agregarElemento(2, 0);
		matrizAdyacencia.agregarElemento(1, 2);
		matrizAdyacencia.agregarElemento(0, 1);
		
		assertEquals(3, matrizAdyacencia.getCantidadElementos());
	}
	
	
	/*f. Crear un m�todo llamado existenTodosLosElementoTest Verificar que
	si se completan todos las posiciones de la matriz, todos estos elementos
	se hayan guardado correctamente en su posici�n original y en su
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
	
	
	/*g. Crear un m�todo llamado agregarElementoFilaNegativaTest
	que verifique que, si uno quiere agregar un elemento en una fila
	negativa, �ste arroje una excepci�n.*/
	
	@Test
	public void agregarElementoFilaNegativaTest() {
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> matrizAdyacencia.agregarElemento(-1, 0));
	}
	
	//h
	@Test
	public void agregarElementoColumnaNegativaTest(){
		assertThrows(ArrayIndexOutOfBoundsException.class, ()-> matrizAdyacencia.agregarElemento(1, -1));
	}
	
		
	//i	
	@Test
	public void agregarElementoFueraRangoTest(){
		assertThrows(ArrayIndexOutOfBoundsException.class, ()-> matrizAdyacencia.agregarElemento(tamanioMatriz, tamanioMatriz));
	}
	
	
}
