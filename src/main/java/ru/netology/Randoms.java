package ru.netology;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Randoms implements Iterable<Integer> {
    protected Random random = new Random();
    private int max;
    private int min;
    List<Integer> integers = new ArrayList<>();



    public Randoms(int min, int max) {
        this.min = min;
        this.max = max + 1;
    }

    public Randoms add() {
        int temp = random.nextInt(max);
        if (temp >= min) {
            integers.add(temp);
        } else {
            add();
        }
        return this;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int nextItem;

            @Override
            public boolean hasNext() {
                if (nextItem >= (integers.size()-1)) {
                    add();
                }
                return true;
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    add();
                }
                nextItem++;
                return integers.get(nextItem);
            }
        };
    }
}