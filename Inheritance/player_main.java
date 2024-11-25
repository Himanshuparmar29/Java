import java.util.Scanner;

public class player_main {
    public static void main(String[] args) {
        int n = 3;
        player[] p = new player[n];
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter the name of the players and played variants (T20, Test, World Cup). Enter 1 if player played the variant, otherwise 0");
        
        for (int i = 0; i < n; i++) {
            System.out.print("Name : ");
            String name = in.nextLine();
            System.out.print("Varients : ");
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            in.nextLine();  // Consume the newline character
            
            p[i] = new player(i + 1, name, a, b, c);
        }
        // Sorting based on Test matches
        System.out.println("Players and their rank (Test wise):");
        sortPlayer("Test", p, n);
    }

    public static void sortPlayer(String type, player[] p, int n) {
        int f1 = 0;  // Index to track T20, Test, or World Cup
        
        if (type.equals("WorldCup")) {
            f1 = 2;  // Index 2 for World Cup
        } else if (type.equals("Test")) {
            f1 = 1;  // Index 1 for Test matches
        } else {
            f1 = 0;  // Default to T20
        }

        // Sort players by points for the given variant
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (p[j].m_ref[f1].points < p[j + 1].m_ref[f1].points) {
                    player temp = p[j];
                    p[j] = p[j + 1];
                    p[j + 1] = temp;
                }
            }
        }

        // Assign ranks and display them
        for (int i = 0; i < n; i++) {
            p[i].m_ref[f1].rank = i + 1;
            if (p[i].a[f1] == 1) {
                System.out.println(p[i].name + " : " + p[i].m_ref[f1].rank);
            }
        }
    }
}

class varient {
    String variant_type;
    int runs;
    int wickets;
    int points;
    int rank;

    varient(String variant_type, int runs, int wickets) {
        this.variant_type = variant_type;
        this.runs = runs;
        this.wickets = wickets;
        this.points = runs + wickets * 10;
    }
}

class player {
    int id;
    String name;
    int[] a;  // Stores whether the player played T20, Test, or World Cup
    varient[] m_ref;  // Stores the varient for each match variant

    player(int id, String name, int t20, int test, int worldCup) {
        this.id = id;
        this.name = name;
        this.a = new int[]{t20, test, worldCup}; 
        this.m_ref = new varient[3]; 
        
        Scanner in = new Scanner(System.in);
        String[] variants = {"T20", "Test", "WorldCup"};
        
        for (int i = 0; i < 3; i++) {
            if (a[i] == 1) {
                System.out.println("Enter the runs and wickets for " + variants[i] + ": ");
                int runs = in.nextInt();
                int wickets = in.nextInt();
                m_ref[i] = new varient(variants[i], runs, wickets);
            } else {
                m_ref[i] = new varient(variants[i], 0, 0); 
            }
        }
    }
}
