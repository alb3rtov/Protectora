//Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Protectora{
	
	private int nAnimales;
	private String nombre;
	private static final int CAPACIDAD_PROTECTORA = 30;
	private Animal[] animales;
	
	/*
	public Protectora(String nombre) {
		super();
		this.nombre = nombre;
		
		animales = new Animal [CAPACIDAD_PROTECTORA];
		nAnimales = 0;
	}
	*/
	
	public Protectora(int nAnimales, String nombre, Animal [] animales) {
		this.nAnimales = nAnimales;
		this.nombre = nombre;
		this.animales = animales;
		
	}
	public int getNanimales() {
		return nAnimales;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCapacidad() {
		return CAPACIDAD_PROTECTORA;
	}
	
	public Animal [] getAnimales() {
		return animales;
	}
	
	public void setNanimales(int nAnimales) {
		this.nAnimales = nAnimales;
	} 
	
	public void setNombre(String nombreAnimal) {
		this.nombre = nombreAnimal;
	}
	
	public void setAnimales(Animal [] animales) {
		this.animales = animales;
	}
	
	public boolean addAnimal(Animal animal) {
		
		boolean esAgregado;
		if (nAnimales < animales.length) {
			animales[nAnimales++] = animal;
			esAgregado = true;
		}
		else {
			esAgregado = false;
		}
		
		return esAgregado;
		
	}
	
	public int localizarAnimalProtectora(String nombre) {
	
		int encontrado = -1;
		
		for (int i = 0; i < animales.length; i++) {
			if (nombre.equalsIgnoreCase(animales[i].getNombre())) {
				encontrado = i;
				break;
			}
		}
		
		return encontrado;
	}
	
	public String devolverDatosAnimales() {
		
		String cadena = "";

		
		for (int i = 0; i < animales.length; i++) {
			cadena += animales[i].toString();
		}
		
		return cadena;
	}
	
	public void addSolicitud(String nombreS, int tipoSolicitud, int telefono, String nombre) {
		
		boolean encontrado = false;
		
		for (int i = 0; i < animales.length; i++) {
			if (nombre.equalsIgnoreCase(animales[i].getNombre())) {
				if (animales[i].getNSolicitudes() == 10) {
					System.out.println("No se pueden realizar mas solicitudes al animal " + animales[i].getNombre() + ".\n");
					encontrado = true;
					break;
				}
				
				else {
					encontrado = true;
					animales[i].crearSolicitud(nombreS, tipoSolicitud, telefono);
					System.out.println("Solicitud añadida.\n");
					break;
				}
			}
		}
		
		if (!encontrado) {
			System.out.println("No se a encontrado ningun animal con el nombre " + nombre + ".\n");
		}
	}
	
	public double calcularGatosEsterGatas(Clinica clinica) {
	
		double gastos = 0;
		gastos = clinica.getPrecio() * numeroGatasNoEsterilizadas() * 12; // 10 es el coste de esterilizacion
		
		return gastos;
	}
	
	public double calcularCostesVeterAnuales(Animal [] animales) {
		
		double gastos = 0;

		for (int i = 0; i < animales.length; i++) {
			gastos = gastos + animales[i].calcularGastosVeterinarioAnimal();
		}
		
		return gastos;
	}
	
	public double calcularEstimacionCantPienso(Animal [] animales) {
		
		double gastos = 0;
		
		for (int i = 0; i < animales.length; i++) {
			gastos = gastos + animales[i].calcularGastosVeterinarioAnimal();
		}
		
		return gastos;
	}
	
	public int numeroGatasNoEsterilizadas() {
		
		int contador = 0;
		
		for (int i = 0; i < animales.length; i++) {
			if (animales[i] instanceof Gato) {
				if (!((Gato) animales[i]).getEsterilizado()) {
					contador++;
				}
			}
		}
		
		return contador;
	}
	
	public double calcularSubvecionAyuntamiento(Ayuntamiento ayuntamiento) {
		
		double subvecion = nAnimales * ayuntamiento.getSubvencion();
		return subvecion;
	}
	
	public double calcularCantidadPiensoAdultos(Animal [] animales) {
		
		double gastos = 0;
		
		for (int i = 0; i < animales.length; i++) {
			if (animales[i] instanceof Perro) {
				if (((Perro) animales[i]).getTamanio() >= 25 ) {
					gastos = gastos + ((Perro) animales[i]).getTamanio();
				}
			}
		}
		
		return gastos;
	}
}
