package model;

import java.util.Random;

public class Asaltatumbas extends Character{
	private String tipo;
	private int minimo;
	private int maximo;
	
	public Asaltatumbas(int salud, int estres, int minimo, int maximo) {
		super(salud, estres);
		this.tipo = "Asaltatumbas";
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
		return "lanza 1 dado de 6 caras. Si el resultado es 1, 2 o 3 daño 3";
	}
	
	public String getHabilidad2() {
		return "daño 2";
	}
	
	public String getHabilidad3() {
		return "lanza 1 dado de 6 caras. Si el resultado es 5 o 6 daño -2";
	}

	public int habilidad1() {
		System.out.println(getHabilidad1());
		Random rand = new Random();
		if (rand.nextInt(6)+1 <= 3) return 3;
		return 0;
	}
	
	public int habilidad2() {
		System.out.println(getHabilidad2());
		return 2;
	}
	
	public int habilidad3() {
		System.out.println(getHabilidad3());
		Random rand = new Random();
		if (rand.nextInt(6)+1 >= 5) return -2;
		return 0;
	}
	
	public Asaltatumbas copy() {
		return new Asaltatumbas(super.salud, super.estres, this.minimo, this.maximo);
	}
	
	@Override
	public String toString() {
		return "[tipo=" + tipo + ", salud=" + salud + ", estres="
				+ estres + "]";
	}

}
