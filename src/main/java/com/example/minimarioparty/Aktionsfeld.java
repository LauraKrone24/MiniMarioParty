package com.example.minimarioparty;

import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.List;

public class Aktionsfeld extends Feld{
    private List<Minispiel>  minispielListe;
    public Aktionsfeld(int number, int x, int y) {
        super(number, x, y);
        // hier muss auch noch die Minispielliste initialisert werden
    }



    public int getMinispielnummer(){
        int x = (int) Math.random()*minispielListe.size();
        return x;
    }

    public void  starteMinispiel(){
        int minispielnummer = getMinispielnummer();
        Minispiel m = minispielListe.get(minispielnummer);
        try{
            m.start(new Stage());
           Minispielrueckgabewert minispielrueckgabewert=  m.getMinispielrueckgabewert();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Minispielende");
            alert.setHeaderText(null);
            alert.setContentText(minispielrueckgabewert.toString());
            alert.showAndWait();
            if(!minispielrueckgabewert.getAbbruch()){
                minispielrueckgabewert.getWinner().fuegeWuerfelhinzu(minispielrueckgabewert.getWuerfel());
            }

        }catch (Exception e){}

    };
}
