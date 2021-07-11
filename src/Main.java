
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        long startTime = System.nanoTime();
        System.out.println("Start Time: " + ((System.nanoTime() - startTime) / 1000000) + " milliseconds");


        //Retrieve from this API hosted by me
        URL url = new URL("https://my-json-server.typicode.com/sashitharan/dictionaryattack-api-server/db");

        System.out.println("GET: "+ url +"\n");

        try (InputStream in = url.openStream()) {
            if (!Files.exists(Paths.get( "RetrievedShadowFile.json")))
                Files.copy(in, Paths.get( "RetrievedShadowFile.json"));
        }


        JSONFormat fromAPI = new GsonBuilder().create().fromJson(new JsonReader(new FileReader("RetrievedShadowFile.json")), JSONFormat.class);
        JSONFormat presentation = crackPasswords(fromAPI);

        timer(startTime);

        //Presentation
        String filename = String.format("CrackedPasswords.json");

        try (FileWriter writer = new FileWriter(filename)) {
            new GsonBuilder().setPrettyPrinting().create().toJson(presentation, writer);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("File saved as : %s%n%n", filename);

    }




    private static JSONFormat crackPasswords(JSONFormat givenContent) throws FileNotFoundException {

        JSONFormat toSubmit = new JSONFormat();
        toSubmit.passwords = givenContent.passwords;
        Solutions solutions = new Solutions();

        String[] unParsedPasswords = givenContent.passwords;
        for (int i = 0; i < unParsedPasswords.length; i++) {


            Scanner s = new Scanner(new File("English.txt"));
            String[] passwordsBroken = unParsedPasswords[i].split("\\$");
            String personNameSemicolon = passwordsBroken[0];
            String personName = personNameSemicolon.substring(0, personNameSemicolon.length() - 1);
            String salt = passwordsBroken[2];
            String hash = passwordsBroken[3];

            long crackTimeStart = System.nanoTime();
            long restartTimer = ((System.nanoTime() - crackTimeStart) / 1000000);
            System.out.println("\nTimer reset: " + restartTimer+ " milliseconds");

            while (s.hasNextLine()) {
                String dictionaryWord = s.nextLine();
                String saltedDictionaryWord = salt + dictionaryWord;
                String hashValueOfSaltedDictionaryWord = HashUtils.sha256Hash(saltedDictionaryWord);

                if (hash.equals(hashValueOfSaltedDictionaryWord)) {

                    long timeToCrackOneWord =  ((System.nanoTime() - crackTimeStart) / 1000000);

                    System.out.printf("%7s: %s%n", personName, dictionaryWord);
                    System.out.println("Time taken to crack password of "+ personName +" : " + timeToCrackOneWord + " milliseconds");


                    if (personName.equals("alice")) {
                        solutions.alice.password = dictionaryWord;
                        solutions.alice.salt = salt;
                    } else if (personName.equals("bob")) {
                        solutions.bob.password = dictionaryWord;
                        solutions.bob.salt = salt;
                    } else if (personName.equals("charlie")) {
                        solutions.charlie.password = dictionaryWord;
                        solutions.charlie.salt = salt;
                    } else if (personName.equals("david")) {
                        solutions.david.password = dictionaryWord;
                        solutions.david.salt = salt;
                    } else if (personName.equals("eve")) {
                        solutions.eve.password = dictionaryWord;
                        solutions.eve.salt = salt;
                    } else if (personName.equals("fiona")) {
                        solutions.fiona.password = dictionaryWord;
                        solutions.fiona.salt = salt;
                    } else if (personName.equals("george")) {
                        solutions.george.password = dictionaryWord;
                        solutions.george.salt = salt;
                    } else if (personName.equals("hannah")) {
                        solutions.hannah.password = dictionaryWord;
                        solutions.hannah.salt = salt;
                    } else if (personName.equals("iris")) {
                        solutions.iris.password = dictionaryWord;
                        solutions.iris.salt = salt;
                    } else if (personName.equals("jon")) {
                        solutions.jon.password = dictionaryWord;
                        solutions.jon.salt = salt;
                    } else if (personName.equals("kelvin")) {
                        solutions.kelvin.password = dictionaryWord;
                        solutions.kelvin.salt = salt;
                    } else if (personName.equals("leila")) {
                        solutions.leila.password = dictionaryWord;
                        solutions.leila.salt = salt;
                    } else if (personName.equals("mo")) {
                        solutions.mo.password = dictionaryWord;
                        solutions.mo.salt = salt;
                    } else if (personName.equals("nadine")) {
                        solutions.nadine.password = dictionaryWord;
                        solutions.nadine.salt = salt;
                    } else if (personName.equals("olga")) {
                        solutions.olga.password = dictionaryWord;
                        solutions.olga.salt = salt;
                    } else if (personName.equals("paul")) {
                        solutions.paul.password = dictionaryWord;
                        solutions.paul.salt = salt;
                    } else if (personName.equals("quinn")) {
                        solutions.quinn.password = dictionaryWord;
                        solutions.quinn.salt = salt;
                    } else if (personName.equals("rose")) {
                        solutions.rose.password = dictionaryWord;
                        solutions.rose.salt = salt;
                    } else if (personName.equals("sophie")) {
                        solutions.sophie.password = dictionaryWord;
                        solutions.sophie.salt = salt;
                    } else if (personName.equals("tom")) {
                        solutions.tom.password = dictionaryWord;
                        solutions.tom.salt = salt;
                    } else if (personName.equals("ursula")) {
                        solutions.ursula.password = dictionaryWord;
                        solutions.ursula.salt = salt;
                    } else if (personName.equals("viola")) {
                        solutions.viola.password = dictionaryWord;
                        solutions.viola.salt = salt;
                    } else if (personName.equals("wade")) {
                        solutions.wade.password = dictionaryWord;
                        solutions.wade.salt = salt;
                    } else if (personName.equals("xavier")) {
                        solutions.xavier.password = dictionaryWord;
                        solutions.xavier.salt = salt;
                    } else if (personName.equals("yasmin")) {
                        solutions.yasmin.password = dictionaryWord;
                        solutions.yasmin.salt = salt;
                    } else if (personName.equals("zac")) {
                        solutions.zac.password = dictionaryWord;
                        solutions.zac.salt = salt;
                    }
                }
            }
        }

        toSubmit.solutions = solutions;
        return toSubmit;
    }

    static void timer(long runtimeClock) {
        System.out.println("Total Program Execution Time: " +
                ((System.nanoTime() - runtimeClock) / 1000000) + " milliseconds");
    }

}


