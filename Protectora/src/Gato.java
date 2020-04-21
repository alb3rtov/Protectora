//D2_GP02 Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Gato extends Animal { // Se utiliza extends para heredar de la clase Animal, sus atributos protected
	//Atributos específico (invariante)
	private boolean esterilizado;
	
	//Constructor
	public Gato(String nombre, String sexo, int anios, boolean sociable, 
			int nSolicitudes, boolean apadrinado,  boolean esterilizado) {
		//Llamamos a super para reusar el constructor de la clase padre
		super(nombre, sexo, anios, sociable, nSolicitudes, apadrinado); 
		this.esterilizado = esterilizado;
	}
	
	//Getters y Setters
	public boolean getEsterilizado() {
		return esterilizado;
	}
	
	public void setEsterilizado(boolean esterilizado) {
		this.esterilizado = esterilizado;
	}
	
	// Sobreescritura de metodo
	// Este método calcula los gastos de pienso de los gastos
	// Segun los requisitos, los gastos de pienso no son pagados por la protectora.
	// No haria falta dicho metodo, pero se implementa si en un futuro se modificase dicho requisito
	public double calcularGastosPienso() {
		double gastos = 0;
		return gastos;
	}
	
	// Este metodo calcula los gastos de veterinario de los gatos al año
	// Si el gato esta apadrinado, los gastos seran 0
	// Si no esta esterilizado habra que multiplicar el coste de esterilización por 12 meses
	public double calcularGastosVeterinarioAnimal() {
		double gastos = 0;
		
		if (!apadrinado && !esterilizado && sexo.equalsIgnoreCase("h")) {
				gastos = ESTERILIZACION * 12; //Una al mes
		}
		
		return gastos;
	}
	
	// Este metodo devuelve la información de un gato
	public String toString() {
		String cadena = "Gato [nombre = " + nombre.toUpperCase() + ", sexo = ";
		cadena += sexo.equals("m") ? "macho" : "hembra";
		cadena += ", años = " + edad + ", sociable = ";
		cadena += sociable ? "si" : "no";
		cadena += ", apadrinado = ";
		cadena += apadrinado ? "si" : "no";
		cadena += ", esterilizado = ";
		cadena += esterilizado ? "si" : "no";
		cadena += "]\n";
		return cadena;
	}
}
