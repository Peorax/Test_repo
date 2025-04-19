package org.example;


public class Main {
    public static void main(String[] args) {
        System.out.println("Second commit!");

        Cat firstCat = new Cat("Boris","Bezhe",2);
        Cat secondCat = new Cat("Myrzik","Gray",3);

        System.out.println("Данные первого кота : " + firstCat.getName() + " , "
                + firstCat.getColor() + " , " + firstCat.getAge());

        System.out.println("Данные второго кота : " + secondCat.getName() + " , "
                + secondCat.getColor() + " , " + secondCat.getAge());
    }
}