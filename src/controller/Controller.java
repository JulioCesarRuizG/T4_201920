package controller;

import java.util.Scanner;

import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = null;;
	}
		
	public void run() throws Exception 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		int dato1 = 0;
		int dato2 = 0;
		int dato3 = 0;
		int ruta = 0;

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					System.out.println("--------- \nCrear archivo \nDar trimestre para cargar el archivo: ");
					ruta = lector.nextInt();
				    modelo = new MVCModelo(ruta); 
					System.out.println("Cola de prioridad y Heap de prioridad creados");
					break;

				case 2:
					System.out.println("---------\n Dar los N elementos mayores en un rango de hora \nNúmero de elementos a buscar: ");
					dato1 = lector.nextInt();
					System.out.println("---------\n hora mínima del elemento: ");
					dato2 = lector.nextInt();
					System.out.println("---------\n hora máxima del elemento: ");
					modelo.darNTiemposDeViajeConPromedioMasLargo(dato1, dato2, dato3);
				case 3: 
					System.out.println("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					System.out.println("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
