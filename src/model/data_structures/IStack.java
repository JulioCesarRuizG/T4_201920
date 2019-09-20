package model.data_structures;

import java.util.Iterator;

public interface IStack<T>{

	/**
	 * Agrega un valor a la pila
	 * @param valor a agregar a la pila
	 */
	public void push(T valor);
	
	/**
	 * Elimina el �ltimo valor de la pila
	 * @return valor eliminado, null en caso contrario
	 */
	public T pop();
	
	/**
	 * Comprueba que la pila est� vac�a
	 * @return true si est� vac�o, false en caso contrario
	 */
	public boolean isEmpty();
	
	/**
	 * Devuelve el tama�o de la pila
	 * @return tama�o de la pila
	 */
	public int size();
	
	/**
	 * Convierte la pila de objetos en un iterator
	 * @return pila de objetos iterable
	 */
	public Iterator<T> iterator();

	
}
