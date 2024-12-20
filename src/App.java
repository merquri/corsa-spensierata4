
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        // chiedo la dimensione del percorso e la metto in un array
        System.out.println("Quanti ostacoli vuoi nel percorso?");
        int dimensione = sc.nextInt();

        String[] percorso = new String[dimensione];
        String[] ostacoli = {"strada", "buca", "muro", "piscina"};
        String[] azioni = {"corri", "salta", "nuota", "arrampica"};
        ArrayList<String> corridore = new ArrayList<String>();
        int ostacoliSuperati = 0;
        int[] turni={0, 0, 0, 0, 0};

        System.out.print("Percorso: [");
        for (int i = 0; i < dimensione; i++) {
            percorso[i] = ostacoli[r.nextInt(ostacoli.length)];
            if (i < dimensione - 1) {
                System.out.print(percorso[i] + ", ");
            } else {
                System.out.print(percorso[i]);
            }
        }
        System.out.println("]");
        for (int i = 1; i < 6; i++) {
            System.out.println("Corridore "+ i);
            do {
                turni[i-1]++;
                corridore.add(azioni[r.nextInt(4)]);

                if (corridore.get(corridore.size() - 1).equals("corri") && percorso[ostacoliSuperati].equals("strada")) {
                    corridore.remove(corridore.size() - 1);
                    corridore.add("CORRI");
                    ostacoliSuperati++;
                }
                if (corridore.get(corridore.size() - 1).equals("nuota") && percorso[ostacoliSuperati].equals("piscina")) {
                    corridore.remove(corridore.size() - 1);
                    corridore.add("NUOTA");
                    ostacoliSuperati++;
                }
                if (corridore.get(corridore.size() - 1).equals("arrampica") && percorso[ostacoliSuperati].equals("muro")) {
                    corridore.remove(corridore.size() - 1);
                    corridore.add("ARRAMPICA");
                    ostacoliSuperati++;
                }
                if (corridore.get(corridore.size() - 1).equals("salta") && percorso[ostacoliSuperati].equals("buca")) {
                    corridore.remove(corridore.size() - 1);
                    corridore.add("SALTA");
                    ostacoliSuperati++;
                }
                System.out.println("\n\nTurno " + turni[i-1]);
                System.out.println("Corridore " + i);
                for (int j = 0; j < corridore.size(); j++) {
                    System.out.print(corridore.get(j) + " ");
                }
                System.out.println("\n----------------------------------------------------");
                
            }while (ostacoliSuperati < percorso.length);
            
            corridore.removeAll(corridore);
            
            ostacoliSuperati=0;
            
        }
        int[] minore={0, Integer.MAX_VALUE};
        for (int t = 0; t < 5; t++) {
            System.out.println("Il corridore " + (t+1)+ " ha completato la gara in "+turni[t]+" turni");
            if (minore[1]>turni[t]) {
                minore[0]=t;
                minore[1]=turni[t];
            }
        }
        System.out.println("Vince il corridore "+(minore[0]+1));
        sc.close();
    }
}