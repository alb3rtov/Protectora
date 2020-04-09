//D2_GP02 Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Solicitud {
	// Atributos
	private String nombre;
	private int tipoSolicitud;
	private int telefono;
	
	// Constructor
	public Solicitud(String nombre, int tipoSolicitud, int telefono) {
		this.nombre = nombre;
		this.tipoSolicitud = tipoSolicitud;
		this.telefono = telefono;
	}
	
	// Getters y Setters
	public String getNombre() {
		return nombre;
	}
	
	public int getTipoSolicitud() {
		return tipoSolicitud;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTipoSolicitud(int tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	} 
	
	// Metodo toString que devuelve la información de las solicitudes de un Animal
	public String toString(Animal animal) {
		
		boolean esApadrinado;
		esApadrinado = animal.getApadrinado();
		String apadrinado = "";
		 
		apadrinado = (esApadrinado) ? "si" : "no";
		
		return " -" + nombre + " con número de teléfono " + telefono + " ha realizado una solicitud de tipo: " 
			+ tipoSolicitud + " y " + apadrinado + " esta apadrinado.\n";	
	}
}
