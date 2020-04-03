//Alberto V�zquez Mart�nez y �ngel Villafranca Iniesta

public class Solicitud {
	
	private String nombre;
	private int tipoSolicitud;
	private int telefono;
	
	public Solicitud(String nombre, int tipoSolicitud, int telefono) {
		this.nombre = nombre;
		this.tipoSolicitud = tipoSolicitud;
		this.telefono = telefono;
	}
	
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
	
	public String toString(Animal animal) {
		
		boolean esApadrinado;
		esApadrinado = animal.getApadrinado();
		String apadrinado = "";
		 
		apadrinado = (esApadrinado) ? "si" : "no";
		
		return " -" + nombre + " con n�mero de tel�fono " + telefono + " ha realizado una solicitud de tipo: " 
			+ tipoSolicitud + " y " + apadrinado + " esta apadrinado.\n";	

	}
}
