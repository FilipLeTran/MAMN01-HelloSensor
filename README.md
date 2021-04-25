# MAMN01-HelloSensor
Denna appen har två features: en kompass och en accelerometer. När användaren öppnar appen har de möjligheten att välja mellan vilken av de två funktionerna de vill använda sig av genom att trycka på knapparna där det står vilken funktion de kommer föra vidare senare till. Appen har alltså tre vyer: hemskärm, kompass och accelerometer. 

## Kompassen
I kompassen använde jag mig av guide för att skapa funktionerna för en kompass. Kompassen har också en till funktion som gör att kompassen startar en vibrationssignal när den är mellan 345-15 grader.

Dessa länkar använde jag för att skapa kompassen och dess funktioner:
- Kompass : https://www.codespeedy.com/simple-compass-code-with-android-studio/
- Vibrationssignal: https://stackoverflow.com/questions/13950338/how-to-make-an-android-device-vibrate-with-different-frequency/13950364#13950364

## Accelerometer
Accelerometern skapades genom att ta inspiration från kompassen samt av länkarna för att få fram värderna för x, y och z axeln:
- https://developer.android.com/reference/android/hardware/SensorManager.html
- https://developer.android.com/reference/android/hardware/SensorEvent

Accelerometerna har också två extra funktioner: förändring av backgrundsfärgen när mobilen är på en platt yta och utskrivning av lutning av mobilen.
- Backgrundsfärg: https://stackoverflow.com/questions/4486034/get-root-view-from-current-activity
- Utskrivning: Jag skrev egen kod genom att använda mig av if-satser.

