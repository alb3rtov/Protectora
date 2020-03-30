//Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Perro extends Animal {
	
	private String raza;
	private double tamanio;
	private boolean ppp;
	private boolean leishmania;
	
	public Perro(String nombre, String sexo, int anios, boolean sociable, 
			int nSolicitudes, boolean apadrinado, Solicitud [] solicitudes, String raza, double tamanio, 
			boolean ppp, boolean leishmania) {
		
		super(nombre, sexo, anios, sociable, nSolicitudes, apadrinado, solicitudes);
		this.raza = raza;
		this.tamanio = tamanio;
		this.ppp = ppp;
		this.leishmania = leishmania;
	}
	
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
	
	public double calcularGastosVeterinarioAnimal() {
		double gastos = 0;
		
		if (!apadrinado) {
			gastos = VACUNA_RABIA; // Una al año

			if (ppp && !sociable) {
				gastos = gastos + SEDACION; // Sedaccion de la vacuna de la rabia
				
				if (leishmania) {
					gastos = gastos + LEISHMANIA * 12 + SEDACION * 12; // Una al mes si tiene leishmania
				}
			}
			
			else {
				if (leishmania) {
					gastos = gastos + LEISHMANIA * 12; // Una al mes si tiene leishmania
				}
			}
		}
		
		return gastos;
	}
	
	public double calcularGastosPienso() {
		double gastos = 0;
		double cantidadPienso = 0;
		
		if (edad*12 > 18) {
			if (tamanio <= 15) {
				//200 gr al dia
				cantidadPienso = 200;
				gastos = cantidadPienso * PRECIO_PIENSO_POR_GR * 365;
			}
			else if (tamanio > 15 && tamanio <= 25) {
				//300 gr al dia
				cantidadPienso = 300;
				gastos = cantidadPienso * PRECIO_PIENSO_POR_GR * 365;
			}
			
			else {
				//1.5% de su peso en comida al dia.
				cantidadPienso = tamanio * (1.5/100);
				gastos = cantidadPienso * PRECIO_PIENSO_POR_GR * 365;
			}
		}
		
		return gastos;
	}
	
	
	public String toString() {
		String cadena = "Gato [nombre = " + nombre.toUpperCase() + ", sexo = ";
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
