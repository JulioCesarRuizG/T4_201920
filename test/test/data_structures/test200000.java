package test.data_structures;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import model.data_structures.TravelTime;
import model.logic.MVCModelo;


public class test200000 {


		private MVCModelo modelo;
		@Before
		public void setUp1()
		{
			modelo = new MVCModelo(0);
			ArrayList<TravelTime> muestra = modelo.generarMuestra(200000);
			for(int i=0;i<muestra.size();i++)
			{
				modelo.darCola().agregar(muestra.get(i));
				modelo.darHeap().agregar(muestra.get(i));
			}
		}
		@Test
	      public void agregarMax(){
				setUp1();
				TravelTime max = modelo.darHeap().darMax();
				TravelTime agregar = new TravelTime(max.darMeanTravelTime()+1, max.darTrimestre(), max.darOrigenID(), max.darDestinoID(), max.darHourOfDay(), max.darStandardDeviation());
				long inicio = System.currentTimeMillis();
				modelo.darHeap().agregar(agregar);
				long fin= System.currentTimeMillis();
				long duracion= fin-inicio;
				System.out.println("Duracion Heap:"+duracion);
				long inicio2 = System.currentTimeMillis();
				modelo.darCola().agregar(agregar);;
				long fin2= System.currentTimeMillis();
				long duracion2= fin2-inicio2;
				System.out.println("Duracion cola:"+duracion2);
			}
			@Test
			public void agregarMin(){
				setUp1();
				TravelTime min = modelo.darHeap().darMinimo();
				TravelTime agregar = new TravelTime(min.darMeanTravelTime()-1, min.darTrimestre(), min.darOrigenID(), min.darDestinoID(), min.darHourOfDay(), min.darStandardDeviation());
				long inicio = System.currentTimeMillis();
				modelo.darHeap().agregar(agregar);;
				long fin= System.currentTimeMillis();
				long duracion= fin-inicio;
				System.out.println("Duracion Heap:"+duracion);
				long inicio2 = System.currentTimeMillis();
				modelo.darCola().agregar(agregar);;
				long fin2= System.currentTimeMillis();
				long duracion2= fin2-inicio2;
				System.out.println("Duracion cola:"+duracion2);
			}
		@Test
		public void agregarMedio(){
			setUp1();
			TravelTime med = modelo.darHeap().darMedio();
			TravelTime agregar = new TravelTime(med.darMeanTravelTime()+1, med.darTrimestre(), med.darOrigenID(), med.darDestinoID(), med.darHourOfDay(), med.darStandardDeviation());
			long inicio = System.currentTimeMillis();
			modelo.darHeap().agregar(agregar);;
			long fin= System.currentTimeMillis();
			long duracion= fin-inicio;
			System.out.println("Duracion Heap:"+duracion);
			long inicio2 = System.currentTimeMillis();
			modelo.darCola().agregar(agregar);;
			long fin2= System.currentTimeMillis();
			long duracion2= fin2-inicio2;
			System.out.println("Duracion cola:"+duracion2);
		}
		
		@Test
        public void sacarMax(){
              setUp1();
              long inicio = System.currentTimeMillis();
              try {
                  modelo.darHeap().sacarMax();
              } catch (Exception e) {
                  e.printStackTrace();
              }
              long fin= System.currentTimeMillis();
              long duracion= fin-inicio;
              System.out.println("Duracion Heap:"+duracion);
              long inicio2 = System.currentTimeMillis();
              modelo.darCola().sacarMax();
              long fin2= System.currentTimeMillis();
              long duracion2= fin2-inicio2;
              System.out.println("Duracion cola:"+duracion2);
          }
	
	}
