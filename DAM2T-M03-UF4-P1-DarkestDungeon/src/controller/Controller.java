package controller;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import model.Abominacion;
import model.Asaltatumbas;
import model.Bandolero;
import model.CazaRecompensas;

public class Controller {
	private Scanner s;
	private ArrayList<model.Character> characters;
	private ArrayList<model.Character> enemigos;
	private model.Character[] todos;
	
	public Controller () {
		s = new Scanner(System.in);
		this.characters = new ArrayList<>();
		todos = new model.Character[4];
		todos[0] = new Abominacion(3,4,1,2);
		todos[1] = new CazaRecompensas(3,3,2,3);
		todos[2] = new Asaltatumbas(4,5,1,3);
		todos[3] = new Bandolero(5,4,2,4);
	}

	public void init() {
		menuInicial();
		boolean fin = false;
		do {
			showMenu();
			switch (s.nextInt()) {
				case 0: 
					fin = true; 
					break;
				case 1: 
					newDungeon();
					fin = true;
					break;
				case 2:
					descansar();
					break;
				case 3: 
					reordenar();
					break;
				default:
					System.out.println("Opción no válida");
			
			}
		} while (!fin);
		
	}
	
	private void descansar() {
		for (model.Character c : this.characters) {
			c.descansar();
		}
	}

	private void reordenar() {
		for (int j = 0; j < this.characters.size(); j++) {
			System.out.println(j + " - " + this.characters.get(j).toString());
		}
		System.out.println("¿Qué personaje quieres mover?");
		int origen = s.nextInt();
		System.out.println("¿A qué posición?");
		int destino = s.nextInt();
		
		ArrayList<model.Character> newChars = new ArrayList<>(); 
		for (int j = 0; j < this.characters.size(); j++) {
			if (j == destino) {
				newChars.add(this.characters.get(origen));
			} else if (j == origen) {
				newChars.add(this.characters.get(destino));
			} else {
				newChars.add(this.characters.get(j));
			}
		}
		this.characters = newChars;
		showCharacters();
	}
	
	private void showCharacters() {
		for (model.Character c : this.characters) {
			System.out.println(c.toString());
		}
	}
	
	private int showEnemigos(model.Character jugador) {
		System.out.println("Selecciona un enemigo");
		boolean isAlcance = false;
		
		//mostramos los enemigos con un indice delante
		for (int i = jugador.getMinimo(); i < (this.enemigos.size() > jugador.getMaximo() ? jugador.getMaximo() : this.enemigos.size()); i++) {
			if (this.enemigos.get(i).isVivo()) {
				isAlcance = true;
				System.out.println(i + " - " + this.enemigos.get(i).toString());
			}
		}
		if (!isAlcance) {
			System.out.println("---- SIN ENEMIGOS AL ALCANCE ----");
			return -1;
		}
		return s.nextInt();
	}

	private void newDungeon() {
		generarEnemigos();
		do {
			for (model.Character c : this.characters) {
				if (c.isVivo()) {
					System.out.println("Turno de: " + c.toString());
					int enemigo = showEnemigos(c);
					//miramos si hay enemigos al alcance
					if (enemigo != -1) {
						this.enemigos.get(enemigo).danar(c.menu());
					}
				}
			}
			for (model.Character c : this.enemigos) {
				if (c.isVivo()) {
					System.out.println("Enemigo: " + c.toString());
					this.characters.get(aleatorio()).danar(c.habilidadRandom(aleatorio()));
				}
			}
		} while (checkMuertos(this.characters) && checkMuertos(this.enemigos));
		if (checkMuertos(this.characters)) System.out.println("-------TODOS LOS JUGADORES MUERTOS------");
		else System.out.println("-------TODOS LOS ENEMIGOS MUERTOS------");
	}
	
	private boolean checkMuertos(ArrayList<model.Character> coleccion) {
		for (model.Character c : coleccion) {
			if (c.isVivo()) {
				return true;
			}
		}
		return false;
	}

	private void generarEnemigos() {
		this.enemigos = new ArrayList<>();
		for (int i = 0; i < aleatorio()+1; i++) {
			this.enemigos.add(this.todos[aleatorio()].copy());
		}
		System.out.println("----- ENEMIGOS -----");
		for (model.Character c : this.enemigos) {
			System.out.println(c.toString());
		}
		System.out.println();
	}
	
	private int aleatorio() {
		Random r = new Random();
		return r.nextInt(4);
	}

	private void menuInicial() {
		System.out.println("Escoge 4 personajes");
		for (int i = 1; i <= 4; i++) {
			System.out.println("Personaje " + i);
			for (int j = 0; j < this.todos.length; j++) {
				System.out.println(j + " - " + this.todos[j].toString());
			}
			this.characters.add(this.todos[s.nextInt()]);
		}
		System.out.println("\n--> INICIANDO PARTIDA <--");
		System.out.println("Personajes: ");
		showCharacters();
	}
	
	private void showMenu() {
		System.out.println("\n1 - Explorar mazmorra");
		System.out.println("2 - Descansar");
		System.out.println("3 - Reordenar equipo");
		System.out.println("0 - Finalizar partida");
	}

}
