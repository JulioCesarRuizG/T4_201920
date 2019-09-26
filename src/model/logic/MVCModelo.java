package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVReader;

import model.data_structures.MaxColaCP;
import model.data_structures.MaxHeapCP;
import model.data_structures.Node;
import model.data_structures.TravelTime;


/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private MaxColaCP<TravelTime> cola;
	private MaxHeapCP<TravelTime> heap;
	private ArrayList<TravelTime> muestraActual;

	/**
	 * Constructor del modelo del mundo en una cola
	 * @param ruta
	 */
	public MVCModelo(int trimestre)
	{
		if(trimestre == 0)
		{
			cola = new MaxColaCP<TravelTime>();
			heap = new MaxHeapCP<TravelTime>();
		}
		else
		{
			CSVReader reader = null;
			try
			{
				TravelTime agregar = null;
				if(trimestre==1)
					reader= new CSVReader(new FileReader(".data/bogota-cadastral-2018-1-All-HourlyAggregate.csv"));
				else if(trimestre==2)
					reader= new CSVReader(new FileReader(".data/bogota-cadastral-2018-2-All-HourlyAggregate.csv"));
				for(String[] nextLine : reader) {
					if(nextLine.toString().contains("sourceid,dstid,hod,mean_travel_time,standard_deviation_travel_time,geometric_mean_travel_time,geometric_standard_deviation_travel_time"))
					{

					}
					else
					{
						int  inicioID=Integer.parseInt(nextLine[0]);
						int destinoID=Integer.parseInt(nextLine[1]);
						int hora=Integer.parseInt(nextLine[2]);
						double tiempoPromedioEnSegundos=Double.parseDouble(nextLine[3]);
						double desviacionEstandar=Double.parseDouble(nextLine[4]);


						TravelTime i = new TravelTime(tiempoPromedioEnSegundos,trimestre,inicioID,destinoID,hora,desviacionEstandar);
						agregar = i;

						cola.agregar(i);
						heap.agregar(i);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally{
				if (reader != null) {
					try {
						reader.close();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}}
		}
	}




	public ArrayList<TravelTime> generarMuestra(int N){
		int conteo = N;
		ArrayList<TravelTime> arr = new ArrayList<TravelTime>(); 
		int trimestre = (int) ((Math.random() * (4 - 1)) + 1);
		boolean existe = false;
		while(conteo != 0)
		{
			double meanTravelTime = (Math.random() * (5000 - 100))+ 100;
			int sourceId = (int) (Math.random() * (1500 - 1)) + 1;
			int distId = (int) (Math.random() * (1500 - 1)) + 1;
			int hod = (int) (Math.random() * (23 - 0)) + 0;
			double standard_deviation_travel_time = (Math.random() * (1200 - 1)) + 1;
			TravelTime viaje = new TravelTime(meanTravelTime, trimestre, sourceId, distId, hod, standard_deviation_travel_time);
			for(int i = 0 ; i < arr.size() ; i++)
			{
				if (viaje.compareTo(arr.get(i))==0)
				{
					existe = true;
				}
			}
			if(existe == true)
			{
				conteo++;
				existe = false;
			}
			else
			{
				arr.add(viaje);
			}
			conteo --;
		} 
		muestraActual = arr;
		return arr;
	}

	public MaxHeapCP<TravelTime> darHeap() {
		return heap;
	}
	public MaxColaCP<TravelTime> darCola(){
		return cola;
	}

	public void darNTiemposDeViajeConPromedioMasLargo(int N, int inicio, int fin) throws Exception
	{
		long inicioC = System.currentTimeMillis();
		MaxColaCP<TravelTime> tempoC = cola;
		ArrayList<TravelTime> MayoresC = new ArrayList<TravelTime>();
		int conteoC = N;
		while(conteoC != 0)
		{
			TravelTime viaje = tempoC.sacarMax();
			if(viaje.darHourOfDay() >= inicio && viaje.darHourOfDay() <= fin )
			{
				MayoresC.add(viaje);
				conteoC--;
			}
		}
		long endTimeC = System.currentTimeMillis();
		long tiempoCola = endTimeC - inicio;
		
		long inicioH = System.currentTimeMillis();
		ArrayList<TravelTime> MayoresH = new ArrayList<TravelTime>();
		MaxHeapCP<TravelTime> tempoH = heap;
		int conteoH = N;
		while(conteoH != 0)
		{
			TravelTime viaje = tempoH.sacarMax();
			if(viaje.darHourOfDay() >= inicio && viaje.darHourOfDay() <= fin )
			{
				MayoresH.add(viaje);
				conteoC--;
			}
		}
		long endTimeH = System.currentTimeMillis();
		long tiempoHeap = endTimeH - inicioH;
		
		System.out.println("El tiempo de ejecución para la cola de prioridad fue: " + tiempoCola);
		System.out.println("El tiempo de ejecución para el heap de prioridad fue: " + tiempoHeap);
		
	}
	
	
}


