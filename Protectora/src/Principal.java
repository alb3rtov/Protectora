//D2_GP02 Alberto Vázquez Martínez y Ángel Villafranca Iniesta

// Importamos las bibliotecas necesarias
import java.io.File;
import java.io.IOException;
import java.util.*;

public class Principal {
	
	// Definimos la variable TECLADO como constante
	final static Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		
		// Variables
		boolean salir = false, exit = false;
		int opcion = 0, nAnimales = 0;
		
		// Creación de objetos
		Clinica clinica = new Clinica("Veterval", 684574527, 50);
		Ayuntamiento ayuntamiento = new Ayuntamiento("Ayuntamiento Ciudad Real", 654745120, 20);
		Protectora protectora = new Protectora("Alberto y Ángel");

		// Llamamos al metodo leerAnimales y le pasamos como parametro el nombre del fichero y el array de animales
		try {
			nAnimales = leerAnimales("Animales.txt", protectora.getAnimales());
		}
		// Si no se encuentra el fichero salta esta excepcion y termina el programa
		catch (IOException e) {
			System.out.println("El fichero no se ha encontrado");
			System.out.println(e.getMessage());
			salir = true;
		}
		
		// Establece el numero de animales contados por la funcion leerAnimales
		protectora.setNanimales(nAnimales);

