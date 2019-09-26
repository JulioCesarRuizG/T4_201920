package test.data_structures;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.data_structures.TravelTime;
import model.logic.MVCModelo;

public class PruebaColaPrioridad {

	private MVCModelo modelo1;
	private MVCModelo modelo2;
	private MVCModelo modelo3;
	private TravelTime viaje1;
	private TravelTime viaje2;
	private TravelTime viaje3;
	
	@Before
	public void setUp1()
	{
		viaje1 = new TravelTime(800, 2, 100, 200, 10, 1000);
		modelo1 = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo1.generarMuestra(10);
		for(int i=0;i<muestra.size();i++)
		{
			modelo1.darCola().agregar(muestra.get(i));
			modelo1.darHeap().agregar(muestra.get(i));
		}
	}

	@Before
	public void setUp2()
	{
		viaje2 = new TravelTime(900, 1, 500, 600, 20, 500);
		modelo2 = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo2.generarMuestra(100);
		for(int i=0;i<muestra.size();i++)
		{
			modelo2.darCola().agregar(muestra.get(i));
			modelo2.darHeap().agregar(muestra.get(i));
		}
	}

	@Before
	public void setUp3()
	{
		viaje3 = new TravelTime(1000, 1, 1, 2, 1, 100);
		modelo3 = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo3.generarMuestra(1000);
		for(int i=0;i<muestra.size();i++)
		{
			modelo3.darCola().agregar(muestra.get(i));
			modelo3.darHeap().agregar(muestra.get(i));
		}
	}

	@Test 
	public void TestagregarCon10()
	{
		setUp1();
		try
		{
			modelo1.darCola().agregar(viaje1);
			modelo1.darHeap().agregar(viaje1);
			TravelTime esperadoC = modelo1.darCola().darUltimo();
			int valor = modelo1.darHeap().darNumElementos();
			TravelTime esperadoH = modelo1.darHeap().darLLaves()[valor];
			assertEquals("No se ha agregado correctamente: cola 10",viaje1, esperadoC);
			assertEquals("No se ha agregado correctamente: heap 10",viaje1, esperadoH);
		}
		catch(Exception e)
		{
			fail("No se ha agregado correctamente: 1000");
		}
	}

	@Test 
	public void TestagregarCon100()
	{
		setUp2();
		try
		{
			modelo2.darCola().agregar(viaje2);
			modelo2.darHeap().agregar(viaje2);
			TravelTime esperadoC = (TravelTime) modelo2.darCola().darUltimoN().darItem();
			int valor = modelo2.darHeap().darNumElementos();
			TravelTime esperadoH = modelo1.darHeap().darLLaves()[valor];
			assertEquals("No se ha agregado correctamente: 10",viaje2, esperadoC);
			assertEquals("No se ha agregado correctamente: heap 10",viaje2, esperadoH);
		}
		catch(Exception e)
		{
			fail("No se ha agregado correctamente: 100");
		}
	}

	@Test 
	public void TestagregarCon1000()
	{
		setUp3();
		try
		{
			modelo3.darCola().agregar(viaje3);
			modelo3.darHeap().agregar(viaje3);
			TravelTime esperadoC = (TravelTime) modelo3.darCola().darUltimoN().darItem();
			int valor = modelo3.darHeap().darNumElementos();
			TravelTime esperadoH = modelo1.darHeap().darLLaves()[valor];
			assertEquals("No se ha agregado correctamente: 10",viaje3, esperadoC);
			assertEquals("No se ha agregado correctamente: heap 10",viaje3, esperadoH);
		}
		catch(Exception e)
		{
			fail("No se ha agregado correctamente: 1000");
		}
	}

	@Test
	public void TestdarNumElementosCon100()
	{
		setUp2();
		try
		{
			assertEquals("No se ha dado la cantidad adecuada: cola",100, modelo2.darCola().darNumElementos());
			assertEquals("No se ha dado la cantidad adecuada: heap",100, modelo2.darHeap().darNumElementos());
		}
		catch(Exception e)
		{
			fail("Ha fallado el método darNumElementos: 100");
		}
	}

	@Test
	public void TestdarNumElementosCon1000()
	{
		setUp3();
		try
		{
			assertEquals("No se ha dado la cantidad adecuada: cola",1000, modelo3.darCola().darNumElementos());
			assertEquals("No se ha dado la cantidad adecuada: heap",1000, modelo3.darHeap().darNumElementos());
		}
		catch(Exception e)
		{
			fail("Ha fallado el método darNumElementos: 1000");
		}
	}
	
	@Test 
	public void TestEsVacia100()
	{
		setUp2();
		try
		{
			assertEquals("No se ha dado el valor adecuado: cola", false, modelo2.darCola().esVacia());
			assertEquals("No se ha dado el valor adecuado: heao",false, modelo2.darHeap().esVacia() );
		}
		catch(Exception e)
		{
			fail("Ha fallado el método es vacía: 100");
		}
	}
	
	@Test
	public void TestEsVacia1000()
	{
		setUp3();
		try
		{
			assertEquals("No se ha dado el valor adecuado: cola", false, modelo3.darCola().esVacia());
			assertEquals("No se ha dado el valor adecuado: heap", false, modelo3.darHeap().esVacia());
		}
		catch(Exception e)
		{
			fail("Ha fallado el método es vacía: 1000");
		}
	}
	
	@Test
	public void TestSacarMax1000()
	{
		setUp3();
		try
		{
			TravelTime viajemaxC = modelo3.darCola().darMax();
			assertEquals("No se ha sacado el máximo correctamente: cola", viajemaxC, modelo3.darCola().sacarMax());
			TravelTime viajemaxH = modelo3.darHeap().darMax();
			assertEquals("No se ha sacado el máximo correctamente: heap", viajemaxH, modelo3.darHeap().sacarMax()); 
		}
		catch (Exception e) {
			fail("No se ha sacado el mayor correctamente: 10");
		}
	}
	
	@Test
	public void TestSacarMax100()
	{
		setUp2();
		try
		{
			TravelTime viajemaxC = modelo2.darCola().darMax();
			assertEquals("No se ha sacado el máximo correctamente: cola", viajemaxC, modelo2.darCola().sacarMax());
			TravelTime viajemaxH = modelo2.darHeap().darMax();
			assertEquals("No se ha sacado el máximo correctamente: heap", viajemaxH, modelo2.darHeap().sacarMax()); 
		}
		catch (Exception e) {
			fail("No se ha sacado el mayor correctamente: 100");
		}
		
	}
}
