import exception.ClinicaException;
import model.Comun;
import model.Franquicia;
import model.Quirofano;

public class Prueba {

	public static void main(String[] args) {
		
		
		try {
			Franquicia franqui = new Franquicia ("Canitas");

			
			//añadimos clínicas comunes
			Comun comun = new Comun("Luis Montoto", "Sevilla", 6);
			Comun comun1 = new Comun ("Monarca", "Huelva", 9);
			Comun comun2 = new Comun ("Rasar", "Málaga", 4);
			Comun comun3 = new Comun("Atara", "Sevilla", 5);
			Comun comun4 = new Comun ("Fiha", "Córdoba", 3);
			
			
			franqui.addClinicaComun(comun);
			franqui.addClinicaComun(comun1);
			franqui.addClinicaComun(comun2);
			franqui.addClinicaComun(comun3);
			franqui.addClinicaComun(comun4);
			
			

			
			//añadimos clínicas quirófano
			Quirofano quiro = new Quirofano("Gomara", "Sevilla", 3, "PEQUEÑO");
			Quirofano quiro1 = new Quirofano ("Sede", "Huelva", 9, "GRANDE");
			Quirofano quiro2 = new Quirofano ("Maru", "Málaga", 5, "MEDIANO");
			
			franqui.addClinicaQuirofano(quiro);
			franqui.addClinicaQuirofano(quiro1);
			franqui.addClinicaQuirofano(quiro2);
			
			//COMPROBAMOS LOS MÉTODOS
			
			//mostrar las clinicas que hay en la localidad introducida
			System.out.println(franqui.hayClinicaEnLocalidad("MÁLAGA"));
			
			//mostrar de forma ordenada alfabéticamente todas las clínicas
			//System.out.println(franqui.ordenarClinicas());
			
			//borrar la clinica con el código introducido
			//franqui.borrarClinica(2);
			
			System.out.println(quiro.costeConsulta());
			System.out.println(comun.costeConsulta());
			
		}catch (ClinicaException e) {
			System.out.println(e.getMessage());
		}

	}

}
