package advance_algos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class StableMarriage {
    public static void main(String[] args) {
        int men[][] = {
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3}
        };

        // Preference order for 3 women
        int women[][] = {
                {1, 0, 2, 3},
                {1, 2, 3, 0},
                {0, 1, 3, 2},
                {0, 1, 3, 2}
        };
        StableMarriage sm = new StableMarriage();
        sm.matchMaking(men, women);
    }

    private void matchMaking(int[][] men, int[][] women) {
        HashMap<Integer, Integer> couples = findCouples(men, women);

    }

    private HashMap<Integer, Integer> findCouples(int[][] men, int[][] women) {
        HashMap<Integer, Integer> couples = new HashMap<>();
        for (int i = 0; i < women.length; i++) {
            couples.put(i, null);
        }

        Set<Integer> bachelors = new HashSet<>();
        for (int i = 0; i < men.length; i++) {
            bachelors.add(i);
        }
        int bachelorCount = bachelors.size();
        while (bachelorCount > 0) {
            int currentBachelor = bachelors.iterator().next();
            System.out.println("\nMan " + currentBachelor + " is looking for a woman now-");

            for (int wmen = 0; wmen < men[currentBachelor].length; wmen++) {
                if (couples.get(wmen) == null) {
                    couples.put(wmen, currentBachelor);
                    System.out.println("Women " + wmen + " has ACCEPTED the man: " + currentBachelor);
                    bachelors.remove(currentBachelor);
                    break;
                } else {
                    int alreadyAcceptedMan = couples.get(wmen);
                    if (willChangePartner(currentBachelor, alreadyAcceptedMan, wmen, women)) {
                        bachelors.add(alreadyAcceptedMan);
                        couples.put(wmen, currentBachelor);
                        bachelors.remove(currentBachelor);
                        System.out.println("Women " + wmen + " has DUMPED the man: " + alreadyAcceptedMan);
                        System.out.println("Women " + wmen + " has ACCEPTED the man: " + currentBachelor);
                        break; //
                    }
                }

            }
            bachelorCount = bachelors.size();
        }
        return couples;
    }

    private boolean willChangePartner(int currentBachelor, int alreadyAcceptedMan, int currentWomen, int[][] women) {
        int pref_currentBachelor = -1;
        int pref_alreadyAcceptedMan = -1;

        for (int i = 0; i < women[currentWomen].length; i++) {
            if (women[currentWomen][i] == currentBachelor)
                pref_currentBachelor = i;

            if (women[currentWomen][i] == alreadyAcceptedMan)
                pref_alreadyAcceptedMan = i;
        }

        if (pref_currentBachelor < pref_alreadyAcceptedMan)
            return true;
        return false;
    }
}
