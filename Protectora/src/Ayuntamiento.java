//D2_GP02 Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Ayuntamiento {
	//Atributos
	private String nombre;
	private int telefono;
	private double subvencion;

	//Constructor
	public Ayuntamiento(String nombre, int telefono, double subvencion) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.subvencion = subvencion;
	}
	
	//Getters y Setters
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
	
	// Método toString que devuelve información del ayuntamiento
	public String toString() {
		return "El ayuntamiento " + nombre + " con telefono " + telefono + 
				" ofrece una subvención de " + subvencion + "€.";
	}
}
