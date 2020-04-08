//D2_GP02 Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Gato extends Animal {
	
	private boolean esterilizado;
	
	public Gato(String nombre, String sexo, int anios, boolean sociable, 
			int nSolicitudes, boolean apadrinado,  boolean esterilizado) {
		
		super(nombre, sexo, anios, sociable, nSolicitudes, apadrinado);
		this.esterilizado = esterilizado;
	}
	
	public boolean getEsterilizado() {
		return esterilizado;
	}
	
	public void setEsterilizado(boolean esterilizado) {
		this.esterilizado = esterilizado;
	}
	
	public double calcularGastosPienso() {
		double gastos = 0;
		return gastos;
	}
	
	public double calcularGastosVeterinarioAnimal() {
		double gastos = 0;
		
		if (!apadrinado) {
			if (!esterilizado) {
				gastos = ESTERILIZACION * 12; //Una al mes
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
		cadena += ", esterilizado = ";
		cadena += esterilizado ? "si" : "no";
		cadena += "]\n";
		return cadena;
	}
}
