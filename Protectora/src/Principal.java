//Alberto Vázquez Martínez y Ángel Villafranca Iniesta

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	final static Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		int nAnimales = 15;
		Animal [] animales = new Animal[nAnimales];
		
		Protectora protectora = new Protectora(nAnimales, "Rivanimal", animales);		
		leerAnimales("Animales.txt", animales);

		
		boolean salir = false;
		int key;
		System.out.println("Protectora " + protectora.getNombre());
		
		do {
			System.out.println("\n1.- Mostrar la información de los animales rescatados");
			System.out.println("2.- Realizar una solicitud (adopcion - acogida) de un animal");
			System.out.println("3.- Lista de solicitudes de adopcion de un animal");
			System.out.println("4.- Calcular los gastos veterinarios anuales de la protectora");
			System.out.println("5.- Calcular el coste total de una campaña de esterilización de gatas");
			System.out.println("6.- Calcular la cantidad de pienso de perro adulto que se necesita por semana");
			System.out.println("7.- Calcular la cantidad de subveccion que concede el ayuntamiento");
			System.out.println("8.- Salir\n");
			key = TECLADO.nextInt();
			
			while (key < 1 || key > 8) {
				System.out.println("Introduzca una opcion correcta");
				key = TECLADO.nextInt();
			}
			
			switch (key) {
			case 1:
				System.out.println(protectora.devolverDatosAnimales());
				break;
			case 2:
				System.out.println("case 2");
				break;
			case 3:
				System.out.println("case 3");
				break;
			case 4: 
				System.out.println("case 4");
				break;
			case 5:
				System.out.println("case 5");
				break;
			case 6:
				System.out.println("case 6");
				break;
			case 7:
				System.out.println("case 7");
				break;
			case 8:
				System.out.println("Fin de programa.");
				salir = true;
				break;
			}
		} while (!salir);
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
