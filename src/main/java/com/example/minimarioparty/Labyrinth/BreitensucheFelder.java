package com.example.minimarioparty.Labyrinth;

import javafx.application.Platform;
import javafx.scene.paint.Paint;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreitensucheFelder {
	public static List<LaberithField> findePfad(LaberithField startKnoten,
												LaberithField zielKnoten) {

		List<LaberithField> ergebnisPfad = new ArrayList<>();
		Queue<LaberithField> q = new LinkedList<>();
		q.add(startKnoten);
		startKnoten.setMarkiert(true);
		
		while (!q.isEmpty() && ergebnisPfad.isEmpty()) {
			LaberithField aktuellerKnoten = q.remove();
			System.out.println(aktuellerKnoten.num+";"+zielKnoten.num);
			if (aktuellerKnoten.num == zielKnoten.num) {

				ergebnisPfad.addAll(aktuellerKnoten.getSuchPfad());
				ergebnisPfad.add(aktuellerKnoten);
				
			} else {
				for (LaberithField nachbar : aktuellerKnoten.getNachbarn() ) {
					if (!nachbar.isMarkiert()) {

						q.add(nachbar);
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