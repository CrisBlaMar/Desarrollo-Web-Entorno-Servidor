package model;

public abstract class Clinica implements Comparable <Clinica>{

	private static int proxCodigo;
	private int codigo;
	private String nombre;
	private String localidad;
	
	//Constructor
	public Clinica() {
		
	}
	
	
	
	
	//Constructor con parámetros
	public Clinica(String nombre, String localidad) {
		this.codigo = proxCodigo;
		proxCodigo++;
		this.nombre = nombre;
		this.localidad = localidad;
	}


	//ToString
	@Override
	public String toString() {
		return "La clínica " + nombre + ", ubicada en la localidad de " + localidad + ", con código " + codigo;
	}


	//HashCode y Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
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
		Clinica other = (Clinica) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	
	//Gets
	public String getNombre() {
		return nombre;
	}


	public int getCodigo() {
		return codigo;
	}

	
	public String getLocalidad() {
		return localidad;
	}

	/***
	 * Método para comparar por orden alfabético
	 */
	@Override
	public int compareTo(Clinica cli) {
		return this.nombre.compareTo(cli.getNombre());
	}


	

	
	
	
	
	
	
	
	
	
	
}
