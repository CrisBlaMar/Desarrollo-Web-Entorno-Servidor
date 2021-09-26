package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import exception.ClinicaException;

public class Franquicia{

	private String nombre;
	//Utilizo un hashset ya que no quiero que haya clínicas repetidas y no me importa el orden de estas. 
	private Set <Clinica> clinicas;
	
	
	
	//Constructor
	public Franquicia(String nombre) {
		this.nombre= nombre;
		this.clinicas = new HashSet <Clinica>();
	}



	/***
	 * Método para añadir una clínica común
	 * @throws ClinicaException cuando no puede introducir una clínica por que ya exista
	 */
	public void addClinicaComun (Comun cliComun) throws ClinicaException{
		
		if (!clinicas.add(cliComun)) {
			throw new ClinicaException ("No se ha podido añadir la clínica común");
		}
		clinicas.add(cliComun);
		
		
	}
	
	/***
	 * Método para añadir un clínica quirófano
	 * @throws ClinicaException cuando no puede introducir una clinica, posiblemente por que ya exista
	 */
	public void addClinicaQuirofano (Quirofano cliQuirofano) throws ClinicaException{
		if (!clinicas.add(cliQuirofano)) {
			throw new ClinicaException ("No se ha podido añadir la clínica quirófano");
		}
		clinicas.add(cliQuirofano);
	}
	
	/***
	 * Método para ordenar alfabéticamente las clínicas
	 * @return
	 */
	public String ordenarClinicas () {
		StringBuilder sb = new StringBuilder();
		
		List <Clinica> nCli = new ArrayList <Clinica>(clinicas);
		
		Collections.sort(nCli);
		
		sb.append(nCli);
		
		return sb.toString();
	}
	
	/***
	 * Método para borrar una clínica
	 * @throws ClinicaException salta la excepción cuando no hay ninguna clínica con el código introducido
	 */
	public void borrarClinica (int codigo) throws ClinicaException{
		StringBuilder sb= new StringBuilder();
		boolean fin= false;
		
		Iterator <Clinica> cli = clinicas.iterator();
		while (cli.hasNext() && !fin) {
			Clinica c = cli.next();
			if (c.getCodigo()==codigo) {
				clinicas.remove(c);
				fin=true;
				sb.append("La clínica ha sido borrada con éxito");
			}
		}
		if (fin==false) {
			throw new ClinicaException ("No hay ninguna clínica con esos datos.");
		}
		
	}
	
	/***
	 * Método para buscar una clinica en la localidad introducida
	 */
	
	public String hayClinicaEnLocalidad (String localidad) {
		StringBuilder sb = new StringBuilder();
		
		Iterator <Clinica> cli = clinicas.iterator();
		
		while(cli.hasNext()) {
			Clinica c = cli.next();
			if (c.getLocalidad().equalsIgnoreCase(localidad)) {
				sb.append(c);
			}
		}
		return "En la Localidad de " + localidad + " se encuentra la Clínica: \n"+ sb.toString(); 
		
	}

	
	//ToString
	
	@Override
	public String toString() {
		return "La Franquicia " + nombre + " posee las clínicas: " + clinicas + "\n";
	}


	//HashCode y Equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clinicas == null) ? 0 : clinicas.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Franquicia other = (Franquicia) obj;
		if (clinicas == null) {
			if (other.clinicas != null)
				return false;
		} else if (!clinicas.equals(other.clinicas))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	
	
	
	
	
	
}
