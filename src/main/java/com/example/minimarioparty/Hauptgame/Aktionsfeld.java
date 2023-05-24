package com.example.minimarioparty.Hauptgame;

import com.example.minimarioparty.Minispiel;
import com.example.minimarioparty.Minispielrueckgabewert;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;


import java.util.Optional;

public class Aktionsfeld extends Feld {

    public Aktionsfeld(int number, int x, int y) {
        super(number, x, y);
    }



    private int getMinispielnummer(){
        return (int) (Math.random()*Hauptgame.minispielListe.size());
    }

    public void  starteMinispiel(){

        Platform.runLater(()->{

        try{
            //Wahl des Minispiels
            Minispiel m = Hauptgame.minispielListe.remove(getMinispielnummer());

            //Ausgabe Alert: Minispiel gestartet und Schwierigkeitswahl
            Alert schwierigkeitsauswahl = new Alert(Alert.AlertType.CONFIRMATION);
            schwierigkeitsauswahl.setTitle("Minispiel Schwierigkeit");
            schwierigkeitsauswahl.setHeaderText("Du bist auf einem Minispielfeld gelandet ("+m.getClass().getSimpleName()+")");
            schwierigkeitsauswahl.setContentText("Willst du ein leichtes oder schweres Spiel ?\n(Schwere Spiele bringen dir einen besseren Bonus)");

            ButtonType buttonLeicht= new ButtonType("Leicht");
            ButtonType buttonSchwer = new ButtonType("Schwer");
            ButtonType buttonKeinMinispiel = new ButtonType("Minispiel überspringen");

            schwierigkeitsauswahl.getButtonTypes().setAll(buttonLeicht, buttonSchwer,buttonKeinMinispiel);

            Optional<ButtonType> result = schwierigkeitsauswahl.showAndWait();

            //setzten der Schwierigkeit bzw. Minispiel skippen
            if(result.get()== buttonLeicht){
                m.setLeicht(true);
            }
            else if (result.get()== buttonSchwer) {
                m.setLeicht(false);
            }
            else{
                throw new Exception("Minispiel Skipped");
            }

            //Minispiel starten und Rückgabewert sammeln
            m.start(new Stage());
            Minispielrueckgabewert minispielrueckgabewert =  m.getMinispielrueckgabewert();


            //Ausgabe Gewinner und gewonnenen Würfel
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Minispielende");
            alert.setHeaderText(null);
            alert.setContentText(minispielrueckgabewert.toString());
            alert.showAndWait();


            //Hinzufügen gewonnener würfel
            if(!minispielrueckgabewert.getAbbruch()){
                minispielrueckgabewert.getWinner().fuegeWuerfelhinzu(minispielrueckgabewert.getWuerfel());
            }


        }catch (Exception e){
            e.printStackTrace();

        }
            //Wechsel zum nächsten Spieler
            Hauptgame.nextSpieler();
        });





    }
}
