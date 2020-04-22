//D2_GP02 Alberto Vázquez Martínez y Ángel Villafranca Iniesta

abstract class Animal implements Constantes { // Se implementa la interfaz Constantes para utilizar sus atributos
	//Atributos
	protected String nombre;
	protected String sexo;
	protected int edad;
	protected boolean sociable;
	protected int nSolicitudes;
	protected boolean apadrinado;
	protected Solicitud [] solicitudes; //Relación de asociacion con la clase Solicitud
	
	//Constructor
	public Animal(String nombre, String sexo, int edad, boolean sociable, 
			int nSolicitudes, boolean apadrinado) {
		
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.sociable = sociable;
		this.apadrinado = apadrinado;
		nSolicitudes = 0; // El numero de solicitudes al comienzo es de 0
		solicitudes = new Solicitud[10]; // 10 Solicitudes como máximo
	}
	
	//Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public String getSexo() {
		return sexo;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public boolean getSociable() {
		return sociable;
	}
	
	public Solicitud [] getSolicitudes(){
		return solicitudes;
	}
	
	public int getNSolicitudes() {
		return nSolicitudes;
	}

	public boolean getApadrinado() {
		return apadrinado;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setSociable(boolean sociable) {
		this.sociable = sociable;
	}
	
	public void setNSolicitudes(int nSolicitudes) {
		this.nSolicitudes = nSolicitudes;
	}
	
	public void setApadrinado(boolean apadrinado) {
		this.apadrinado = apadrinado;
	}
	
	public void setSolicitudes(Solicitud [] solicitudes) {
		this.solicitudes = solicitudes;
	}
	
	//Este metodo se utiliza para crear la solicitudes para un animal.
	//Una vez añadida la solicitud, se aumenta el numero de solicitudes.
	public void crearSolicitud(String nombre, int tipoSolicitud, String telefono) {

		solicitudes[nSolicitudes] = new Solicitud(nombre, tipoSolicitud, telefono);
		nSolicitudes++;
	}
	
	// Este metodo es un metodo abstracto. Se define abstracto ya que el comportamiento de las clases hijas es diferentes entre ellas.
	abstract double calcularGastosVeterinarioAnimal();
	
	// Ocurre lo mismo en este método abstracto.
	abstract double calcularGastosPienso();
	
	// Metodo toSTring que devuelve una cadena con la información del animal
	public String toString() {
		
		String esSociable = "";
		String esApadrinado = "";
		
		esSociable = (sociable) ? "es sociable" : "no es sociable";
		esApadrinado = (apadrinado) ? "esta apadrinado" : "no está apadrinado";
		
		return "El nombre del animal es " + nombre + ", la edad es de " + edad + " años, " + esSociable + 
				", actualmente tiene " + nSolicitudes + "solicitudes, " + esApadrinado + "\n";
	}
}


