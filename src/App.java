import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        // chiedo la dimensione del percorso e la metto in un array
        System.out.println("Quanti ostacoli vuoi nel percorso?");
        int dimensione = sc.nextInt();

        String[] percorso= new String[dimensione];
        String[] ostacoli= {"strada", "buca", "muro", "piscina"};
        
        for (int i = 0; i < dimensione; i++) {
            percorso[i] = ostacoli[r.nextInt(ostacoli.length)];
            System.out.println(percorso[i]);
        }

        
    }
}
