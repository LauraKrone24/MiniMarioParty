package com.example.minimarioparty;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;

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

        Platform.runLater(()->{

        try{
            Minispiel m = Hauptgame.minispielListe.remove(minispielnummer);
            Alert schwierigkeitsauswahl = new Alert(Alert.AlertType.CONFIRMATION);
            schwierigkeitsauswahl.setTitle("Minispiel Schwierigkeit");
            schwierigkeitsauswahl.setHeaderText("Du bist auf einem Minispielfeld gelandet");
            schwierigkeitsauswahl.setContentText("Willst du ein leichtes oder schweres Spiel ?\n(Schwere Spiele bringen dir einen besseren Bonus)");

            ButtonType buttonLeicht= new ButtonType("Leicht");
            ButtonType buttonSchwer = new ButtonType("Schwer");
            ButtonType buttonKeinMinispiel = new ButtonType("Minispiel überspringen");

            schwierigkeitsauswahl.getButtonTypes().setAll(buttonLeicht, buttonSchwer,buttonKeinMinispiel);

            Optional<ButtonType> result = schwierigkeitsauswahl.showAndWait();

            if(result.get()== buttonLeicht){
                m.setLeicht(true);
            }
            else if (result.get()== buttonSchwer) {
                m.setLeicht(false);
            }
            else{
                try{throw new Exception("Minispiel Skipped");}catch (Exception e){e.printStackTrace();}
            }

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
            e.printStackTrace();
            System.out.println("Kein Minispiel gefunden");
        }
        });

    };
}
