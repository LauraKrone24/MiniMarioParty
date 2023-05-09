package com.example.minimarioparty;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;

public class Aktionsfeld extends Feld{

    public Aktionsfeld(int number, int x, int y) {
        super(number, x, y);
        // hier muss auch noch die Minispielliste initialisert werden
    }



    public int getMinispielnummer(){
        int x = (int) Math.random()*Hauptgame.minispielListe.size();
        return x;
    }

    public void  starteMinispiel(){
        int minispielnummer = getMinispielnummer();



        try{
            Minispiel m = Hauptgame.minispielListe.remove(minispielnummer);
            m.start(new Stage());
            Minispielrueckgabewert minispielrueckgabewert =  m.getMinispielrueckgabewert();
            System.out.println(minispielrueckgabewert);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Minispielende");
            alert.setHeaderText(null);
            alert.setContentText(minispielrueckgabewert.toString());
            alert.showAndWait();
            if(!minispielrueckgabewert.getAbbruch()){
                minispielrueckgabewert.getWinner().fuegeWuerfelhinzu(minispielrueckgabewert.getWuerfel());
            }

        }catch (Exception e){
            System.out.println("Kein Minispiel gefunden");
        }

    };
}
