package test.data_structures;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.data_structures.TravelTime;
import model.logic.MVCModelo;

public class PruebaColaPrioridad {

	private MVCModelo modelo;
	@Before
	public void setUp1()
	{
		modelo = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo.generarMuestra(10);
		for(int i=0;i<muestra.size();i++)
		{
			modelo.darCola().agregar(muestra.get(i));
			modelo.darHeap().agregar(muestra.get(i));
		}
	}

	@Before
	public void setUp2()
	{
		modelo = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo.generarMuestra(100);
		for(int i=0;i<muestra.size();i++)
		{
			modelo.darCola().agregar(muestra.get(i));
			modelo.darHeap().agregar(muestra.get(i));
		}
	}

	@Before
	public void setUp3()
	{
		modelo = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo.generarMuestra(1000);
		for(int i=0;i<muestra.size();i++)
		{
			modelo.darCola().agregar(muestra.get(i));
			modelo.darHeap().agregar(muestra.get(i));
		}
	}

	@Test 
	public void agregarCon10()
	{
		setUp1();
	}

	@Test 
	public void agregarCon100()
	{
		setUp2();
	}

	@Test 
	public void agregarCon1000()
	{
		setUp3();
	}
	
	@Test
	public void darNumElementosCon100()
	{
		try
		{
		setUp2();
		assertEquals("No se ha dado la cantidad adecuada: cola",100, modelo.darCola().darNumElementos());
		assertEquals("No se ha dado la cantidad adecuada: heap",100, modelo.darHeap().darNumElementos());
		}
		catch(Exception e)
		{
			fail("Ha fallado el método darNumElementos");
		}
	}
	
	@Test
	public void darNumElementosCon1000()
	{
		
	}
}
