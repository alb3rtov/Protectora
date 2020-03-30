//Alberto Vázquez Martínez y Ángel Villafranca Iniesta

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

	final static Scanner TECLADO = new Scanner(System.in);
	
	public static void main(String[] args) throws IOException {
		
		//Protectora protectora = new Protectora(nombreAnimal);

		Animal [] animales = new Animal[20];
		leerAnimales("Animales.txt", animales);
		
		boolean salir = false;
		int key;
		
		do {
			System.out.println("1.- Mostrar la información de los animales rescatados");
			System.out.println("2.- Realizar una solicitud (adopcion - acogida) de un animal");
			System.out.println("3.- Lista de solicitudes de adopcion de un animal");
			System.out.println("4.- Calcular los gastos veterinarios anuales de la protectora");
			System.out.println("5.- Calcular el coste total de una campaña de esterilización de gatas");
			System.out.println("6.- Calcular la cantidad de pienso de perro adulto que se necesita por semana");
			System.out.println("7.- Calcular la cantidad de subveccion que concede el ayuntamiento");
			System.out.println("8.- Salir");
			key = TECLADO.nextInt();
			
			while (key < 1 || key > 8) {
				System.out.println("Introduzca una opcion correcta");
				key = TECLADO.nextInt();
			}
			
			switch (key) {
			case 1:
				System.out.println("case 1");
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
		
		while (nombre_f.hasNext()){
			
			int nSolicitudes = 0;
			String tipoAnimal = nombre_f.next();
			String nombre = nombre_f.next();
			String sexo = nombre_f.next();
			int anios = nombre_f.nextInt();
			boolean sociablePersonas = nombre_f.nextBoolean();
			boolean apadrinado = nombre_f.nextBoolean();  

			//System.out.print(tipoAnimal + " " + nombre + " " + sexo + " " + anios + " " + sociablePersonas + " " + apadrinado + " ");

			if (tipoAnimal.equalsIgnoreCase("p")) {

				//Perros
				String raza = nombre_f.next();
				int tamanioKg = nombre_f.nextInt();
				boolean ppp = nombre_f.nextBoolean();
				boolean leishmania = nombre_f.nextBoolean();

				//animales[contador] = new Perro(nombre, sexo, anios, sociablePersonas, nSolicitudes, apadrinado, raza, tamanioKg, ppp, leishmania);
				contador++;
				
				//System.out.println(raza + " " + tamanioKg + " " + ppp + " " + leishmania);
			}

			if (tipoAnimal.equalsIgnoreCase("g")) {
				//Gatos
				boolean esterilizado = nombre_f.nextBoolean();
				
				//animales[contador] = new Gato(nombre, sexo, anios, sociablePersonas, nSolicitudes, apadrinado, esterilizado);
				contador++;
				//System.out.println(esterilizado);
			}
		}

		nombre_f.close();


	}
	
	

}
