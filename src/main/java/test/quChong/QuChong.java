package test.quChong;

import java.util.Arrays;
import java.util.List;

public class QuChong {
    public static void main(String[] args) {
        List<MyObject> list = Arrays.asList(
                MyObject.builder().age(0).isDead(false).name("w").build(),
                MyObject.builder().age(1).isDead(true).name("ww").build(),
                MyObject.builder().age(1).isDead(false).name("wee").build()
        );
      //  List<Integer> list = Arrays.asList(1,2,3,3,2);

        list.stream().distinct().forEach(System.out::println);
    }
}
