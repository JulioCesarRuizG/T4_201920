package model.data_structures;

public class MaxColaCP<T extends Comparable<T>> {

	MaxColaCP control;
	private T primero;
	private T ultimo;
	private Node primerN;
	private Node ultimoN;
	private int cantidad;
	
	
	public MaxColaCP()
	{
		control = new MaxColaCP();
	}
	
	public int darNumElementos()
	{
		return cantidad;
	}
	
	public void agregar(T dato) 
	{
		Node i = new Node(dato, null);
		cantidad++;
		if(primerN == null)
		{
			primerN = i;
			ultimoN =  i;
		}
		else
		{
			ultimoN.cambiarSiguiente(i);
			ultimoN = ultimoN.darSiguiente();
		}
	}
	
	public T sacarMax()
	{
		Node actual = primerN.darSiguiente();
		T max = (T) primerN.darItem();
		Node atras = null;
		Node previo = null;
		while(actual != null)
		{
			T valor1 = (T) actual.darItem();
			if(valor1.compareTo(max)>0)
			{
				atras = previo;
				max = valor1;
			}
			previo = actual;
			actual = actual.darSiguiente();
		}
		atras.cambiarSiguiente(atras.darSiguiente().darSiguiente());
		return max;
	}
	
	public T darMax()
	{
		
		Node actual = primerN.darSiguiente();
		T max = (T) primerN.darItem();
		while(actual != null)
		{
			T valor1 = (T) actual.darItem();
			if(valor1.compareTo(max)>0)
			{
				max = valor1;
			}
			actual = actual.darSiguiente();
		}
		return max;
	}
	
	public boolean esVacia()
	{
		
	}
}
