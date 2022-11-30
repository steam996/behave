package ru.netology;

import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    private Random random = new Random();
    private int max;
    private int min;

    public Randoms(int min, int max) {
        this.min = min;
        this.max = max + 1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return random.nextInt(max - min) + min;
            }
        };
    }
}