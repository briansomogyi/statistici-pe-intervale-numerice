import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class IntervaleClient {
    public static void main(String[] args) {
        try {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("intervale.dat"))) {
                try (BufferedReader reader = new BufferedReader(new FileReader("numere.dat"))) {
                    String numereString = reader.readLine();
                    String[] listaNumere = numereString.split(" ");
                    try (FileWriter writer = new FileWriter("statistica.dat")) {
                        String linie = bufferedReader.readLine();
                        while (linie != null) {
                            String[] leftAndRight = linie.split(",");
                            String leftString = leftAndRight[0];
                            String rightString = leftAndRight[1];
                            leftString = leftString.substring(1, leftString.length());
                            rightString = rightString.substring(0, rightString.length()-1);
                            Double leftDouble = Double.parseDouble(leftString);
                            Double rightDouble = Double.parseDouble(rightString);
                            Intervale intervale = new Intervale(leftDouble, rightDouble);
                            for (String string : listaNumere) {
                                Double double1 = Double.parseDouble(string);
                                intervale.test(double1);
                            }
                            intervale.printResults();
                            writer.write(intervale.getProcent());
                            linie = bufferedReader.readLine();
                        }
                    }
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