		// Bucle while con el menu principal del programa
		while (!salir) {
			System.out.println("------------------- Protectora " + protectora.getNombre() + " -------------------\n");
			System.out.println("1.- Mostrar la información de los animales rescatados");
			System.out.println("2.- Realizar una solicitud (0-adopcion / 1-acogida) de un animal");
			System.out.println("3.- Lista de solicitudes de adopcion de un animal");
			System.out.println("4.- Calcular los gastos veterinarios anuales de la protectora");
			System.out.println("5.- Calcular el coste total de una campaña de esterilización de gatas");
			System.out.println("6.- Calcular la cantidad de pienso de perro adulto que se necesita por semana");
			System.out.println("7.- Calcular la cantidad de subveccion que concede el ayuntamiento");
			System.out.println("8.- Salir\n");
			System.out.println("Introduzca una de las opciones (1-8): ");
			
			
			exit = false;
			
			// Comprobación de rango para opciones de menú
			// Si la excepción salta, al encontrarse esta parte del código dentro de un bucle, 
			// se volverá a repetir hasta que el usuario introduzca un dato correcto.
			do  {
				try {
					opcion = leerDatoRango(1,8);
					exit = true;
				} catch (NumeroFueraRangoException e) {
					System.out.println("Introduzca una opcion correcta del menu (1-8): ");
				}
			} while (!exit);
			
			// Switch con las diferentes opciones del menú
			// Cada opción llama a una función diferente y le pasa como parametro el objeto protectora y en otros casos clinica y ayuntamiento
			switch (opcion) {
			case 1:
				mostrarInformacionAnimales(protectora);
				break;
			case 2:
				realizarSolicitudes(protectora);
				break;
			case 3:
				consultarSolicitudAnimales(protectora);
				break;
			case 4: 
				calcularGastosVeterinariosAnuales(protectora);
				break;
			case 5:
				calcularCostesCampanaEsterGatas(protectora, clinica);
				break;
			case 6:
				calcularPiensoPerrosAdultosSemanal(protectora);
				break;
			case 7:
				calcularSubveccionAyuntamiento(protectora, ayuntamiento);
				break;
			case 8:
				salir = salirPrograma();;
				break;
			}
		}
	}
	
	// Esta función proceso el archivo Animales.txt y devuelve el numero de animales que introduce en el array.
	public static int leerAnimales (String cadena, Animal[] animales) throws IOException {

		File f=new File(cadena);
		Scanner nombre_f = new Scanner (f);
		int contadorAnimales = 0;
		Solicitud [] solicitudes = new Solicitud[10];
		
		while (nombre_f.hasNext()){
			
			int nSolicitudes = 0;
			String tipoAnimal = nombre_f.next();
			String nombre = nombre_f.next();
			String sexo = nombre_f.next();
			int anios = nombre_f.nextInt();
			boolean sociablePersonas = nombre_f.nextBoolean();
			boolean apadrinado = nombre_f.nextBoolean();

			if (tipoAnimal.equalsIgnoreCase("p")) {

				//Perros
				String raza = nombre_f.next();
				int tamanioKg = nombre_f.nextInt();
				boolean ppp = nombre_f.nextBoolean();
				boolean leishmania = nombre_f.nextBoolean();

				animales[contadorAnimales] = new Perro(nombre, sexo, anios, sociablePersonas, nSolicitudes, 
												apadrinado, raza, tamanioKg, ppp, leishmania);
				contadorAnimales++;
			}

			if (tipoAnimal.equalsIgnoreCase("g")) {
				//Gatos
				boolean esterilizado = nombre_f.nextBoolean();
				
				animales[contadorAnimales] = new Gato(nombre, sexo, anios, sociablePersonas, nSolicitudes, apadrinado, esterilizado);
				contadorAnimales++;
			}
		}
		
		nombre_f.close();
		
		return contadorAnimales;
	}
	
	// Esta función recibe el nombre de un animal y se comprueba si dicho animal se encuentra dentro del array de Animale
	public static String leerNombreAnimal(Protectora protectora) throws AnimalNoEncontradoException {

		String nombre = TECLADO.nextLine();
		
		int n = protectora.localizarAnimalProtectora(nombre);
		
		if (n == -1) {
			throw new AnimalNoEncontradoException("Error. Animal no encontrado.");
		}	
			
		return nombre;
		
	}
	
	
	
	public static void comprobarSolicitudesAnimal(Protectora protectora, String nombre) throws MuchasSolicitudesException {
		
		int n = protectora.localizarAnimalProtectora(nombre);
		
		if (protectora.getAnimales()[n].getNSolicitudes() == 10) {
			throw new MuchasSolicitudesException("Error. El número máximo de solicitudes es de 10");
		}
	}
	
	
	// Esta función comprueba si el numero introducido por el usuario esta entre el rango correspondiente.
	// En caso de que no se encuentre en el rango, saltará la excepción NumeroFueraRangoException
	public static int leerDatoRango(int min, int max) throws NumeroFueraRangoException{
		int num;
		num = leerEntero();
		
		if (num < min || num > max) {
			throw new NumeroFueraRangoException("Error. Las opciones estan en el rango ["+min+", "+max+"].");
		}
		return num;
	}
	
	// Esta función comprueba si el usuario introduce un numero entero.
	// En caso de que no introduzca un numero entero, saltará la excepción InputMismatchException
	public static int leerEntero() {
		int opcion = 0;
		boolean salir = false;
		do {
			try {
				opcion = TECLADO.nextInt();
				salir = true;
			} catch (InputMismatchException e) {
				System.out.println("Error leyendo entero. Reintroducir el dato: ");
				TECLADO.next();
			}
			
		} while (!salir);
		
		return opcion;
	}
	
	//Opciones del menu
	public static void mostrarInformacionAnimales(Protectora protectora) {
		System.out.println(protectora.devolverDatosAnimales());
	}
	
	public static void realizarSolicitudes(Protectora protectora) {
		
		boolean exit = false;
		int tipoSolicitud = 0, telefono = 0;
		String nombre = "";

		TECLADO.nextLine();
		System.out.println("Introduzca el nombre del animal: ");
		
		// Llamamos a la función leerNombreAnimal
		// Si no se encuentra en animal en el array de animales, se volverá a solicitar un nombre correcto
		// En el caso de que si exista el animal, se comprobará si el numero de solicitudes es de 10
		// Si tiene 10 solicitudes, se lo volverá a solicitar el nombre de un animal que no tenga 10 solicitudes
		do {
			try {
				nombre = leerNombreAnimal(protectora);
				comprobarSolicitudesAnimal(protectora, nombre);
				exit = true;
			}

			catch (AnimalNoEncontradoException e) {
				System.out.println("Animal no encontrado, introduzca un nombre para el animal: ");
			}
			catch (MuchasSolicitudesException e) {
				System.out.println("El animal ya tiene 10 solicitudes, introduzca otro animal: ");
			}
		} while (!exit);
		
		// Nombre de la persona que realiza la solicitud
		System.out.println("Introduzca su nombre para realizar la solicitud: ");
		String nombreS = TECLADO.nextLine();

		
		System.out.println("Introduzca el tipo de solicitud (0-adopcion / 1-acogida): ");
		
		exit = false;
		
		// Se comprueba mediante la función leerDatoRango si el numero introducido esta entre 0 y 1
		// Si no encuentra dentro del rango, se volverá a solicitar
		do  {
			try {
				tipoSolicitud = leerDatoRango(0,1);
				exit = true;
			} catch (NumeroFueraRangoException e) {
				System.out.println("Introduzca un dato correcto para tipo de solicitud (0-adopcion / 1-acogida): ");
			}
		} while (!exit);
		
		System.out.println("Introduzca su numero de telefono: ");
		
		exit = false;
		
		// Comprueba si el dato introducido por el usuario es un numero entero
		do  {
			telefono = leerEntero();
			exit = true;
		} while (!exit);
		
		// Si todos los datos introducidos por el usuario son correctos, entonces, se puede realizar la solicitud
		// Se llama a la función addSolicitud de la clase protectora que a su vez llamará a la función crearSolicitud
		System.out.println(protectora.addSolicitud(nombreS, tipoSolicitud, telefono, nombre) + "\n");
	}
	
	// Este metodo solicita al usuario un nombre de un animal e imprimirá la información relativa a las solicitudes
	// Si el animal no existe saltará la excepción ANimalNoEncontradoException
	public static void consultarSolicitudAnimales(Protectora protectora) {
		
		String nombreAnimal = "";
		TECLADO.nextLine();
		System.out.println("Introduzca el nombre del animal a consultar solicitudes: ");
		
		try {
			nombreAnimal = leerNombreAnimal(protectora);
			
			int n = protectora.localizarAnimalProtectora(nombreAnimal);
			
			System.out.println("El numero de solicitudes del animal " + nombreAnimal + " es de " + protectora.getAnimales()[n].getNSolicitudes() + ".\n");
			if (protectora.getAnimales()[n].getNSolicitudes() != 0) {
				System.out.println("Lista de solicitudes de " + nombreAnimal + ": \n");
				System.out.println(protectora.imprimirSolicitudesAnimal(n));
			}
		}
		
		catch (AnimalNoEncontradoException e) {
			System.out.println("Error. Animal no encontrado.\n");
		}
	}
	
	//Llama al método calcularCostesVeterAnuales donde se calcula el total de gastos veterinarios de todos los animales actuales de la protectora.
	public static void calcularGastosVeterinariosAnuales(Protectora protectora) {
		System.out.println("Los gastos veterinarios anuales de la protectora son de " + protectora.calcularCostesVeterAnuales(protectora.getAnimales()) + " €.\n");
	}
	
	//Llama al metodo calcularCostesEsterGatas donde se calcular el total de costes de esterilización de todas las gastas no esterilizadas.
	public static void calcularCostesCampanaEsterGatas(Protectora protectora, Clinica clinica) {
		System.out.println("Los costes totales de una campaña de esterilización de gatas es de " + protectora.calcularGastosEsterGatas(clinica) + " €.\n");
	}
	
	// Llama al metodo calcularCantidadPiensoAdultos donde se calcula la cantidad pienso semanal que necesitas los perros adultos
	public static void calcularPiensoPerrosAdultosSemanal(Protectora protectora) {
		System.out.printf("La cantidad de pienso que necesitan los perros adultos es de %.2f kg \n\n", protectora.calcularCantidadPiensoAdultos(protectora.getAnimales()));
	}
	
	// Llama al metodo calcularSubveccionAyuntamiento donde se calcula la subvecion total otorgadada por el ayuntamiento
	public static void calcularSubveccionAyuntamiento(Protectora protectora, Ayuntamiento ayuntamiento) {
		System.out.println("La cantidad de subveccion que concede el ayuntamiento es de " + protectora.calcularSubvecionAyuntamiento(ayuntamiento) + " €.\n");
	}
	
	// Este metodo devuelve un boolean true para terminar el bucle donde se encuentra el menu principal y asi finalizar el programa
	public static boolean salirPrograma() {
		boolean salir = true;
		System.out.println("Fin de programa");
		return salir;
	}
}
