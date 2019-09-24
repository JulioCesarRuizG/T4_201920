package test.data_structures;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.data_structures.TravelTime;
import model.logic.MVCModelo;

public class MaxHeapCPTest {
    private MVCModelo modelo;
	@Before
	public void setUp1()
	{
		modelo = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo.generarMuestra(10);
		for(int i=0;i<muestra.size();i++)
		modelo.darHeap().agregar(muestra.get(i));
	}
	
	public void setUp2()
	{
		modelo = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo.generarMuestra(100);
		for(int i=0;i<muestra.size();i++)
		modelo.darHeap().agregar(muestra.get(i));
	}
	
	public void setUp3()
	{
		modelo = new MVCModelo(0);
		ArrayList<TravelTime> muestra = modelo.generarMuestra(1000);
		for(int i=0;i<muestra.size();i++)
		modelo.darHeap().agregar(muestra.get(i));
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
}
