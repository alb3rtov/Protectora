//Alberto Vázquez Martínez y Ángel Villafranca Iniesta

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	final static Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		
		int nAnimales = 15;
		boolean salir = false;
		int key;
		
		Animal [] animales = new Animal[nAnimales];
		Clinica clinica = new Clinica("Veterval", 684574527, 8);
		Ayuntamiento ayuntamiento = new Ayuntamiento("Ayuntamiento Valdepeñas", 654745120, 200);
		Protectora protectora = new Protectora(nAnimales, "Rivanimal", animales);

		try {
			leerAnimales("Animales.txt", animales);
		}
		
		catch (IOException e) {
			System.out.println("El fichero no se ha encontrado");
			System.out.println(e.getMessage());
			salir = true;
		}

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
			key = TECLADO.nextInt();

			while (key < 1 || key > 8) {
				System.out.println("Introduzca una opcion correcta (1-8): ");
				key = TECLADO.nextInt();
			}

			switch (key) {
			case 1:
				System.out.println(protectora.devolverDatosAnimales());
				break;
			case 2:

				System.out.println("Introduzca su nombre para realizar la solicitud: ");
				TECLADO.nextLine();
				String nombreS = TECLADO.nextLine();

				System.out.println("Introduzca el tipo de solicitud (0-adopcion / 1-acogida): ");
				int tipoSolicitud = TECLADO.nextInt();

				while (tipoSolicitud != 0 && tipoSolicitud != 1) {
					System.out.println("Introduzca un dato correcto para tipo de solicitud (0-adopcion / 1-acogida): ");
					tipoSolicitud = TECLADO.nextInt();
				}

				System.out.println("Introduzca su numero de telefono: ");
				int telefono = TECLADO.nextInt();

				while (telefono < 111111111 || telefono > 999999999) {
					System.out.println("Introduzca un dato correcto para el telofono: ");
					telefono = TECLADO.nextInt();
				}

				TECLADO.nextLine();

				String tSolicitud = (tipoSolicitud == 0) ? "adoptar" : "apadrinar";
				System.out.println("Introduzca el nombre del animal a " + tSolicitud + ": ");
				String nombre = TECLADO.nextLine();

				System.out.println(protectora.addSolicitud(nombreS, tipoSolicitud, telefono, nombre) + "\n");

				break;
			case 3:
				System.out.println("Introduzca el nombre del animal a consultar solicitudes: ");
				TECLADO.nextLine();
				String nombreAnimal = TECLADO.nextLine(); 

				int n = protectora.localizarAnimalProtectora(nombreAnimal);

				if (n != -1) {
					System.out.println("El numero de solicitudes del animal " + nombreAnimal + " es de " + animales[n].getNSolicitudes());
				}

				else {
					System.out.println("El animal " + nombreAnimal + " no se ha encontrado");
				}

				break;
			case 4: 
				System.out.println("Los gastos veterinarios anuales de la protectora son de " + protectora.calcularCostesVeterAnuales(animales) + " €.\n");
				break;
			case 5:
				System.out.println("Los costes totales de una campaña de esterilización de gatas es de " + protectora.calcularGatosEsterGatas(clinica) + " €.\n");
				break;
			case 6: 
				System.out.println("La cantidad de pienso que necesitan los perros adultos es de " + protectora.calcularCantidadPiensoAdultos(animales) + " kg.\n");
				break;
			case 7: // faltan la cantidad fija
				System.out.println("La cantidad de subveccion que concede el ayuntamiento es de " + protectora.calcularSubvecionAyuntamiento(ayuntamiento) + " €.\n");
				break;
			case 8:
				System.out.println("Fin de programa.");
				salir = true;
				break;
			}
		}
	}
	
	public static void leerAnimales (String cadena, Animal[] animales) throws IOException {

		File f=new File(cadena);
		Scanner nombre_f = new Scanner (f);
		int contador = 0;
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

				animales[contador] = new Perro(nombre, sexo, anios, sociablePersonas, nSolicitudes, 
												apadrinado, solicitudes, raza, tamanioKg, ppp, leishmania);
				contador++;
			}

			if (tipoAnimal.equalsIgnoreCase("g")) {
				//Gatos
				boolean esterilizado = nombre_f.nextBoolean();
				
				animales[contador] = new Gato(nombre, sexo, anios, sociablePersonas, nSolicitudes, apadrinado, solicitudes, esterilizado);
				contador++;
			}
		}

		nombre_f.close();
	}
}
