package model;

import java.util.Random;

public class Abominacion extends Character{
	private String tipo;
	private int minimo;
	private int maximo;
	
	public Abominacion(int salud, int estres, int minimo, int maximo) {
		super(salud, estres);
		this.tipo = "Abominacion";
		this.minimo = minimo;
		this.maximo = maximo;
	}
	
	public int getMaximo() {
		return this.maximo;
	}
	
	public int getMinimo() {
		return this.minimo;
	}
	
	public String getHabilidad1() {
		return "daño 3";
	}
	
	public String getHabilidad2() {
		return "lanza 2 dados de 6 caras y suma su resultado como daño";
	}
	
	public String getHabilidad3() {
		return "daño -1";
	}
	
	public String getTipo() {
		return this.tipo;
	}

	public int habilidad1() {
		System.out.println(getHabilidad1());
		return 3;
	}
	
	public int habilidad2() {
		System.out.println(getHabilidad2());
		Random rand = new Random();
		
		return rand.nextInt(6) + rand.nextInt(6) + 2;
	}
	
	public int habilidad3() {
		System.out.println(getHabilidad3());
		return -1;
	}

	public Abominacion copy() {
		return new Abominacion(super.salud, super.estres, this.minimo, this.maximo);
	}
	
	@Override
	public String toString() {
		return "[tipo=" + tipo + ", salud=" + salud + ", estres="
				+ estres + "]";
	}

}
