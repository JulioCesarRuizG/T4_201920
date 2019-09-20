package model.data_structures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Stack<T> implements IStack{

	private Node primero;
	/**
	 * Crea una nueva pila
	 */
	public Stack(Node pPrimero)
	{
		primero = pPrimero;
	}

	/**
	 * Agrega un valor a la pila
	 * @param valor a agregar a la pila
	 */
	public void push(Object valor) {
		Node i = new Node(valor, null);
		if(darPrimero() == null)
		{
			cambiarPrimero(i);
		}
		else
		{
			Node cambiar  = primero;
			cambiarPrimero(i);
			i.cambiarSiguiente(cambiar);
		}
	}

	/**
	 * Elimina el último valor de la pila
	 * @return valor eliminado, null en caso contrario
	 */
	public T pop() {
		if(primero == null)
		{
			return null;
		}
		else
		{
			Node eliminar = primero;
			primero = primero.darSiguiente();
			return  (T) eliminar.darItem();
		}
	}

	/**
	 * Comprueba que la pila esté vacía
	 * @return true si está vacío, false en caso contrario
	 */
	public boolean isEmpty() {
		if(darContenedorPrimero() == null)
		{
			return true;
		}
		else return false;
	}

	/**
	 * Devuelve el tamaño de la pila
	 * @return tamaño de la pila
	 */
	public int size(){
		int tamano = 1;
		Node actual = primero;
		if(darPrimero() == null)
		{
			return 0;
		}
		while(actual.darSiguiente() != null)
		{
			actual = actual.darSiguiente();
			tamano++;
		}
		return tamano;
	}

	/**
	 * Convierte la pila de objetos en un iterator
	 * @return pila de objetos iterable
	 */
	public Iterator iterator() {
		Node actual =  primero;
		Collection lista = new ArrayList<>();
		while(actual.darSiguiente() != null)
		{
			lista.add((Viaje)actual.darItem());
			actual = actual.darSiguiente();
		}
		return lista.iterator();
	}

	/**
	 * Devuelve el primer elemento de la pila
	 * @return primero
	 */
	public T darPrimero()
	{
		return  (T) primero.darItem();
	}

	public Node darContenedorPrimero()
	{
		return primero;
	}
	/**
	 * Cambia el primer elemento de la pila
	 * @param valor por el que se cambia
	 */
	public void cambiarPrimero(Node cambio)
	{
		primero = cambio;
	}
}
