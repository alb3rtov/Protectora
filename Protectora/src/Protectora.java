//D2_GP02 Alberto Vázquez Martínez y Ángel Villafranca Iniesta

public class Protectora {
	//Atributos
	private int nAnimales;
	private String nombre;
	private static final int CAPACIDAD_PROTECTORA = 30; // Constante con la capacidad máxima de la protectora
	private static final int  SUBVECION_FIJA = 1000; // Constante con la subvecion fija del ayuntamiento
	private Animal[] animales; // Relación de asociación con la clase Animal, referencia polimorfica.
	
	//Constructor
	public Protectora(String nombre) {
		this.nombre = nombre;
		animales = new Animal[CAPACIDAD_PROTECTORA]; // Se define el array con el tamaño máximo de la proctectora
		nAnimales = 0; // El numero de animales de la protectora comienza en 0
	}
	
	// Getters y Setters
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
	
	//Este método devuelve una cadena con la información de las solicitudes de un animal
	public String imprimirSolicitudesAnimal(int n) {
		String cadena = "";
		
		for (int i = 0; i < animales[n].getSolicitudes().length && animales[n].getSolicitudes()[i] != null; i++) {
			cadena += animales[n].getSolicitudes()[i].toString(animales[n]);
		}
		
		return cadena;
	}
	
	//Este método recibe un objeto Animal para añadir un animal al array 
	public boolean addAnimal(Animal animal) {
		
		boolean esAgregado;
		if (nAnimales < animales.length) {
			animales[nAnimales++] = animal; // agregamos el animal al array y aumentamos nAnimales
			esAgregado = true;
		}
		else {
			esAgregado = false;
		}
		
		return esAgregado;
		
	}
	
	// Este método se utiliza para localizar mediante el nombre de un animal, su posición en el array de Animales
	// En caso de que se encuentre el nombre, devuelve la posición del array, si no, devuelve -1.
	public int localizarAnimalProtectora(String nombre) {
	
		int encontrado = -1;
		
		for (int i = 0; animales[i] != null; i++) {
			if (nombre.equalsIgnoreCase(animales[i].getNombre())) {
				encontrado = i;
				break;
			}
		}
		
		return encontrado;
	}
	
	// Este método devuelve la información del método toString de la clase Animal
	public String devolverDatosAnimales() {
		
		String cadena = "";

		for (int i = 0; animales[i] != null; i++) { // La condición indica que mientras que la posición del array no sea null, imprima la información
			cadena += animales[i].toString();
		}
		
		return cadena;
		
	}
	
	// En este método comienza la creación de una solicitud.
	// Recoge los datos introducidos por el usuario, ya comprobados, y se llama al metodo de animales crearSolicitud();
	public String addSolicitud(String nombreS, int tipoSolicitud, String telefono, String nombre) {
		boolean encontrado = false;
		String cadena = "";
		
		for (int i = 0; animales[i] != null; i++) {
			if (nombre.equalsIgnoreCase(animales[i].getNombre())) {
				encontrado = true;
				animales[i].crearSolicitud(nombreS, tipoSolicitud, telefono);
				cadena = "Solicitud añadida al animal " + nombre;
				break;
			}
		}
		
		return cadena;
	}
	
	// En este método se calcula los gastos de la esterilización de gatas de la protectora.
	// Primero cuenta con el metodo numeroGatasNoEsterilizadas el numero de gatas no esterilizadas y lo multiplica por el precio de la clinica.
	// Relación de dependencia
	public double calcularGastosEsterGatas(Clinica clinica) {
	
		double gastos = 0;
		gastos = clinica.getPrecio() * numeroGatasNoEsterilizadas();
		
		return gastos;
	}
	
	// En este método se calcula lo costes veterinarios anuales de la protectora
	// Para ello llama al método de la clase Animal calcularGastosVeterinarioAnimal, que cacula el gastos anual de un solo animal
	public double calcularCostesVeterAnuales(Animal [] animales) {
		
		double gastos = 0;

		for (int i = 0; animales[i] != null; i++) {
			gastos = gastos + animales[i].calcularGastosVeterinarioAnimal();
		}
		
		return gastos;
	}
	
	// Este método calcula la estimación de la cantidad de pienso de todos los animales de la protectora.
	// Al igual que el método anterior, llama a un metodo de la clase Animal, calcularGastosPienso
	public double calcularEstimacionCantPienso(Animal [] animales) {
		
		double gastos = 0;
		
		for (int i = 0; animales[i] != null; i++) {
			gastos = gastos + animales[i].calcularGastosPienso();
		}
		
		return gastos;
	}
	
	// Este método calcula el numero de gatas que no esta esterilizadas
	public int numeroGatasNoEsterilizadas() {
		
		int contador = 0;
		
		for (int i = 0; animales[i] != null; i++) {
			if (animales[i] instanceof Gato) {
				if (!((Gato) animales[i]).getEsterilizado() && animales[i].getSexo().equalsIgnoreCase("h")) {
					contador++;
				}
			}
		}
		
		return contador;
	}
	
	// Este metodo calcular la subvencion que concede el ayuntamiento
	// Lo calcular multiplicando el numero de animales actuales, la subvecion variable que concede el ayuntamiento y la subvención fija
	// Relación de dependencia
	public double calcularSubvecionAyuntamiento(Ayuntamiento ayuntamiento) {
		
		double subvecion = nAnimales * ayuntamiento.getSubvencion() + SUBVECION_FIJA;
		return subvecion;
	}
	
	// Este método calcula la cantidad de pienso de los perros adultos semanal
	// Primero comprueba los animales con un peso mayor de 25 y suma la cantidad de pienso de cada uno
	public double calcularCantidadPiensoAdultos(Animal [] animales) {
		
		double gastos = 0;

		for (int i = 0; i < animales.length; i++) {
			if (animales[i] instanceof Perro) {
				//if (animales[i].getEdad() * 12 >= 19) {
					gastos = gastos + animales[i].calcularGastosPienso();
				//}
			}
		}
		
		return gastos;
	}
}
