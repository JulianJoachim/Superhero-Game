package de.htwberlin.prog1.wise19.superhero.model;

import java.util.Scanner;
import java.util.UUID;

/**
 * @author Julian Joachim s0574380
 * @version Eclipse 2019-09 4.1.3 / Java 1.8.0_ 191
 * zuletzt bearbeitet am 14.01.2020
 * Beinhaltet die Modellierung der Klasse Superpower.
 */

public class Superpower {

	private String id = UUID.randomUUID().toString();
	private String name = "";
	private String actionDescription = "";
	Scanner sc = new Scanner(System.in);

	/**
	 * Methode createPower <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Lässt den Hero seine eigene Superpower erstellen. <br>
	 * ------------------------------------------------------------------------ <br>
	 * @param x Die wievielte Superpower gerade erstellt wird
	 */

	public void createPower(int x) {
		System.out.println("Wie soll deine " + x + "-te Superpower heissen?");
		this.name = sc.nextLine();
		System.out.println("Gebe nun bitte eine kurze Beschreibung deiner Power an!");
		this.actionDescription = sc.nextLine();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getActionDescription() {
		return actionDescription;
	}

	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}

}