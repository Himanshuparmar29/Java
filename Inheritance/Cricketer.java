import java.util.*;

public class Cricketer {
    public static void main(String[] args) {
        // Example usage
        player_info[] players = {
            new player_info("Player1", 25, 50, 3, 30, 2, 20, 1),
            new player_info("Player2", 27, 60, 2, 40, 1, 10, 2),
            new player_info("Player3", 22, 55, 4, 20, 3, 15, 1)
        };
        
        Cricketer cricketer = new Cricketer();
        cricketer.calRank(0, players, players.length);
        cricketer.calRank(1, players, players.length);
        cricketer.calRank(2, players, players.length);
        
        for (player_info p : players) {
            System.out.println(p.name + " - Type 0 Rank: " + p.ref1[0].rank);
            System.out.println(p.name + " - Type 1 Rank: " + p.ref1[1].rank);
            System.out.println(p.name + " - Type 2 Rank: " + p.ref1[2].rank);
        }
    }
    
    void calRank(int t, player_info[] ref, int len) {
        ArrayList<Pair<Integer, Integer>> l = new ArrayList<>();
        
        for (int i = 0; i < len; i++) {
            l.add(new Pair<>(ref[i].ref1[t].points, i));
        }
        
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (l.get(j).getKey() < l.get(j + 1).getKey()) {
                    // Swap
                    Pair<Integer, Integer> temp = l.get(j);
                    l.set(j, l.get(j + 1));
                    l.set(j + 1, temp);
                }
            }
        }
        
        for (int i = 0; i < len; i++) {
            ref[l.get(i).getValue()].ref1[t].rank = i + 1;
        }
    }
}

class player_info {
    String name;
    int age;
    stats[] ref1;

    player_info(String name, int age, int r0, int w0, int r1, int w1, int r2, int w2) {
        this.name = name;
        this.age = age;
        this.ref1 = new stats[3];
        ref1[0] = new stats(r0, w0);
        ref1[1] = new stats(r1, w1);
        ref1[2] = new stats(r2, w2);
    }
}

class stats {
    int runs;
    int wickets;
    int points;
    int rank;

    stats(int runs, int wickets) {
        this.runs = runs;
        this.wickets = wickets;
        this.points = runs + wickets * 10;
    }
}
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}