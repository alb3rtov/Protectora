//D2_GP02 Alberto V�zquez Mart�nez y �ngel Villafranca Iniesta

public class Ayuntamiento {

	private String nombre;
	private int telefono;
	private double subvencion;

	public Ayuntamiento(String nombre, int telefono, double subvencion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.subvencion = subvencion;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getTelefono() {	
		return telefono;
	}
	
	public double getSubvencion() {
		return subvencion;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(int telefono) {	
		this.telefono = telefono;
	}

	public void setPrecio(int subvencion) {		
		this.subvencion = subvencion;
	}
	
	public String toString() {
		return "El ayuntamiento " + nombre + " con telefono " + telefono + 
				" ofrece una subvenci�n de " + subvencion + "�.";
	}
}
