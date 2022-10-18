package de.htwberlin.prog1.wise19.superhero.app;

import de.htwberlin.prog1.wise19.superhero.model.Superhero;
import de.htwberlin.prog1.wise19.superhero.model.Superpower;
import de.htwberlin.prog1.wise19.superhero.model.Villain;

import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

/**
 * @author Julian Joachim s0574380
 * @version Eclipse 2019-09 4.1.3 / Java 1.8.0_ 191
 * zuletzt bearbeitet am 14.01.2019 
 * beinhaltet die Main-Methode des Superhero Projektes und alle funktionalen Methoden.
 *
 */

public class SuperheroApp {

	private static Random rng = new Random();
	private static Scanner sc = new Scanner(System.in);
	private static int currentPSize = 0;
	private static boolean breakOut = false;
	private static Superhero heroes[] = new Superhero[5];
	private static Superpower powers[] = new Superpower[15];
	private static Villain villains[] = new Villain[1];

	/**
	 * Methode main <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Main Methode; startet das Programm. Beinhaltet zusaetzlich den
	 * Loop der das ganze Programm umfaesst. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		for (int p = 0; p < heroes.length; p++) {
			heroes[p] = new Superhero();
		}

		for (int p = 0; p < powers.length; p++) {
			powers[p] = new Superpower();
		}

		villains[0] = new Villain();

		while (true) {
			showMenu();
			handle(readUserInput());
			System.out.println("========================================================================");
		}
	} // end main

	/**
	 * Methode readUserInput <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Gibt ueber System.out.println eine Aufforderung aus, ein
	 * Menuepunkt auszuwaehlen. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @return Userinput (gewaehlter Menuepunkt)
	 */

