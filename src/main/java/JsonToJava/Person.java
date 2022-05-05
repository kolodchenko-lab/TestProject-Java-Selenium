package JsonToJava;

import java.util.List;

public class Person {
   private String name;
   private String LOCATION;
   private  int age;
   private List<String> direction;

    public Person(String name, String LOCATION) {
        this.name = name;
        this.LOCATION = LOCATION;
    }

    public Person(String name, String LOCATION, int age, List<String> direction) {
        this.name = name;
        this.LOCATION = LOCATION;
        this.age = age;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", LOCATION='" + LOCATION + '\'' +
                ", age=" + age +
                ", direction=" + direction +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<String> getDirection() {
        return direction;
    }

    public void setDirection(List<String> direction) {
        this.direction = direction;
    }
}


