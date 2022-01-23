package model;

import java.util.Random;

public class CazaRecompensas extends Character{
	private String tipo;
	private int minimo;
	private int maximo;
	
	public CazaRecompensas(int salud, int estres, int minimo, int maximo) {
		super(salud, estres);
		this.tipo = "CazaRecompensas";
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
		return "recupera 1 de estrés y daño 1";
	}
	
	public String getHabilidad2() {
		return "lanza 2 dados de 6 caras. Si el resultado de la suma es 7 daño -5";
	}
	
	public String getHabilidad3() {
		return "daño -1";
	}

	public int habilidad1() {
		System.out.println(getHabilidad1());
		super.desestresar(1);
		return 1;
	}
	
	public int habilidad2() {
		System.out.println(getHabilidad2());
		Random rand = new Random();
		if (rand.nextInt(6) + rand.nextInt(6) + 2 == 7) return -5;
		return 0;
	}
	
	public int habilidad3() {
		System.out.println(getHabilidad3());
		return -1;
	}
	
	@Override
	public String toString() {
		return "[tipo=" + tipo + ", salud=" + salud + ", estres="
				+ estres + "]";
	}

	public CazaRecompensas copy() {
		return new CazaRecompensas(super.salud, super.estres, this.minimo, this.maximo);
	}

}
