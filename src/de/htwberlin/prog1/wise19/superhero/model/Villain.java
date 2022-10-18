package de.htwberlin.prog1.wise19.superhero.model;

import java.util.Random;
import java.util.UUID;

/**
 * @author Julian Joachim s0574380
 * @version Eclipse 2019-09 4.1.3 / Java 1.8.0_ 191
 * zuletzt bearbeitet am 14.01.2020
 * beinhaltet die Modellierung der Klasse Villain.
 */

public class Villain {

	private String id = UUID.randomUUID().toString();
	private String creatureType;
	private int healthPointsCurrent;
	private String superpower;
	private boolean alive;
	private int damage;
	private int worthExp;

	Random rng = new Random();

	// Start Methoden

	// Konstruktor
	public Villain() {
	}

	// Start Getter Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreatureType() {
		return creatureType;
	}

	public void setCreatureType(String creatureType) {
		this.creatureType = creatureType;
	}

	public int getHealthPointsCurrent() {
		return healthPointsCurrent;
	}

	public void setHealthPointsCurrent(int healthPointsCurrent) {
		this.healthPointsCurrent = healthPointsCurrent;
	}

	public String getSuperpower() {
		return superpower;
	}

	public void setSuperpower(String superpower) {
		this.superpower = superpower;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	/**
	 * Methode attack <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Zufallsberechnung, ob der Villain erfolgreich angreift. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @return Schaden, den der Villain zufügt.
	 */

	public int attack() {
		System.out.println("Der Villain greift mit seiner Superpower " + this.superpower + " an.");
		int attackRng = rng.nextInt(5);
		if ((attackRng == 0) || (attackRng == 1)) {
			System.out
					.println("\nDer Villain hat erfolgreich angegriffen! Der Held nimmt " + this.damage + " Schaden.");
			return (this.damage);
		} else {
			System.out.println("\nHaha! Der Villain verfehlt!");
			System.out.println();
			return (0);
		}
	}

	/**
	 * Methode takeDamage <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Gibt dem User die Anzahl an Schaden die der Villain nimmt aus,
	 * und zieht diese dann von seinen Max HP ab. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @param damage wieviel Schaden der Hero dem Villain zufügt
	 */
	public void takeDamage(int damage) {
		System.out
				.println("Der Villain wurde von der Superpower des Helden getroffen und nimmt " + damage + " Schaden!");
		this.healthPointsCurrent = (this.healthPointsCurrent - damage);
	}

	/**
	 * Methode showMenu <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Berechnet ob der Villain erfolgreicht flieht. <br>
	 * ------------------------------------------------------------------------ <br>
	 * @return Ergebnis des Fluchtversuches
	 */
	
	public boolean flee() {
		System.out.println("Der Villain versucht zu entkommen.");
		int fleeResult = rng.nextInt(5);
		if ((fleeResult == 0)) {
			System.out.println("\nDer Villain ist erfolgreich vor dem Helden geflohen.");
			return (true);
		} else {
			System.out.println("\nDer Held blockiert dem Villain den Weg! Die Flucht schlug fehl.");
			return (false);
		}
	}

	/**
	 * Methode generateVillain <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Generiert einen von 5 Villain, der auf bestimmten Parametern basiert. <br>
	 * ------------------------------------------------------------------------ <br>
	 */
	public void generateVillain() {
		int villainType = rng.nextInt(5);
		switch (villainType) {

		case 0:
			this.creatureType = "moechtegern Gangster";
			this.alive = true;
			this.id = UUID.randomUUID().toString();
			this.superpower = "Uppercut";
			this.healthPointsCurrent = 15;
			this.damage = 3;
			this.worthExp = 1;
			break;

		case 1:
			this.creatureType = "Bankraeuber";
			this.alive = true;
			this.id = UUID.randomUUID().toString();
			this.superpower = "Pouchspin";
			this.healthPointsCurrent = 20;
			this.damage = 5;
			this.worthExp = 2;
			break;

		case 2:

			this.creatureType = "Phantomdieb";
			this.alive = true;
			this.id = UUID.randomUUID().toString();
			this.superpower = "Gutshot";
			this.healthPointsCurrent = 25;
			this.damage = 7;
			this.worthExp = 3;
			break;
		case 3:
			this.creatureType = "Mafia Boss";
			this.alive = true;
			this.id = UUID.randomUUID().toString();
			this.superpower = "Bullet Rain";
			this.healthPointsCurrent = 30;
			this.damage = 9;
			this.worthExp = 5;
			break;

		case 4:
			this.creatureType = "Masked Villain";
			this.alive = true;
			this.id = UUID.randomUUID().toString();
			this.superpower = "Exitus letalis";
			this.healthPointsCurrent = 50;
			this.damage = 15;
			this.worthExp = 10;
			break;

		default:
		}
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getWorthExp() {
		return worthExp;
	}

	public void setWorthExp(int worthExp) {
		this.worthExp = worthExp;
	}

}
