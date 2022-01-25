package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Hare hare = new Hare();
        BigWolf wolf = new BigWolf();
        Fox fox = new Fox();
        Ball ball = new Ball();

        hare.tryEat(ball);
        wolf.tryEat(ball);
        fox.tryEat(ball);
    }
}
