//Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Clinica {

	private String nombre;
	private int telefono;
	private double precio;
	
	public Clinica(String nombre, int telefono, double precio) {
		this.nombre = nombre;
		this.telefono = telefono;
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getTelefono() {
		return telefono;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setTelefono(int telefono) {	
		this.telefono = telefono;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String toString() {
		return "El nombre la clinica es: " + nombre + ", su telefono es " + telefono + 
				" y el precio por esterilización de gatas es de " + precio + ".";
	}
}



