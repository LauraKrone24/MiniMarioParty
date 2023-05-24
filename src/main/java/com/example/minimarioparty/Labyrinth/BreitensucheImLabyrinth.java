package com.example.minimarioparty.Labyrinth;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreitensucheImLabyrinth {
	public static List<LabyrinthField> findWay(LabyrinthField startFeld,
											   LabyrinthField zielFeld) {

		//Variablen initialisieren
		List<LabyrinthField> ergebnisPfad = new ArrayList<>();
		Queue<LabyrinthField> labyrinthFieldQueue = new LinkedList<>();
		labyrinthFieldQueue.add(startFeld);
		startFeld.setMarkiert(true);
		
		while (!labyrinthFieldQueue.isEmpty() && ergebnisPfad.isEmpty()) {
			LabyrinthField aktuellerKnoten = labyrinthFieldQueue.remove();

			// Wenn Zielfeld, ergebnispfad erstellen
			if (aktuellerKnoten.getNum() == zielFeld.getNum()) {

				ergebnisPfad.addAll(aktuellerKnoten.getSuchPfad());
				ergebnisPfad.add(aktuellerKnoten);
				
			} else {
				// sonst noch nicht markierte Nachbarn markieren, in die Queue einfügen und Suchpfad setzten
				for (LabyrinthField nachbar : aktuellerKnoten.getNachbarn() ) {
					if (!nachbar.isMarkiert()) {

						labyrinthFieldQueue.add(nachbar);
						nachbar.setMarkiert(true);
						nachbar.getSuchPfad().addAll(aktuellerKnoten.getSuchPfad()) ;
						nachbar.getSuchPfad().add(aktuellerKnoten);
						
					}
				}
			}
		}
		return ergebnisPfad;
	}
}
