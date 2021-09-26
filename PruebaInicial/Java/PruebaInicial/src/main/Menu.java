package main;

import java.util.Scanner;

import model.Comun;
import model.Franquicia;
import model.Quirofano;


public class Menu {

	public static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		int opcion;
		Franquicia franqui = new Franquicia("Canitas");
		
		do {
			mostrarMenu();
			opcion = leerEntero("Introduzca la opción deseada:\n");
			try {
			switch (opcion) {
			case 1:
				String nombre = leerCadena("Introduzca el nombre de la clínica:\n");
				String localidad = leerCadena("Introduzca la localidad:\n");
				int numConsultas = leerEntero("Introduzca el número de consultas que posee la clínica:\n");
				Comun clicomun = new Comun(nombre, localidad, numConsultas);
					franqui.addClinicaComun(clicomun);

			break;
			case 2:
				nombre = leerCadena("Introduzca el nombre de la clínica:\n");
				localidad = leerCadena("Introduzca la localidad:\n");
				numConsultas = leerEntero("Introduzca el número de consultas que posee la clínica:\n");
				String tipo = leerCadena("Introduzca el tipo de sala. Los valores son PEQUEÑO, MEDIANO, GRANDE:\n");
				Quirofano cliquirofano = new Quirofano(nombre, localidad, numConsultas, tipo);
					franqui.addClinicaQuirofano(cliquirofano);

			break;
			case 3:
				
				System.out.println(franqui.ordenarClinicas());
				
			break;
			case 4:
				String consulta= leerCadena("¿Desea saber el precio de la consulta COMUN o QUIROFANO?\n");
				
				if(consulta.equalsIgnoreCase("COMUN")) {
					Comun ccomun = new Comun();
					System.out.println("El precio de la consulta común es de " + ccomun.costeConsulta() + "\n");
				}
				else if (consulta.equalsIgnoreCase("QUIROFANO")) {
					Quirofano cquirofano = new Quirofano();
					System.out.println("El precio de la consulta de quirófano es de " + cquirofano.costeConsulta() + "\n");
				}
				else {
					System.out.println("La opción debe ser COMUN o QUIROFANO");
				}
				
				
			break;
			case 5:
				
				String loca = leerCadena ("Introduzca la localidad por la que desea buscar: \n");
				System.out.println(franqui.hayClinicaEnLocalidad(loca));
				
			break;
			case 6:
				int codigo = leerEntero("Introduzca el código de la clínica que desea borrar:\n");
				franqui.borrarClinica(codigo);
				
			break;
			
			case 7:
				
				System.out.println("Hasta la próxima");
				
			break;
			
			default:
				
				System.out.println("Opción no válida");
				
			break;
			}
			}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		}while (opcion!=7);
		

	}
	
		/**
		 * Para mostrar el menú del programa
		 */
		public static void mostrarMenu() {
			System.out.println("1.- Anadir clínica Común\n"+
							"2.- Anadir clínica Quirófano\n"+
							"3.- Mostrar nombres de las clinicas por orden alfabético\n"+
							"4.- Mostrar el precio de la consulta común o quirófano\n"+
							"5.- Mostrar nombres de las clínicas que hay en la localidad que indique\n"+
							"6.- Borrar clínica por código introducido\n"+
							"7.- Salir del menú\n");
		}
		
		public static int leerEntero(String msg) {
			System.out.println(msg);
			return Integer.parseInt(teclado.nextLine());
		}
		
		public static String leerCadena(String msg) {
			System.out.println(msg);
			return teclado.nextLine();
		}
		
		public static double leerReal(String msg) {
			System.out.println(msg);
			return Double.parseDouble(teclado.nextLine());
		}

}
