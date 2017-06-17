package com.selesoft.app.fizzbuzz;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Jukka Selesniemi on 17.6.2017.
 */
public class FizzBuzzThread extends Thread {
    private static Object m_lock = new Object();
    private static int m_value = 1;
    private int m_maxValue = 0;
    private Predicate<Integer> m_validator;
    private Function<Integer, String> m_function;


    public FizzBuzzThread(Predicate<Integer> validate, Function<Integer, String> function, int max) {
        m_validator = validate;
        m_function = function;
        m_maxValue = max;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (m_lock) {
                if (m_value > m_maxValue) {
                    return;
                }
                if (m_validator.test(m_value)) {
                    System.out.println(m_function.apply(m_value));
                    ++m_value;
                }
            }
        }
    }
}
