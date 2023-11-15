package com.example.teemaschinefx;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    private String teename;
    private int dauer;
    public SensorData sd = new SensorData(); // Es wird ein Objekt aus der Klasse der Sim. Sensordaten erzeugt.


    @FXML
    private Label tempText; //Initialisieren der Label
    @FXML
    private Label errText;
    @FXML
    private Label temp;
    @FXML
    private Label countdown;
    @FXML
    private Button button1;
    @FXML
    private Button button2;


    //Funktionen des Controllers
    @FXML
    public void starteTee1() {
        this.teename = "Schwarzen Tee";
        this.dauer = 17;
        showText(); // bei dem Start soll das Label sichtbar werden.

        //Aufruf der Seriellen Schnittstelle.
    }

    @FXML
    public void starteTee2(){
        this.teename = "Grünen Tee";
        this.dauer = 13; // Daten ueber die Dauer der Teesorte
        showText();


        //Aufruf der Seriellen Schnittstelle.
    }
    @FXML
    public void showText(){
        tempText.setText("Die Dauer für den "+ teename + " Beträgt: " + dauer + " min."); //Variable, die je nach Sorte placed wird.
        countdown.setText("Verbliebene Zeit bis der Tee fertig ist: " +this.dauer+ " min."); // Zeigt den Text ohne Delay der Animation an.
        setTemp();
    }
    @FXML
    public void setTemp(){
        String data = String.valueOf(sd.getTemperatur());
        temp.setText(data);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){ //Methode, die jede Sekunde den Wert um eins erhoeht.

        //Die erhoehung von Temperatur als Demo => Spaeter nur getter und output.
        temp.setText(String.valueOf(sd.getTemperatur()));


        Timeline timelineTemp = new Timeline(new KeyFrame(Duration.seconds(1),e ->{

            int i = sd.getTemperatur(); //Es wird eine Veraible erstellt, welche die Daten des Sensors erhält und diese erhöht.
            i++;
            sd.setTemperatur(i);

            if(sd.getTemperatur() < 40){
                button1.setDisable(true);
                button2.setDisable(true);
                errText.setText("Zu niedrige Temperatur! Tee zur zeit nicht verfügbar!");
            }else{
                button1.setDisable(false);
                button2.setDisable(false);
                errText.setText("");
            }

            temp.setText(String.valueOf(i));
        }));

        timelineTemp.setCycleCount(Animation.INDEFINITE); //Die gestartete Timeline soll unendlich lange laufen.
        timelineTemp.play();


        // Funktion fuer die Restzeit Anzeige.
        countdown.setText("Keine aktive Aufgabe, bitte Tee auswählen");// Damit es bei der initialisierung gezeigt wird.

        Timeline timelineCountdown = new Timeline(new KeyFrame(Duration.seconds(2),e ->{ // Für die Finale Version muss Duration Minutes sein.
            if(this.teename == null){
                countdown.setText("Keine aktive Aufgabe, bitte Tee auswählen");
            }else{
                countdown.setText("Verbliebene Zeit bis der Tee fertig ist: " +this.dauer+ " min.");
                if(this.dauer > 0){
                    int i = this.dauer;
                    i--;
                    this.dauer = i;
                }else{
                    countdown.setText("Tee Fertig! Neuer Tee kann ausgewählt werden");
                }
            }
        }));

        timelineCountdown.setCycleCount(Animation.INDEFINITE);
        timelineCountdown.play();
    }
}