package newbie.base.exercises;

import java.lang.reflect.Field;

public class IntegerTest {

    /**
     * 两个Integer的值  传入swap方法后 什么情况下会被调换
     *
     * @param args
     */
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer i1=1, i2=2;
        System.out.println("before: i1=" + i1 + " i2=" + i2);
        swap2(i1, i2);
        System.out.println("after: i1=" + i1 + " i2=" + i2);
    }

    /**
     * Integer里面的value成员变量是 private final的  需要反射来修改
     * 并且 -128 -> 127 之间 有缓存 所以如果使用temp来交换 需要重新给temp设定地址值(new 对象)
     * 否则操作的是同一块地址值 temp并不会给i2复制
     * 还需要注意 自动拆装箱会导致结果发生错误
     * @param i1
     * @param i2
     */
    private static void swap2(Integer i1, Integer i2) throws NoSuchFieldException, IllegalAccessException {

        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer temp = new Integer(i1.intValue());
        field.set(i1, i2.intValue());
        field.set(i2, temp);

    }


    /**
     * 方法不可用
     * @param i1
     * @param i2
     */
    private static void swap1(Integer i1, Integer i2) {
        int temp = i1;
        i2 = i1;
        i1 = temp;
    }
}
