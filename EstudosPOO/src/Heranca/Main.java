package src.Heranca;

public class Main {
    public static void main(String[] args){
        Cachorro dog = new Cachorro("Farofa", 1, "Savio e Byanca");
        Gato cat = new Gato("Fumaça", 6, "Renata");

        System.out.println(dog.som());
        System.out.println(cat.som());
    }
}
