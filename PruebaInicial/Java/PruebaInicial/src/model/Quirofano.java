package model;

import exception.ClinicaException;

public class Quirofano extends Clinica implements CosteConsulta {

	private int numSalas;
	private TipoQuirofano tipoQuirofano;
	
	
	
	//Constructor
	public Quirofano() {
			
	}
		
		
		
		
	//Constructor con parámetros
	public Quirofano(String nombre, String localidad, int numSalas, String tipoQuirofano) throws ClinicaException {
		super(nombre, localidad);
		this.numSalas= numSalas;
		try {
			this.tipoQuirofano = TipoQuirofano.valueOf(tipoQuirofano);
		}catch (Exception e) {
			throw new ClinicaException ("El tamaño del quirófano no es válido. Debe ser GRANDE, MEDIANO o PEQUEÑO");
		}
	}
	
	
	//ToString
	@Override
	public String toString() {
		return super.toString()+" de tipo Quirófano, con " + numSalas + " salas, con un tamaño " + tipoQuirofano + "\n";
	}


	@Override
	public int costeConsulta() {
		return 50;
	}
	
	
	
	
	
	
	
	
}
