package model;

public class Comun extends Clinica implements CosteConsulta {

	private int numConsultas;

	
	//Constructor
	public Comun() {
		
	}
	
	
	
	
	//Constructor con parámetros
	public Comun(String nombre, String localidad, int numConsultas) {
		super(nombre, localidad);
		this.numConsultas= numConsultas;
		
	}

	//ToString
	@Override
	public String toString() {
		return super.toString()+" de tipo Común, con " + numConsultas + " consultas \n";
	}

	/**
	 * Para actualizar el coste de la consulta
	 */
	@Override
	public int costeConsulta() {
		return 20;
		
	}
	
	
	
}
