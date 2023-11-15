# TeeMaschineFX
Um die GUI für die Teemaschine zu Starten gilt es, 

!! Wichtig, diese GUI wurde mit JDK 17 und höher getestet. Es handelt sich hierbei um eine alpha und es können unerwartete fehler auftreten. !!

1. diese Respository zu Clonen.
2. Die in der Respository vorhandene lib der Jar Datei, der JavaFX bei InteliJ bei den Modulen hinzuzufügen.
   
Normalerweise sollte ab diesem Punkt Intelij in der Lage sein, die JavaFX Main auszuführen. Sollte dies nicht der Fall sein, so muss man unter umständen die Umgebungsvariablen der IDE umändern.
=> Diese findet man Unter Settings -> Build, Execution, Deployment -> Compiler -> Java Compiler. 

Dort muss das Modul mindestens eine Byteversion von 9 oder höher besitzen.
Als nächstes geht man auf Run -> Run/Debug Configurations um die VM Argumente zu sezten, falls dies nicht automatisch passiert ist. 
Unter den VM Options wird dieses Befehl reinkopiert: 

--module-path "\path\to\javafx-sdk-21.0.1\lib" --add-modules javafx.controls,javafx.fxml

Allgemein gilt es bei neu auftretenden Fehlern, die in der ReadME nicht beschrieben wurden, die Docs zu JavaFX zu lesen.
=> https://docs.gluonhq.com/
=> https://openjfx.io/openjfx-docs/
