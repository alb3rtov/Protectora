//Alberto Vázquez Martínez y Ángel Villafranca Iniesta

abstract class Animal implements Constantes {
	
	protected String nombre;
	protected String sexo;
	protected int edad;
	protected boolean sociable;
	protected int nSolicitudes;
	protected boolean apadrinado;
	protected Solicitud [] solicitudes;
	
	public Animal(String nombre, String sexo, int edad, boolean sociable, 
			int nSolicitudes, boolean apadrinado) {
		
		this.nombre = nombre;
		this.sexo = sexo;
		this.edad = edad;
		this.sociable = sociable;
		this.apadrinado = apadrinado;
		nSolicitudes = 0;
		solicitudes = new Solicitud[10];
	}
	
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
		
	public void crearSolicitud(String nombre, int tipoSolicitud, int telefono) {

		solicitudes[nSolicitudes] = new Solicitud(nombre, tipoSolicitud, telefono);
		nSolicitudes++;
	}
	
	abstract double calcularGastosVeterinarioAnimal();
	
	abstract double calcularGastosPienso();
	
	
	public String toString() {
		
		String esSociable = "";
		String esApadrinado = "";
		
		esSociable = (sociable) ? "es sociable" : "no es sociable";
		esApadrinado = (apadrinado) ? "esta apadrinado" : "no está apadrinado";
		
		return "El nombre del animal es " + nombre + ", la edad es de " + edad + " años, " + esSociable + 
				", actualmente tiene " + nSolicitudes + "solicitudes, " + esApadrinado + "\n";
	}
	
}


