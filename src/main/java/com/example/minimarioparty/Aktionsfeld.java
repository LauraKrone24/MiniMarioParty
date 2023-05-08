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

    public Minispielrueckgabewert  starteMinispiel(){
        int minispielnummer = getMinispielnummer();
        Minispiel m = minispielListe.get(minispielnummer);
        try{m.start(new Stage());
           Minispielrueckgabewert spielRueck=  m.getMinispielrueckgabewert();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Minispielende");
            alert.setHeaderText(null);
            alert.setContentText(spielRueck.toString());
            alert.showAndWait();
            return spielRueck;
        }catch (Exception e){}
        return new Minispielrueckgabewert(true,null,null);

    };
}
