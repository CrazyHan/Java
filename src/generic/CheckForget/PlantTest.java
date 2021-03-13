package generic.CheckForget;

import generic.AAADemo1.Apple;
import generic.AAADemo1.Banana;
import generic.AAADemo1.Fruit;

import java.util.ArrayList;
import java.util.List;

public class PlantTest {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>();

        List<Banana> bananas = new ArrayList<>();

//        fruits = bananas; 这个不行
        List<? extends Apple> apples;
        List<? extends Fruit> fruits1 = fruits;
        fruits1 = bananas;
//        fruits1 = apples;

        List<Integer> list = new ArrayList<>();

        list.add(-1);

    }

}
