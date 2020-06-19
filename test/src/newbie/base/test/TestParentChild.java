package newbie.base.test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestParentChild {

    public static void main(String[] args) {
        ChildClazz child = new ChildClazz();
        child.setPid("1");
        child.setPname("aaa");
        child.setCid("2");
        child.setCname("bbb");
        ParentClazz parent = new ParentClazz();
        parent.setPid("3");
        parent.setPname("ccc");
        List<Field> fields =new  ArrayList<>();
        Class classzz = child.getClass();
        while(classzz != null){
            fields.addAll(Arrays.asList(classzz.getDeclaredFields()));
            classzz = classzz.getSuperclass();
        }
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                System.out.println("name:"+field.getName()+"----->"+"value:"+field.get(parent));
            } catch (Exception e){
                System.out.println(e);
                continue;
            }

        }
    }

}