	private static int readUserInput() {
		int choiceInternal;
		while (true) {
			try {
				System.out.print("\nBitte, geben Sie die Nummer des gewaehlten Menueeintrags ein:\t");
				choiceInternal = Integer.parseInt(sc.nextLine());
				break;
			}

			catch (Exception e) {
				System.out.println(
						"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
			}
		}

		return choiceInternal;
	}

	/**
	 * Methode handle <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Ordnet Auswahl vom User zu, um jeweilige Methoden aufzurufen.
	 * <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @param choice Wahl des Menuepunktes {@link #readUserInput()}
	 */

	private static void handle(int choice) {
		switch (choice) {
		case 1:
			createSuperhero();
			break;
		case 2:
			showHero();
			break;
		case 3:
			showAll();
			break;
		case 4:
			deleteHero();
			break;
		case 5:
			startAdv();
			break;
		case 6:
			exitGame();
			break;
		default: {
			System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
		}
			break;
		}
	}

	/**
	 * Methode handleAdv <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: gleiche wie handle, nur mit Adventure Methoden. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @param choice Wahl des Menuepunktes
	 * @see #handle(int)
	 */
	private static void handleAdv(int choice) {
		switch (choice) {
		case 1:
			erkunden();
			break;
		case 2:
			tanzen();
			break;
		case 3:
			schlafen();
			break;
		case 4:
			exitAdv();
			break;
		default: {
			System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
		}
			break;
		}
	}

	/**
	 * * Methode showMenu <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Gibt das Hauptmenu fuer den User aus. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 */
	private static void showMenu() {

		String menuItems[] = { "", "(1)\t Superheld anlegen", "(2)\t Daten eines Superhelden ausgeben",
				"(3)\t Daten aller Superhelden ausgeben", "(4)\t Superheld aus dem Team nehmen",
				"(5)\t Ein Abenteuer bestreiten", "(6)\t Beenden" };

		System.out.println("\nSuperheroes 1.0\n");
		for (int i = 1; i < menuItems.length; i++) {
			System.out.println(menuItems[i]);
		}

	}

	/**
	 * Methode showAdvMenu <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Gibt das Adventure Menu fuer den User aus. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @see #showMenu()
	 */

	private static void showAdvMenu() {

		String menuItems[] = { "", "(1)\t Erkunden", "(2)\t Tanzen", "(3)\t Schlafen", "(4)\t Abenteuer beenden" };

		System.out.println("\nAdventure Menu\n");
		for (int i = 1; i < menuItems.length; i++) {
			System.out.println(menuItems[i]);
		}

	}

	/**
	 * Methode createSuperHero <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Methode um Superheroes anzulegen. User kann dies manuell
	 * machen, oder vorgefertigte benutzen. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 */

	private static void createSuperhero() {
		int chooser = 0;
		int which = 0;
		if (currentPSize >= 5) {
			System.out.println(
					"Du kannst keinen weiteren Helden erstellen. Bitte entlasse zunaechst einen aus deiner Gruppe.");
			return;
		}

		System.out.println();
		if (currentPSize == 0) {

			while (true) {
				try {
					System.out.println(
							"Du kannst nun dein Team erstellen. \nMoechtest du sofort einen eigenen Helden erstellen (1), oder das Standard 3er Team benutzen (2)?");
					which = Integer.parseInt(sc.nextLine());
					break;
				}

				catch (Exception e) {
					System.out.println(
							"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
				}
			} // ende while

		} else {
			which = 1;
		}

		if (which == 1) {

			if (heroes[0].isExists() == false) {
				chooser = 0;
			} else if (heroes[1].isExists() == false) {
				chooser = 1;
			} else if (heroes[2].isExists() == false) {
				chooser = 2;
			} else if (heroes[3].isExists() == false) {
				chooser = 3;
			} else if (heroes[4].isExists() == false) {
				chooser = 4;
			} else {
				System.out.println(
						"Du kannst keinen weiteren Helden erstellen. Bitte entlasse zunaechst einen aus deiner Gruppe.");
				return;
			}

			switch (chooser) {
			case 0:
				System.out.println("Wie soll Ihr erstes Partymitglied heissen?");
				heroes[0].setExists(true);
				heroes[0].setExperiencePoints(0);
				heroes[0].setHealthPointsCurrent(50);
				heroes[0].setHealthPointsMax(50);
				heroes[0].setInFight(false);
				heroes[0].setAlive(true);
				heroes[0].setId(UUID.randomUUID().toString());
				heroes[0].setName(sc.next());
				powers[0].createPower(1);
				powers[1].createPower(2);
				powers[2].createPower(3);
				currentPSize++;
				break;
			case 1:
				System.out.println("Wie soll Ihr zweites Partymitglied heissen?");
				heroes[1].setExists(true);
				heroes[1].setExperiencePoints(0);
				heroes[1].setHealthPointsCurrent(50);
				heroes[1].setHealthPointsMax(50);
				heroes[1].setInFight(false);
				heroes[1].setAlive(true);
				heroes[1].setId(UUID.randomUUID().toString());
				heroes[1].setName(sc.next());
				powers[3].createPower(1);
				powers[4].createPower(2);
				powers[5].createPower(3);
				currentPSize++;
				break;
			case 2:
				System.out.println("Wie soll Ihr drittes Partymitglied heissen?");
				heroes[2].setExists(true);
				heroes[2].setExperiencePoints(0);
				heroes[2].setHealthPointsCurrent(50);
				heroes[2].setHealthPointsMax(50);
				heroes[2].setInFight(false);
				heroes[2].setAlive(true);
				heroes[2].setId(UUID.randomUUID().toString());
				heroes[2].setName(sc.next());
				powers[6].createPower(1);
				powers[7].createPower(2);
				powers[8].createPower(3);
				currentPSize++;
				break;
			case 3:
				System.out.println("Wie soll Ihr viertes Partymitglied heissen?");
				heroes[3].setExists(true);
				heroes[3].setExperiencePoints(0);
				heroes[3].setHealthPointsCurrent(50);
				heroes[3].setHealthPointsMax(50);
				heroes[3].setInFight(false);
				heroes[3].setAlive(true);
				heroes[3].setId(UUID.randomUUID().toString());
				heroes[3].setName(sc.next());
				powers[9].createPower(1);
				powers[10].createPower(2);
				powers[11].createPower(3);
				currentPSize++;
				break;
			case 4:
				System.out.println("Wie soll Ihr fuenftes Partymitglied heissen?");
				heroes[4].setExists(true);
				heroes[4].setExperiencePoints(0);
				heroes[4].setHealthPointsCurrent(50);
				heroes[4].setHealthPointsMax(50);
				heroes[4].setInFight(false);
				heroes[4].setAlive(true);
				heroes[4].setId(UUID.randomUUID().toString());
				heroes[4].setName(sc.next());
				powers[12].createPower(1);
				powers[13].createPower(2);
				powers[14].createPower(3);
				currentPSize++;
				break;

			}

		} else if (which == 2) {
			createDemoTeam();
		} else {
			System.out.println("Falsche Eingabe. Bitte wiederhole den Vorgang.");
		}

	}

	/**
	 * Methode showHero <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Output der Stats eines Heroes, den der User auswaehlt. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 */

	public static void showHero() {
		int c = 0;
		boolean testSH = true;

		if (currentPSize <= 0) {
			System.out.println();
			System.out.println("Es existiert kein Hero den Sie anzeigen koennten!");
			return;
		}

		do {
			testSH = true;
			while (true) {
				try {
					System.out.println("Von welchem Superhero moechten Sie die Daten angezeigt bekommen? (1-5)");
					c = Integer.parseInt(sc.nextLine());
					c = c - 1;
					break;
				}

				catch (Exception e) {
					System.out.println(
							"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
				}
			}

			if (c > 4) {
				System.out.println("Ihre Eingabe war fehlerhaft. Bitte waehle einen existierenden Superhero.");
				testSH = false;
			} else if (heroes[c].isExists() == false) {
				System.out.println("Ihre Eingabe war fehlerhaft. Bitte waehle einen existierenden Superhero.");
				testSH = false;
			}

		} while (testSH == false);

		System.out.println();
		System.out.println("Name: \t\t\t" + heroes[c].getName());
		System.out.println("Heronummer: \t\t" + (c + 1));
		System.out.println("HP: \t\t\t" + heroes[c].getHealthPointsCurrent() + "/" + heroes[c].getHealthPointsMax());
		System.out.println("EXP: \t\t\t" + heroes[c].getExperiencePoints());

		System.out.println();
		System.out.println("Bereit zu kaempfen: \t" + heroes[c].isReadyToFight());
		System.out.println("Am Leben: \t\t" + heroes[c].isAlive());

		System.out.println();
		System.out.println("Erste Superpower: " + powers[c * 3].getName());
		System.out.println(powers[c * 3].getActionDescription());

		System.out.println();
		System.out.println("Zweite Superpower: " + powers[(c * 3) + 1].getName());
		System.out.println(powers[(c * 3) + 1].getActionDescription());

		System.out.println();
		System.out.println("Dritte Superpower: " + powers[(c * 3) + 2].getName());
		System.out.println(powers[(c * 3) + 2].getActionDescription());
	}

	/**
	 * Methode createDemoTeam <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Erstellt das Test Team, mit welchem der User schneller arbeiten
	 * kann. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 */

	public static void createDemoTeam() {
		heroes[0].setExists(true);
		heroes[0].setName("Alpha");
		heroes[0].setExperiencePoints(0);
		heroes[0].setHealthPointsCurrent(50);
		heroes[0].setHealthPointsMax(50);
		heroes[0].setInFight(false);
		heroes[0].setAlive(true);
		heroes[0].setId(UUID.randomUUID().toString());
		powers[0].setName("Alpha Beam");
		powers[1].setName("Magnet Pull");
		powers[2].setName("Hand Drill");

		powers[0].setActionDescription("Alpha sammelt Energie in seiner Hand und schleudert diese auf den Gegner.");
		powers[1].setActionDescription(
				"Alpha erzeugt Magnetenergie in seinem Koerper, welche den Gegner ranzieht. \nAlpha schlaegt den Gegner waehrend er rangezogen wird.");
		powers[2].setActionDescription("Alpha bohrt mit seiner Handflaeche in den Koerper des Gegners ein.");

		heroes[1].setExists(true);
		heroes[1].setName("Beta");
		heroes[1].setExperiencePoints(0);
		heroes[1].setHealthPointsCurrent(50);
		heroes[1].setHealthPointsMax(50);
		heroes[1].setInFight(false);
		heroes[1].setAlive(true);
		heroes[1].setId(UUID.randomUUID().toString());
		powers[3].setName("Roundhouse Kick");
		powers[4].setName("Skullcracker");
		powers[5].setName("Beta");

		powers[3].setActionDescription("Ein maechtiger Kick der dem Gegner schwer zusetzt.");
		powers[4].setActionDescription("Der Held gibt dem Gegner eine maechtige Kopfnuss.");
		powers[5].setActionDescription(
				"Betas Spezialfaehigkeit. Sie fuegt dem Gegner immensen Schaden zu, die Ausfuehrung ist jedoch immer anders und unberechenbar.");

		heroes[2].setExists(true);
		heroes[2].setExperiencePoints(0);
		heroes[2].setHealthPointsCurrent(50);
		heroes[2].setHealthPointsMax(50);
		heroes[2].setInFight(false);
		heroes[2].setAlive(true);
		heroes[2].setId(UUID.randomUUID().toString());
		heroes[2].setName("Delta");
		powers[6].setName("Tidal Wave");
		powers[7].setName("Scorching Blade");
		powers[8].setName("Thunder Rain");

		powers[6].setActionDescription(
				"Der Held erschafft riesige Wassermassen, welche er mit enormer Wucht auf den Gegner schleudert.");
		powers[7].setActionDescription(
				"Der Held uemhuellt sein Schwert mit gluehend heißen Flammen, und attackiert damit den Gegner.");
		powers[8].setActionDescription("Der Held laesst Blitze auf seine Gegner niederregnen.");

		currentPSize = 3;
	}

	/**
	 *
	 * Methode showAll <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Output der Stats aller Heroes. <br>
	 * ------------------------------------------------------------------------ <br>
	 */

	public static void showAll() {
		int c = 0;

		if (currentPSize <= 0) {
			System.out.println("Es existiert kein Hero den Sie anzeigen koennten!");
			return;
		}

		System.out.println();
		System.out.println("Die aktuelle Partygroeße betraegt: " + currentPSize);

		for (c = 0; c < 5; c++) {
			if (heroes[c].isExists() == false) {
			} else {
				System.out.println("========================================================================");
				System.out.println("Name: \t\t\t" + heroes[c].getName());
				System.out.println("Heronummer: \t\t" + (c + 1));
				System.out.println(
						"HP: \t\t\t" + heroes[c].getHealthPointsCurrent() + "/" + heroes[c].getHealthPointsMax());
				System.out.println("EXP: \t\t\t" + heroes[c].getExperiencePoints());

				System.out.println();
				System.out.println("Bereit zu kaempfen: \t" + heroes[c].isReadyToFight());
				System.out.println("Am leben: \t\t" + heroes[c].isAlive());

				System.out.println();
				System.out.println("Erste Superpower: " + powers[c * 3].getName());
				System.out.println(powers[c * 3].getActionDescription());

				System.out.println();
				System.out.println("Zweite Superpower: " + powers[(c * 3) + 1].getName());
				System.out.println(powers[(c * 3) + 1].getActionDescription());

				System.out.println();
				System.out.println("Dritte Superpower: " + powers[(c * 3) + 2].getName());
				System.out.println(powers[(c * 3) + 2].getActionDescription());

			}
		}
	}

	/**
	 * * Methode deleteHero <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Erlaubt dem User einen Hero permanent aus seinem Team zu
	 * entfernen. <br>
	 * ------------------------------------------------------------------------ <br>
	 */

	public static void deleteHero() {
		System.out.println();
		boolean testDH = true;
		int delChoice;
		do {
			testDH = true;
			if (currentPSize <= 0) {
				System.out.println("Es existiert kein Hero den sie loeschen koennten!");
				return;
			}

			while (true) {

				try {
					System.out.println(
							"Welchen Superhelden moechten Sie aus Ihrer Party entlassen? (1-5) Zum Abbrechen, druecke (6).");
					System.out.println("ACHTUNG! Der Superheld verschwindet fuer immer aus Ihrer Party!");
					delChoice = Integer.parseInt(sc.nextLine());
					delChoice = delChoice - 1;
					break;
				}

				catch (Exception e) {
					System.out.println(
							"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
				}
			}

			if (delChoice == 5) {
				return;
			} else if (delChoice > 4) {
				System.out.println();
				System.out.println("Ihre Eingabe war fehlerhaft. Bitte waehle einen existierenden Partyslot.");
				System.out.println();
				testDH = false;
			} else if (heroes[delChoice].isExists() == false) {
				System.out.println();
				System.out.println("Ihre Eingabe war fehlerhaft. Bitte waehle einen existierenden Partyslot.");
				System.out.println();
				testDH = false;
			}

		} while (testDH == false);

		heroes[delChoice].setExists(false);
		currentPSize--;
	}

	/**
	 * Methode startAdv <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: aehnlich der main Methode, loopt diese Methode das Abenteuer.
	 * <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @see #main(String[])
	 */

	public static void startAdv() {
		breakOut = false;
		while (true) {
			showAdvMenu();
			handleAdv(readUserInput());
			System.out.println();
			System.out.println("========================================================================");

			// Abbrechen des Abenteuers
			if (breakOut == true) {
				return;
			}
		}
	}

	/**
	 * Methode erkunden <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Suche nach einem Villain. 50% Chance diesen zu finden. Startet
	 * den Kampf. <br>
	 * ------------------------------------------------------------------------ <br>
	 */

	public static void erkunden() {
		int checkAll = 0;

		for (int z = 0; z < 5; z++) {
			if (heroes[z].isExists() == true && heroes[z].isReadyToFight() == true) {
				checkAll++;
			}
		}

		if (checkAll <= 0) {
			System.out.println("Du hast keinen lebenden Helden zur Verfuegung.");
		} else {

			if (rng.nextInt(2) == 0) {
				System.out.println("Die Helden erkunden die Gegend, finden jedoch nichts verdaechtiges.");
			} else {
				villains[0].generateVillain();
				System.out.println(
						"Die Heldengruppe erkundet die Gegend und trifft auf einen " + villains[0].getCreatureType()
								+ "! Der " + villains[0].getCreatureType() + " greift die Helden an!");
				startKampfI();
			}
		} // Ende von else
	} // Ende von Methode "erkunden"

	/**
	 * Methode startKampfI <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Startet den Kampf. User kann einen Helden fuer den Kampf
	 * auswaehlen. <br>
	 * ------------------------------------------------------------------------ <br>
	 */

	public static void startKampfI() {
		boolean checkSKI = true;
		int kampfCheck = 0;
		int heldCheck = 0;
		System.out.println("\nDer Gegner greift ihr Team an.");

		do {
			checkSKI = true;

			while (true) {
				try {
					System.out.println("(1)\t Superheld fuer Kampf auswaehlen");
					heldCheck = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println(
							"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
				}
			}
			if (heldCheck == 1) {

				while (true) {
					try {
						System.out.println("Welchen Superheld wollen Sie in den Kampf schicken? (1-5);");

						for (int z = 0; z < heroes.length; z++) {
							if (heroes[z].isExists() == true) {
								System.out.println("(" + (z + 1) + ") =\t" + heroes[z].getName() + "\t"
										+ heroes[z].getHealthPointsCurrent() + "/" + heroes[z].getHealthPointsMax()
										+ " HP");
							}
						}
						kampfCheck = Integer.parseInt(sc.nextLine());
						kampfCheck = kampfCheck - 1;
						break;
					} catch (Exception e) {
						System.out.println(
								"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
					}
				}

				if (kampfCheck > 4) {
					System.out.println("Dieser Superheld existiert nicht. Bitte nimm eine korrekte Auswahl vor.");
					checkSKI = false;
				} else if (heroes[kampfCheck].isExists() == false) {
					System.out.println("Dieser Superheld existiert nicht. Bitte nimm eine korrekte Auswahl vor.");
					checkSKI = false;
				} else if (heroes[kampfCheck].isReadyToFight() == false) {
					System.out.println(
							"Dieser Held ist derzeit nicht bereit zu kaempfen. Bitte nimm eine korrekte Auswahl vor.");
					checkSKI = false;
				}

			} else {
				System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
				checkSKI = false;
			}

		} while (checkSKI == false);

		startKampfII(kampfCheck);
	} // Ende Methode "startKampfI"

	/**
	 * Methode showMenu <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Ablauf des Kampfes und der Erfahrung die gewonnen wird. Weckt
	 * Helden die schlafen auf. <br>
	 * ------------------------------------------------------------------------ <br>
	 * 
	 * @param hero ausgewaehlter Held aus der Methode @link {@link #startKampfI()}
	 */

	public static void startKampfII(int hero) {
		// Villain generieren
		System.out.println("\nDer Kampf beginnt!\n");
		boolean end = false;
		boolean preemptiveStrike = true;
		int choiceSKII = 0;
		int attackChoice;

		heroes[hero].setInFight(true);

		do {
			end = false;
			System.out.println(
					"================================================================================================");
			System.out.println();
			System.out.println("Der Held hat noch " + heroes[hero].getHealthPointsCurrent() + " Lebenspunkte uebrig.");
			System.out
					.println("Der Villain hat noch " + villains[0].getHealthPointsCurrent() + " Lebenspunkte uebrig.");
			System.out.println();

			while (true) {
				try {
					System.out.println("Was soll der Held machen?");

					String menuItems[] = { "", "(1)\t Kaempfen", "(2)\t Fliehen" };
					for (int i = 1; i < menuItems.length; i++) {
						System.out.println(menuItems[i]);
					}
					choiceSKII = Integer.parseInt(sc.nextLine());
					break;
				}

				catch (Exception e) {
					System.out.println(
							"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
				}
			}

			if (choiceSKII > 2) {
				System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
			} else if (choiceSKII <= 0) {
				System.out.println("Ungueltige Eingabe. Bitte ueberpruefen Sie Ihre Eingabe");
			} else if (choiceSKII == 1) {
				// Kern des Kampfes

				// Flucht des Villains, am Start von jeder Kampfrunde, mit Ausnahme der ersten,
				// 20% Chance
				if (preemptiveStrike == true) {
					preemptiveStrike = false;
				} else if (villains[0].flee() == true) {
					end = true;
					break;
				}

				// Der Villain greift zu 40% an und fuegt 5 Schaden zu
				heroes[hero].takeDamage(villains[0].attack());

				// Check ob Hero noch lebt
				if (heroes[hero].getHealthPointsCurrent() <= 0) {
					System.out.println(
							"Der Treffer des Villains war fatal... " + heroes[hero].getName() + " ist gestorben.");
					end = true;
					heroes[hero].setExists(false);
				} else {

					// User input welche Attacke benutzt wird
					while (true) {
						try {
							System.out.println("Mit welcher Attacke soll der Held angreifen? (1-3)");
							attackChoice = Integer.parseInt(sc.nextLine());
							attackChoice = attackChoice - 1;
							break;
						} catch (Exception e) {
							System.out.println(
									"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
						}
					}

					System.out.println();
					// Superhero greift mit 1-5 DMG mit seiner userinput attacke an.
					villains[0].takeDamage(heroes[hero].attack(powers[(hero * 3) + attackChoice].getName()));

					if (villains[0].getHealthPointsCurrent() <= 0) {
						end = true;
					}

				} // ende von if-else hp check hero
			} else if (choiceSKII == 2) {
				if (heroes[hero].flee() == true) {
					end = true;
				}
			}

		} while (end == false);

		if (villains[0].getHealthPointsCurrent() <= 0) {
			System.out.println();
			System.out.println("Der Held konnte den Villain erfolgreich besiegen!");
			System.out
					.println("Der Held hat den Kampf gewonnen und erhaelt " + villains[0].getWorthExp() + " EXP dazu.");
			heroes[hero].setExperiencePoints((heroes[hero].getExperiencePoints()) + (villains[0].getWorthExp()));
			System.out.println("Damit hat er nun insgesamt " + heroes[hero].getExperiencePoints() + " EXP.");
			heroes[hero].setHealthPointsMax(50 + (heroes[hero].getExperiencePoints() / 3));
			System.out.println(
					"Seine maximalen Lebenspunkte betragen derzeit " + heroes[hero].getHealthPointsMax() + ".");
		}

		for (int z = 0; z < 5; z++) {
			if (heroes[z].isReadyToFight() == false) {
				System.out.println();
				heroes[z].setReadyToFight(true);
				heroes[z].setHealthPointsCurrent(heroes[z].getHealthPointsMax());
				System.out.println("Der Held " + heroes[z].getName()
						+ " erwacht von seinem Schlaf. Seine Lebenspunkte sind nun wieder vollstaendig aufgefuellt!");
			}
		}

		heroes[hero].setInFight(false);
	}

	/**
	 * Methode tanzen <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Laesst einen Helden, welchen der User waehlt, tanzen. <br>
	 * ------------------------------------------------------------------------ <br>
	 */

	// Start der Methode "tanzen"
	public static void tanzen() {
		boolean checkT;
		int tanzCheck;
		int checkAll = 0;

		for (int z = 0; z < 5; z++) {
			if (heroes[z].isExists() == true && heroes[z].isReadyToFight() == true) {
				checkAll++;
			}
		}

		if (checkAll <= 0) {
			System.out.println("Du hast keinen lebenden Helden zur Verfuegung.");
		} else {
			do {
				checkT = true;

				while (true) {
					try {
						System.out.println("Welcher Superheld soll das Tanzbein schwingen lassen? (1-5)");
						tanzCheck = Integer.parseInt(sc.nextLine());
						tanzCheck = tanzCheck - 1;
						break;
					} catch (Exception e) {
						System.out.println(
								"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
					}
				}

				if (tanzCheck > 4) {
					System.out.println("Dieser Superheld existiert nicht. Bitte nimm eine korrekte Auswahl vor.");
					checkT = false;
				} else if (heroes[tanzCheck].isExists() == false) {
					System.out.println("Dieser Superheld existiert nicht. Bitte nimm eine korrekte Auswahl vor.");
					checkT = false;
				} else if (heroes[tanzCheck].isReadyToFight() == false) {
					System.out.println("Dieser Held schlaeft gerade. Bitte nimm eine korrekte Auswahl vor.");
					checkT = false;
				} else {
					System.out.println("Der Superheld " + heroes[tanzCheck].getName() + " tanzt!");
				}

			} while (checkT == false);
		}
	}

	/**
	 * Methode schlafen <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: User kann einen Helden schlafen legen. Dieser regeneriert sein
	 * Leben komplett. Nach der Methode @link {@link #startKampfII(int)} wird dieser
	 * geweckt.<br>
	 * ------------------------------------------------------------------------ <br>
	 */
	// Start der Methode "schlafen"
	public static void schlafen() {
		boolean checkS;
		int schlafCheck;
		int checkAllSleep = 0;

		for (int z = 0; z < 5; z++) {
			if (heroes[z].isExists() == true && heroes[z].isReadyToFight() == true) {
				checkAllSleep++;
			}
		}

		if (checkAllSleep <= 1) {
			System.out.println(
					"Du hast nicht genug kampffaehige Heroes zur Verfuegung. Du kannst derzeit also keinen Helden zu Schlaf schicken.");
		} else {

			do {
				checkS = true;

				while (true) {
					try {

						System.out.println(
								"Welcher Superheld soll sich erholen? Er wird fuer den naechsten Kampf nicht zur Verfuegung stehen, dafuer aber seine Lebenspunkte vollstaendig generieren. (1-5)");
						schlafCheck = Integer.parseInt(sc.nextLine());
						schlafCheck = schlafCheck - 1;
						break;
					} catch (Exception e) {
						System.out.println(
								"Sie haben keine Zahl eingegeben. Bitte waehle einen Menuepunkt durch Eingabe der jeweiligen Zahl.");
					}
				}
				if (schlafCheck > 4) {
					System.out.println("Dieser Superheld existiert nicht. Bitte nimm eine korrekte Auswahl vor.");
					checkS = false;
				} else if (heroes[schlafCheck].isExists() == false) {
					System.out.println("Dieser Superheld existiert nicht. Bitte nimm eine korrekte Auswahl vor.");
					checkS = false;
				} else if (heroes[schlafCheck].isReadyToFight() == false) {
					System.out.println("Dieser Held schlaeft bereits. Bitte waehle einen Anderen Helden.");
					checkS = false;
				} else {
					System.out.println("Der Superheld " + heroes[schlafCheck].getName() + " legt sich schlafen.");
					heroes[schlafCheck].setReadyToFight(false);
				}

			} while (checkS == false);
		}
	}

	/**
	 * Methode exitAdv <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Beendet das Abenteuer und geht zurueck zum Hauptmenue. <br>
	 * ------------------------------------------------------------------------ <br>
	 */
	public static void exitAdv() {
		System.out.println();
		System.out.println("Die Helden kehren vom Abenteuer zurueck.");
		breakOut = true;
	}

	/**
	 * Methode exitGame <br>
	 * ------------------------------------------------------------------------ <br>
	 * Beschreibung: Beendet das Programm. <br>
	 * ------------------------------------------------------------------------ <br>
	 */
	// Start der Methode "exitGame" - Beendet das Programm
	public static void exitGame() {
		System.out.println("Das Spiel wird nun beendet! Danke fuers Spielen. :)");
		System.exit(0);
	}

}
