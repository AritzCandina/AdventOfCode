
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Aufgabe2 {


    public static Map<String, String> byBufferedReader(String filePath) {
        HashMap<String, String> map = new HashMap<>();
        String line;
        String value = "";
        String value2 ="";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null) {
                String[] keyValuePair = line.split(":", 2);
                if (keyValuePair.length > 1) {
                        value += keyValuePair[1];
                        value += ";\n";


                    System.out.println(value);
                    while ((value = reader.readLine()) != null) {
                        String[] keyValuePair2 = value.split(";", 2);
                        if (keyValuePair2.length > 1) {
                            //System.out.println(keyValuePair2[0]);
                            value2 += keyValuePair2[1];
                            value2 += ";\n";
                        }
                    }



                        System.out.println(value2);

                } else {
                    System.out.println("No Key:Value found in line, ignoring: " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(value);
        return map;
    }

    public static String countColors(String input) {
        Map<String, Integer> colorCount = new HashMap<>();

        // Aufteilen des Eingabestrings anhand von ';'
        String[] groups = input.split(";");

        // Durchlaufen der Gruppen
        for (String group : groups) {
            // Aufteilen der Gruppe anhand von ',' und entfernen von Leerzeichen
            String[] colors = group.split(",\\s*");

            // Durchlaufen der Farben in der Gruppe
            for (String color : colors) {
                // Extrahieren der Farbe und der Anzahl
                String[] parts = color.split("\\s+");
                String colorName = parts[1].toLowerCase(); // Farbname in Kleinbuchstaben konvertieren
                int count = Integer.parseInt(parts[0]);

                // Aktualisieren des Zählers in der Map
                colorCount.put(colorName, colorCount.getOrDefault(colorName, 0) + count);
            }
        }

        // Erstellen des Ergebnisstrings
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
            result.append(entry.getValue()).append(" ").append(entry.getKey()).append(", ");
        }

        // Entfernen des letzten ", "
        result.setLength(result.length() - 2);
        System.out.println(result);
        return result.toString();
    }


    public static void main(String[] args) {
        System.out.println(byBufferedReader("C:\\Users\\Lukas\\IdeaProjects\\AdventOfCode_aritz\\inputTextAufgabe2.txt"));

    }

}
