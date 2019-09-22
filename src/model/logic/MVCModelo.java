package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

import model.data_structures.ArregloDinamico;
import model.data_structures.IArregloDinamico;
import model.data_structures.Queue;
import model.data_structures.Viaje;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IArregloDinamico datos;
	private Queue cola;
	
	/**
	 * Constructor del modelo del mundo en una cola
	 * @param ruta
	 */
	public MVCModelo(String ruta)
	{
		loadTravelTimes(ruta, cola);
	
	}
	
	public Queue loadTravelTimes(String ruta, Queue colap)
	{
		CSVReader reader = null;
		try
		{
		Viaje agregar = null;
		reader= new CSVReader(new FileReader(ruta));
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
				double tiempoPromedioGEnSegundos=Double.parseDouble(nextLine[5]);
				double desviacionEstandarG=Double.parseDouble(nextLine[6]);

				Viaje i = new Viaje(inicioID,destinoID,hora,tiempoPromedioEnSegundos,desviacionEstandar,tiempoPromedioGEnSegundos,desviacionEstandarG);
				agregar = i;

				colap.enQueue(i);
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
		}
	}
		return colap;
}
	
	/**
	 * Servicio de consulta de numero de elementos presentes en el modelo 
	 * @return numero de elementos presentes en el modelo
	 */
	public int darTamano()
	{
		return datos.darTamano();
	}

	/**
	 * Requerimiento de agregar dato
	 * @param dato
	 */
	public void agregar(String dato)
	{	
		datos.agregar(dato);
	}
	
	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public String buscar(String dato)
	{
		return datos.buscar(dato);
	}
	
	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public String eliminar(String dato)
	{
		return datos.eliminar(dato);
	}


}
