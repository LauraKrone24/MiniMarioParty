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
            Minispiel m = Hauptgame.minispielListe.remove(getMinispielnummer());
            Alert schwierigkeitsauswahl = new Alert(Alert.AlertType.CONFIRMATION);
            schwierigkeitsauswahl.setTitle("Minispiel Schwierigkeit");
            schwierigkeitsauswahl.setHeaderText("Du bist auf einem Minispielfeld gelandet ("+m.getClass().getSimpleName()+")");
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
                throw new Exception("Minispiel Skipped");
            }

            m.start(new Stage());
            Minispielrueckgabewert minispielrueckgabewert =  m.getMinispielrueckgabewert();


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

        }
            Hauptgame.nextSpieler();
        });





    }
}
