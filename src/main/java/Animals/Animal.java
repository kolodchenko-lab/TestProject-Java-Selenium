package Animals;


public abstract class Animal {
    String name;
    int weight;
    String type;

    public Animal(String name, int weight, String type) {
        this.name = name;
        this.weight = weight;
        this.type = type;
    }

    public abstract String makeSound();
    public abstract String eat();
    public abstract void sleep();

    public String getName() {
        return name;
    }

    public String getType(){
        return type;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", type='" + type + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setType(String type) {
        this.type = type;
    }
}
