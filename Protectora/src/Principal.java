//Alberto Vázquez Martínez y Ángel Villafranca Iniesta

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Principal {

	final static Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		
		boolean salir = false, exit = false;
		int opcion = 0;
		int nAnimales = 0;

		Clinica clinica = new Clinica("Veterval", 684574527, 8);
		Ayuntamiento ayuntamiento = new Ayuntamiento("Ayuntamiento Ciudad Real", 654745120, 200);
		Protectora protectora = new Protectora("Alberto y Ángel");

		try {
			nAnimales = leerAnimales("Animales.txt", protectora.getAnimales());
		}

		catch (IOException e) {
			System.out.println("El fichero no se ha encontrado");
			System.out.println(e.getMessage());
			salir = true;
		}
		
		protectora.setNanimales(nAnimales);

		while (!salir) {
			System.out.println("------------------- Protectora " + protectora.getNombre() + " -------------------");
			System.out.println("\n1.- Mostrar la información de los animales rescatados");
			System.out.println("2.- Realizar una solicitud (0-adopcion / 1-acogida) de un animal");
			System.out.println("3.- Lista de solicitudes de adopcion de un animal");
			System.out.println("4.- Calcular los gastos veterinarios anuales de la protectora");
			System.out.println("5.- Calcular el coste total de una campaña de esterilización de gatas");
			System.out.println("6.- Calcular la cantidad de pienso de perro adulto que se necesita por semana");
			System.out.println("7.- Calcular la cantidad de subveccion que concede el ayuntamiento");
			System.out.println("8.- Salir\n");
			System.out.println("Introduzca una de las opciones (1-8): ");
			
			exit = false;
			
			do  {
				try {
					opcion = leerDatoRango(1,8);
					exit = true;
				} catch (NumeroFueraRangoException e) {
					System.out.println("Introduzca una opcion correcta del menu (1-8): ");
				}
			} while (!exit);
			
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
		
	public static int leerDatoRango(int min, int max) throws NumeroFueraRangoException{
		int num;
		num = leerEntero();
		
		if (num < min || num > max) {
			throw new NumeroFueraRangoException("Error. Las opciones estan en el rango ["+min+", "+max+"].");
		}
		return num;
	}
	
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
		
		System.out.println("Introduzca su nombre para realizar la solicitud: ");
		TECLADO.nextLine();
		String nombreS = TECLADO.nextLine();

		System.out.println("Introduzca el tipo de solicitud (0-adopcion / 1-acogida): ");
		
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

		do  {
			telefono = leerEntero();
			exit = true;
		} while (!exit);
		

		TECLADO.nextLine();

		String tSolicitud = (tipoSolicitud == 0) ? "adoptar" : "apadrinar";
		System.out.println("Introduzca el nombre del animal a " + tSolicitud + ": ");
		String nombre = TECLADO.nextLine();

		System.out.println(protectora.addSolicitud(nombreS, tipoSolicitud, telefono, nombre) + "\n");
	}
	
	public static void consultarSolicitudAnimales(Protectora protectora) {
		System.out.println("Introduzca el nombre del animal a consultar solicitudes: ");
		TECLADO.nextLine();
		String nombreAnimal = TECLADO.nextLine(); 

		int n = protectora.localizarAnimalProtectora(nombreAnimal);

		if (n != -1) {
			System.out.println("El numero de solicitudes del animal " + nombreAnimal + " es de " + protectora.getAnimales()[n].getNSolicitudes() + ".\n");
			if (n != 0) {
				System.out.println("Lista de solicitudes de " + nombreAnimal + ": \n");
				System.out.println(protectora.imprimirSolicitudesAnimal(n));
			}
		}

		else {
			System.out.println("El animal " + nombreAnimal + " no se ha encontrado");
		}
	}

	
	public static void calcularGastosVeterinariosAnuales(Protectora protectora) {
		System.out.println("Los gastos veterinarios anuales de la protectora son de " + protectora.calcularCostesVeterAnuales(protectora.getAnimales()) + " €.\n");
	}
	
	public static void calcularCostesCampanaEsterGatas(Protectora protectora, Clinica clinica) {
		System.out.println("Los costes totales de una campaña de esterilización de gatas es de " + protectora.calcularGatosEsterGatas(clinica) + " €.\n");
	}
	
	public static void calcularPiensoPerrosAdultosSemanal(Protectora protectora) {
		System.out.println("La cantidad de pienso que necesitan los perros adultos es de " + protectora.calcularCantidadPiensoAdultos(protectora.getAnimales()) + " kg.\n");
	}
	
	public static void calcularSubveccionAyuntamiento(Protectora protectora, Ayuntamiento ayuntamiento) {
		System.out.println("La cantidad de subveccion que concede el ayuntamiento es de " + protectora.calcularSubvecionAyuntamiento(ayuntamiento) + " €.\n");
	}
	
	public static boolean salirPrograma() {
		boolean salir = true;
		System.out.println("Fin de programa");
		return salir;
	}
}
