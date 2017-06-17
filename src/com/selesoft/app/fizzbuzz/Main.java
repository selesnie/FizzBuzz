package com.selesoft.app.fizzbuzz;

/**
 * Created by Jukka Selesniemi on 17.6.2017.
 */
public class Main {

    public static void main(String[] args) {

        int maxNumber = 50;

        Thread threads[] = {
                new FizzBuzzThread(param -> param % 3 == 0 && param % 5 == 0,
                        param -> "FizzBuzz", maxNumber),

                new FizzBuzzThread(param -> param % 3 == 0 && param % 5 != 0,
                        param -> "Fizz", maxNumber),

                new FizzBuzzThread(param -> param % 3 != 0 && param % 5 == 0,
                        param -> "Buzz", maxNumber),

                new FizzBuzzThread(param -> param % 3 != 0 && param % 5 != 0,
                        param -> Integer.toString(param), maxNumber)
        };

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
