package controller.treeset;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by Administrator on 2018/3/13.
 */
public class TestEmployee {
    //自然排序，Employee实现comparable 接口，并按着Name排序
    @Test
    public void test() {
        Employee e1 = new Employee("Haid",31,new MyDate(2,2,1985));
        Employee e2 = new Employee("Qiao",25,new MyDate(13,10,1991));
        Employee e3 = new Employee("Alex",20,new MyDate(2,2,1996));
        Employee e4 = new Employee("Tom",37,new MyDate(2,2,1980));
        Employee e5 = new Employee("Alex",28,new MyDate(2,2,1980));
        // 定制排序Comparator
        Comparator comparator = new Comparator() {
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    int i = e1.getBirthday().getYear() - e2.getBirthday().getYear();
                    if (i == 0) {
                        int j = e1.getBirthday().getMonth() - e2.getBirthday().getMonth();
                        if (j == 0) {
                            return e1.getBirthday().getDay() - e2.getBirthday().getDay();
                        }
                        return j;
                    }
                    return i;
                }
                return 0;
            }
        };

        TreeSet set = new TreeSet(comparator);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        for (Object object : set)
            System.out.println(object);
    }
}

