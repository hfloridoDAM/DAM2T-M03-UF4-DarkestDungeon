package model;

import java.util.Scanner;

public class Character {
	public String nombre;
	public int salud;
	public int estres;
	public boolean vivo;
	public int saludMax;
	public int estresMax;
	
	public Character(int salud, int estres) {
		this.salud = salud;
		this.estres = estres;
		this.vivo = true;
		this.saludMax = salud;
		this.estresMax = estres;
	}
	
	public int getMaximo() {
		return 0;
	}
	
	public int getMinimo() {
		return 0;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int habilidad1() {
		return 1;
	}
	
	public int habilidad2() {
		return 1;
	}
	
	public int habilidad3() {
		return 1;
	}

	public int menu() {
		System.out.println("1 - Habilidad1 - " + getHabilidad1());
		System.out.println("2 - Habilidad2 - " + getHabilidad2());
		System.out.println("3 - Habilidad3 - " + getHabilidad3());
		Scanner s = new Scanner(System.in);
		while (true) {
			switch (s.nextInt()) {
				case 1: 
					return habilidad1();
				case 2:
					return habilidad2();
				case 3:
					return habilidad3();
				default:
					System.out.println("Opción incorrecta");
			}
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getSalud() {
		return salud;
	}

	public int getEstres() {
		return estres;
	}

	public boolean isVivo() {
		return vivo;
	}
	
	public String getHabilidad1() {
		return "no tiene efecto";
	}
	
	public String getHabilidad2() {
		return "no tiene efecto";
	}
	
	public String getHabilidad3() {
		return "no tiene efecto";
	}

	public void danar(int dano) {
		if (dano > 0) {
			this.salud -= dano;
		} else {
			this.estres += dano;
		}
		if (this.salud <= 0 || this.estres <= 0)
			this.vivo = false;
	}
	
	public void curar(int sana) {
		this.salud += sana;
		if (this.salud > this.saludMax) this.salud = this.saludMax;
	}
	
	public void desestresar(int estres) {
		this.estres += estres;
		if (this.estres > this.estresMax) this.estres = this.estresMax;
	}

	public void descansar() {
		this.salud = this.saludMax;
		this.estres = this.estresMax;
	}

	public Character copy() {
		return new Character(this.salud, this.estres);
	}

	public int habilidadRandom(int valor) {
		switch (valor) {
		case 0: return habilidad1();
		case 1: return habilidad2();
		case 2: return habilidad3();
		default:
			return 0;
		}
	}
}
