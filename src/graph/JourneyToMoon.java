package graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class JourneyToMoon {
    JourneyToMoon journeyToMoon;

    @BeforeEach
    public void init() {
        journeyToMoon = new JourneyToMoon();
    }

    @Test
    public void firstTest() {
        journeyToMoon.journeyToMoon(5, new int[][]{{0, 1}, {2, 3}, {0, 4}});

    }

    int journeyToMoon(int numOfAstronauts, int[][] astronaut) {
        int[] country = new int[numOfAstronauts ];
        Arrays.fill(country, 0);
        int numOfCountry = 0;

        for (int i = 0; i < astronaut.length; i++) {
            int[] pair = astronaut[i];
            int first = pair[0];
            int second = pair[1];
            if (country[first] == 0 && country[second] == 0) {
                country[first] = numOfCountry + 1;
                country[second] = numOfCountry + 1;
                numOfCountry+=1;
            } else {
                country[first] = Math.max(country[first], country[second]);
                country[second] = Math.max(country[first], country[second]);
            }
        }

        //Arrays.stream(country).forEach(value -> System.out.println(value + "->"));

        int[] sizes=new int[numOfCountry+1];

        Arrays.fill(sizes,0);

        System.out.printf("--");
        for (int i = 0; i <country.length ; i++) {
            sizes[country[i]]=sizes[country[i]]+1;
        }

        Arrays.stream(sizes).forEach(value -> System.out.println(value + "->"));

        return 0;
    }
}
