package model.data_structures;

public class MaxColaCP<T extends Comparable<T>> {

	private T primero;
	private T ultimo;
	private Node primerN;
	private Node ultimoN;
	private int cantidad;


	public MaxColaCP()
	{
		primero = null;
		ultimo = null;
		primerN = null;
		ultimoN = null;
		cantidad = 0;
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
			ultimo = (T) i.darItem();
			primero = (T) i.darItem();
		}
		else
		{
			ultimoN.cambiarSiguiente(i);
			ultimoN = ultimoN.darSiguiente();
			ultimo = (T) ultimoN.darItem();
		}
	}

	public T sacarMax()
	{
		if(cantidad == 0)
		{
			return null;
		}
		if(cantidad == 1)
		{
			T valor = primero;
			primerN = null;
			ultimoN = null;
			return primero;
		}
		if(cantidad == 2)
		{
			T valor1 = (T) primerN.darItem();
			T valor2 = (T) primerN.darSiguiente().darItem();
			if(valor1.compareTo(valor2) < 0)
			{
				primerN.cambiarSiguiente(null);
				ultimoN = primerN;
				return valor2;
			}
			else
			{
				primerN = ultimoN;
				return valor1;
			}
		}
		else
		{
			Node actual = primerN.darSiguiente();
			T max = (T) primerN.darItem();
			Node atras = null;
			Node previo = primerN.darSiguiente();
			while(actual!= null)
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
			if(max != ultimo)
			{
				atras.cambiarSiguiente(atras.darSiguiente().darSiguiente());
			}
			else
			{
				atras.cambiarSiguiente(null);
			}
			
			return max;
		}
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
		if(cantidad == 0)
		{
			return true;
		}
		return false;
	}

	public Node darUltimoN()
	{
		return ultimoN;
	}

	public T darUltimo()
	{
		return ultimo;
	}

	public T darPrimero()
	{
		return primero;
	}
	
	public Node darPrimerN() {
		return primerN;
	}
}
