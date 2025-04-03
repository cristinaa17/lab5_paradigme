package ex2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Numele fișierului de ieșire
        String fileName = "outrand.txt";

        // Crearea unui obiect FileWriter pentru a scrie în fișier
        try (FileWriter writer = new FileWriter(fileName)) {

            // Crearea unui obiect Random pentru generarea de caractere aleatorii
            Random rand = new Random();

            // Generarea a 5 linii, fiecare cu 10 cuvinte
            for (int i = 0; i < 5; i++) {
                String[] words = new String[10];

                // Generarea a 10 cuvinte de câte 4 caractere
                for (int j = 0; j < 10; j++) {
                    words[j] = generateRandomWord(rand);
                }

                // Sortarea cuvintelor în ordine crescătoare
                Arrays.sort(words);

                // Scrierea cuvintelor într-o linie a fișierului
                for (int j = 0; j < 10; j++) {
                    writer.write(words[j]);
                    if (j < 9) {
                        writer.write(" "); // Adăugăm spațiu între cuvinte
                    }
                }
                writer.write("\n"); // Nouă linie după fiecare set de cuvinte
            }

            System.out.println("Fișierul a fost generat cu succes!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metoda care generează un cuvânt aleatoriu de 4 caractere
    private static String generateRandomWord(Random rand) {
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char letter = (char) ('a' + rand.nextInt(26)); // Caractere între 'a' și 'z'
            word.append(letter);
        }
        return word.toString();
    }
}
