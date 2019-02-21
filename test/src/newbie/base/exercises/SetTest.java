package newbie.base.exercises;

import java.util.HashSet;
import java.util.Set;

public class SetTest {

    /**
     * 使用HashSet求交集 并集 差集
     * @param args
     */
    public static void main(String[] args) {

        Set<String> temp1 = new HashSet<String>(){
                {
                add("1");
                add("2");
                add("3");
                add("4");
                add("5");
                add("6");
            }
        };

        Set<String> temp2 = new HashSet<String>(){
            {
                add("5");
                add("6");
                add("7");
                add("8");
                add("9");
                add("0");
            }
        };

        Set<String> result = new HashSet<>();

        System.out.println("temp1:" + temp1);
        System.out.println("temp2:" + temp2);

        // 交集
        result.clear();
        result.addAll(temp1);
        result.retainAll(temp2);
        System.out.println("交集:"+result);

        // 并集
        result.clear();
        result.addAll(temp1);
        result.addAll(temp2);
        System.out.println("并集:"+result);

        // 差集
        result.clear();
        result.addAll(temp1);
        result.removeAll(temp2);
        System.out.println("差集:"+result);

    }

}
