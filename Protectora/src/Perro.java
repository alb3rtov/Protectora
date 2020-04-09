//D2_GP02 Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Perro extends Animal { // Se utiliza extends para heredar de la clase Animal, sus atributos protected
	
	//Atributos especificos (invariantes)
	private String raza;
	private double tamanio;
	private boolean ppp;
	private boolean leishmania;
	
	// Constructor
	public Perro(String nombre, String sexo, int anios, boolean sociable, 
			int nSolicitudes, boolean apadrinado, String raza, double tamanio, 
			boolean ppp, boolean leishmania) {
		// Llamamos a super para reusar el constructor de la clase padre
		super(nombre, sexo, anios, sociable, nSolicitudes, apadrinado);
		this.raza = raza;
		this.tamanio = tamanio;
		this.ppp = ppp;
		this.leishmania = leishmania;
	}
	
	//Getters y Setters
	public String getRaza() {
		return raza;
	}
	
	public double getTamanio() {
		return tamanio;
	}
	
	public boolean getPPP() {
		return ppp;
	}
	
	public boolean getLeishmania() {
		return leishmania;
	}
	
	public void setRaza(String raza) {
		this.raza = raza;
	}
	
	public void setTamanio(double tamanio) {
		this.tamanio = tamanio;
	}
	
	public void setPPP(boolean ppp) {
		this.ppp = ppp;
	}
	
	public void setLeishmania(boolean leishmania) {
		this.leishmania = leishmania;
	}
	
	// Sobreescritura de metodo
	// Calcula los gastos veterinarios de un perro al año
	// Si esta apadrinado, los gastos seran 0
	// Se comprueba si es ppp y sociable
	
	public double calcularGastosVeterinarioAnimal() {
		double gastos = 0;
		
		if (!apadrinado) {
			gastos = VACUNA_RABIA; // La vacuna de la rabia es una vez al año

			if (ppp && !sociable)
				gastos = gastos + SEDACION; // Sedaccion de la vacuna de la rabia
			
			if (leishmania)
				gastos = gastos + LEISHMANIA * 12; // Si sufre de leishmania, una vez al mes
		}
		
		return gastos;
	}
	
	// Sobreescritura de metodo
	// Calcula los gastos de pienso de un perro a la semana
	// Dependiendo del tamaño del perro sera una cantidad u otra
	public double calcularGastosPienso() {
		double gastos = 0;
		double cantidadPienso = 0;
		
		if (edad*12 > 18) { // Se pasa la edad a meses multiplicando por 12
			if (tamanio <= 15) {
				//200 gr al dia
				cantidadPienso = 200;
				gastos = cantidadPienso * 7;
			}
			else if (tamanio > 15 && tamanio <= 25) {
				//300 gr al dia
				cantidadPienso = 300;
				gastos = cantidadPienso * 7;
			}
			
			else {
				//1.5% de su peso en comida al dia.
				cantidadPienso = tamanio * (1.5/100);
				gastos = cantidadPienso * 7;
			}
		}
		
		return gastos;
	}
	
	// Este metodo devuelve la información de un perro
	public String toString() {
		String cadena = "Perro [nombre = " + nombre.toUpperCase() + ", sexo = ";
		cadena += sexo.equals("m") ? "macho" : "hembra";
		cadena += ", años = " + edad + ", sociable = ";
		cadena += sociable ? "si" : "no";
		cadena += ", apadrinado = ";
		cadena += apadrinado ? "si" : "no";
		cadena += ", raza = " + raza;
		cadena += ", tamaño = " + tamanio;
		cadena += ", ppp = ";
		cadena += ppp ? "si" : "no";
		cadena += ", leishmania = ";
		cadena += leishmania ? "si" : "no";
		cadena += "]\n";
		return cadena;
	}
	
}
