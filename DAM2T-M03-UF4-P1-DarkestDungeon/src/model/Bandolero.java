package model;

import java.util.Random;

public class Bandolero extends Character{
	private String tipo;
	private int minimo;
	private int maximo;
	
	public Bandolero(int salud, int estres, int minimo, int maximo) {
		super(salud, estres);
		this.tipo = "Bandolero";
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
		return "Recupera 2 de salud y daño 1";
	}
	
	public String getHabilidad2() {
		return "daño -1";
	}
	
	public String getHabilidad3() {
		return "lanza 1 dado de 6 caras, si el resultado es 4, 5 o 6 daño 3";
	}

	public int habilidad1() {
		System.out.println(getHabilidad1());
		super.curar(2);
		return 1;
	}
	
	public int habilidad2() {
		System.out.println(getHabilidad2());
		return -1;
	}
	
	public int habilidad3() {
		System.out.println(getHabilidad3());
		Random rand = new Random();
		if (rand.nextInt(6)+1 >= 4) return 3;
		return 0;
	}
	
	public Bandolero copy() {
		return new Bandolero(super.salud, super.estres, this.minimo, this.maximo);
	}
	
	@Override
	public String toString() {
		return "[tipo=" + tipo + ", salud=" + salud + ", estres="
				+ estres + "]";
	}

}
