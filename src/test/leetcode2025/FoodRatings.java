package test.leetcode2025;

import java.util.*;

/**
 * 设计食物评分系统
 */
public class FoodRatings {
    Map<String, TreeSet<Integer> > map;
    Map<String,Integer> map1;
    String[] food;
    String[] cuisine;

    int[] rating;


    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        map1 = new HashMap<>();
        map = new HashMap<>();
        food = foods;
        cuisine = cuisines;
        rating = ratings;
        for (int i = 0; i < foods.length; i++) {
            map1.put(foods[i],i);
        }
        for (int i = 0; i < cuisines.length; i++) {
            map.computeIfAbsent(cuisines[i],k->new TreeSet<>((o1, o2) -> {
                int compare = Long.compare(rating[o2], rating[o1]);
                if(compare==0){
                    return food[o1].compareTo(food[o2]);
                }
                return compare;
            })).add(i);

        }
    }


    public void changeRating(String food, int newRating) {
        Integer index = map1.get(food);
        TreeSet<Integer> set = map.get(cuisine[index]);
        set.remove(index);
        //最关键的一步，没有这一步重新排序不会触发
        rating[index]=newRating;
        set.add(index);

    }

    public String highestRated(String cuisine) {
        return food[map.get(cuisine).first()];
    }
}
