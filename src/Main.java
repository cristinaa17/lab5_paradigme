import java.io.*;

public class Main {
    public static void main(String[] args) {
        String text = """
Lorem ipsum dolor sit amet, vim ne eripuit vulputate. Vide tantas dicunt ne ius, mel pertinacia intellegebat
""" +
                "ei. Sea vidisse aperiam et, eu altera audiam percipitur vis, decore verterem ea nec. Veri quando ad est. Ex\n" +
                "quidam blandit nec, eos et percipit indoctum.\n" +
                "Summo putant consetetur cu vel. Id eum adipisci philosophia, eos commodo principes an. Duis eripuit\n" +
                "laoreet qui ne, pri maiorum detracto definitiones et. Sea quis laudem dolorem eu.";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("in.txt"));
            writer.write(text);
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("in.txt"));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();

            String originalText = content.toString();

            String resultA = originalText.replaceAll("(?m)$", "\n");
            System.out.println(" a)\n" + resultA);

            String resultB = originalText.replace(".", ".\n");
            System.out.println(" b)\n" + resultB);

            BufferedWriter outWriter = new BufferedWriter(new FileWriter("out.txt"));
            outWriter.write(" a):\n" + resultA + "\n");
            outWriter.write(" b):\n" + resultB);
            outWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}