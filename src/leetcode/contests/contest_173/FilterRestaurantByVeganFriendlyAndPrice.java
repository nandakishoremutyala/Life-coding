package leetcode.contests.contest_173;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import others.MasterPrinter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterRestaurantByVeganFriendlyAndPrice {
    FilterRestaurantByVeganFriendlyAndPrice filterRestaurantByVeganFriendlyAndPrice;

    public class Restaurant {
        private int id;
        private int rating;
        private int veganFriendly;
        private int price;
        private int distance;

        public Restaurant(int id, int rating, int veganFriendly, int price, int distance) {
            this.id = id;
            this.rating = rating;
            this.veganFriendly = veganFriendly;
            this.price = price;
            this.distance = distance;
        }

        public int getRating() {
            return rating;
        }
    }

    @BeforeEach
    public void init() {
        filterRestaurantByVeganFriendlyAndPrice = new FilterRestaurantByVeganFriendlyAndPrice();
    }

    @Test
    public void firstTest() {
        int[][] input = new int[][]{{1, 4, 1, 40, 10},
                {2, 8, 0, 50, 5},
                {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        List<Integer> result= filterRestaurantByVeganFriendlyAndPrice.filterRestaurants(input, 1, 50, 10);
        MasterPrinter.printList(result);
    }

    @Test
    public void secondTest() {
        int[][] input = new int[][]{{1, 4, 1, 40, 10},
                {2, 8, 0, 50, 5},
                {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
        List<Integer> result= filterRestaurantByVeganFriendlyAndPrice.filterRestaurants(input, 0, 50, 10);
        MasterPrinter.printList(result);
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {

        List<Restaurant> restaurantList = new ArrayList<>();
        for (int[] res : restaurants) {
            restaurantList.add(new Restaurant(res[0], res[1], res[2], res[3], res[4]));
        }

        if(veganFriendly==1){
            restaurantList= restaurantList.stream()
                    .filter(restaurant -> restaurant.veganFriendly==1)
                    .collect(Collectors.toList());
        }
        List<Restaurant> res = restaurantList.stream()
                .filter(restaurant -> restaurant.price <= maxPrice)
                .filter(restaurant -> restaurant.distance <= maxDistance)
                .collect(Collectors.toList());

        res.sort(Comparator.comparingInt(Restaurant::getRating).reversed());

        List<Integer> filteredRestaurant= new ArrayList<>();
        for (Restaurant restaurant:res){
            filteredRestaurant.add(restaurant.id);
        }
        return filteredRestaurant;
    }

}
