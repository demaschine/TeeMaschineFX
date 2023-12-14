#include <NewPing.h> //Bibliothek fuer den Sensor (in IDE einbinden)

//Ground = Schwarz Schwarz; 5V = Grau Weiß; 

#define TRIG_PIN 2  //Pin eins fuer den Trigger;  Braun Gruen;
#define ECHO_PIN 3 //Pin zwei fuer das Echo      Schwarz Gelb; 
#define MAX_DIST 400

NewPing sonar(TRIG_PIN, ECHO_PIN, MAX_DIST);

void setup() {
  Serial.begin(9600);
}
void loop() {
  delay(200); //Messungshaufigkeit in ms 
  unsigned int distanceCM = sonar.ping_cm();
  int umrechnung = (10 - distanceCM) * 75; // Umrechung der Werte, damit der ml Wasserstand zurueckgegeben wird.
  
  Serial.print(umrechnung); //Ausgabe der Fuellmenge nach Multiplikation mit dem Faktor des Anstiegs vom Wasserstand 
    
  Serial.println(" ml");
  //INFO bei einem Messfehler kann der Wert negativ sein, daher Ausgabe an die SST / GUI beachten!
}