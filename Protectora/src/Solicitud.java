//D2_GP02 Alberto V�zquez Mart�nez y �ngel Villafranca Iniesta

public class Solicitud {
	// Atributos
	private String nombre;
	private int tipoSolicitud;
	private String telefono;
	
	// Constructor
	public Solicitud(String nombre, int tipoSolicitud, String telefono) {
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
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTipoSolicitud(int tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	} 
	
	// Ampliaci�n
	// Metodo toString que devuelve la informaci�n de las solicitudes de un Animal
	public String toString(Animal animal) {
		
		boolean esApadrinado;
		esApadrinado = animal.getApadrinado();
		String apadrinado = "";
		 
		apadrinado = (esApadrinado) ? "si" : "no";
		
		return " -" + nombre + " con n�mero de tel�fono " + telefono + " ha realizado una solicitud de tipo: " 
			+ tipoSolicitud + " y " + apadrinado + " esta apadrinado.\n";	
	}
}
