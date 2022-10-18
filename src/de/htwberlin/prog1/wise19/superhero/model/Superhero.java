package de.htwberlin.prog1.wise19.superhero.model;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author Julian Joachim s0574380
 * @version Eclipse 2019-09 4.1.3 / Java 1.8.0_ 191
 * zuletzt bearbeitet am 14.01.2020
 * Beinhaltet die Modellierung der Klasse Superhero.
 */

public class Superhero {

	Scanner sc = new Scanner(System.in);
	private String id = UUID.randomUUID().toString();
	private String name = "";
	private int healthPointsCurrent = 50;
	private int healthPointsMax = 50;
	private int experiencePoints = 0;
	private boolean readyToFight = true;
	private boolean inFight;
	private boolean alive = true;
	private boolean exists = false;

	public boolean isExists() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

	Random rng = new Random();

	// Start der Methoden

	// Konstruktor
	public Superhero(String name) {
		this.name = name;
	}

	public Superhero() {
	}

	// Start Getter Setter
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHealthPointsCurrent() {
		return healthPointsCurrent;
	}

	public void setHealthPointsCurrent(int healthPointsCurrent) {
		this.healthPointsCurrent = healthPointsCurrent;
	}

	public int getHealthPointsMax() {
		return healthPointsMax;
	}

	public void setHealthPointsMax(int healthPointsMax) {
		this.healthPointsMax = healthPointsMax;
	}

	public int getExperiencePoints() {
		return experiencePoints;
	}

	public void setExperiencePoints(int experiencePoints) {
		this.experiencePoints = experiencePoints;
	}

	public boolean isReadyToFight() {
		return readyToFight;
	}

	public void setReadyToFight(boolean readyToFight) {
		this.readyToFight = readyToFight;
	}

	public boolean isInFight() {
		return inFight;
	}

	public void setInFight(boolean inFight) {
		this.inFight = inFight;
	}

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	// Ende Getter Setter

	/**
	 * Methode attack <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Zeigt Attacke des Heroes an und berechnet dessen Schaden. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @param attackChoice Wahl der Attacke vom User.
	 * @return gibt Höhe des Angriffschadens zurück.
	 */
	public int attack(String attackChoice) {
		int attackDMG = rng.nextInt(6);
		int critRate = (this.experiencePoints * 2);
		boolean critSuccess = false;

		if ((rng.nextInt(100) + 1) <= critRate) {
			critSuccess = true;
		} else {
			critSuccess = false;
		}

		switch (attackDMG) {
		case 1:
			if (critSuccess == true) {
				System.out.println("Woah! Ein kritischer Treffer!");
				System.out.println("Der Superheld fuegt dem Villain " + (attackDMG * 2) + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG * 2);
			} else {
				System.out.println("Der Superheld fuegt dem Villain " + attackDMG + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG);
			}
		case 2:
			if (critSuccess == true) {
				System.out.println("Woah! Ein kritischer Treffer!");
				System.out.println("Der Superheld fuegt dem Villain " + (attackDMG * 2) + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG * 2);
			} else {
				System.out.println("Der Superheld fuegt dem Villain " + attackDMG + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG);
			}
		case 3:
			if (critSuccess == true) {
				System.out.println("Woah! Ein kritischer Treffer!");
				System.out.println("Der Superheld fuegt dem Villain " + (attackDMG * 2) + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG * 2);
			} else {
				System.out.println("Der Superheld fuegt dem Villain " + attackDMG + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG);
			}
		case 4:
			if (critSuccess == true) {
				System.out.println("Woah! Ein kritischer Treffer!");
				System.out.println("Der Superheld fuegt dem Villain " + (attackDMG * 2) + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG * 2);
			} else {
				System.out.println("Der Superheld fuegt dem Villain " + attackDMG + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG);
			}
		case 5:
			if (critSuccess == true) {
				System.out.println("Woah! Ein kritischer Treffer!");
				System.out.println("Der Superheld fuegt dem Villain " + (attackDMG * 2) + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG * 2);
			} else {
				System.out.println("Der Superheld fuegt dem Villain " + attackDMG + " Schaden mit seiner Power "
						+ attackChoice + " zu.");
				return (attackDMG);
			}
		default:
			return (0);
		} // end of switch-case
	}

	/**
	 * Methode takeDamage <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Zieht Leben vom User in Höhe des Damages vom Villains ab.. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @param damage Schaden, den der Villain verursacht.
	 */
	public void takeDamage(int damage) {
		this.healthPointsCurrent = (this.healthPointsCurrent - damage);
	}

	/**
	 * Methode flee <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Berechnet ob der Hero flüchtet oder nicht. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @return Ergebnis des Fluchtversuches
	 */
	public boolean flee() {
		int fleeResult = rng.nextInt(4);
		if ((fleeResult == 0)) {
			System.out.println("\nDer Villain hinderte den Helden an der Flucht!");
			return (false);
		} else {
			System.out.println("\nDer Held ist dem Kampf erfolgreich entflohen.");
			return (true);
		}
	}

	/**
	 * Methode dance <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Gibt aus, das der Held tanzt. <br>
	 * ------------------------------------------------------------------------ <br>
	 */

	public void dance() {
		System.out.println("Der Superheld tanzt!");
	}

	/**
	 * Methode sleep <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Lässt den Helden einschlafen und nicht mehr kampfbereit sein.
	 * derzeitige HP werden wiederhergestellt. <br>
	 * ------------------------------------------------------------------------ <br>
	 */

	public void sleep() {
		this.readyToFight = false;
		this.healthPointsCurrent = this.healthPointsMax;
		System.out.println(
				"Der Superheld ruht sich aus. Er setzt fuer eine Runde aus und seine HP fuellen sich wieder vollstaendig auf.");
	}

	/**
	 * Methode userInput <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Abfrage an den User. <br>
	 * ------------------------------------------------------------------------ <br>
	 * @return Rückgabe der Usereingabe
	 */
	public int userInput() {
		System.out.println("Welchen Punkt des Menues moechten Sie ausfuehren?");
		return (sc.nextInt());

	}

}
