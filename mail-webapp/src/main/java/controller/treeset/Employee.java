package controller.treeset;

/**
 *是否重写compareTo()和equals()方法
 * Created by Administrator on 2018/3/13.
 */
public class Employee implements Comparable{
    private String name;
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        if (age != other.age)
            return false;
        if (birthday == null) {
            if (other.birthday != null)
                return false;
        } else if (!birthday.equals(other.birthday))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    private int age;
    private MyDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public Employee() {
        super();
    }

    public Employee(String name, int age, MyDate birthday) {
        super();
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee employee=(Employee)o;
            int i=this.getName().compareTo(employee.getName());
//          if(i==0){
//              int j=this.getAge()-employee.getAge();
////                if (j==0){
////
////                }
//              return j;
//          }
            return i;
        }
        return 0;
    }
}
