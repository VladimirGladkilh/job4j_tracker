package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball ball = new Ball();
        Hare hare = new Hare();
        Wolf wolf = new Wolf();
        Fox fox = new Fox();

        ball.goOn();
        hare.tryEat(ball);
        ball.goOn();
        wolf.tryEat(ball);
        ball.goOn();
        fox.tryEat(ball);
        ball.dead();
    }
}
