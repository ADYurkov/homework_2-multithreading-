package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCountMerger;
import ru.digitalhabbits.homework2.LetterCounter;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.RecursiveTask;

public class ResultTask extends RecursiveTask<Map<Character, Long>> {
    private List<String> list;
    private final int start;
    private final int end;
    private LetterCountMerger m = new LetterCountMergerImpl();
    private LetterCounter c = new LetterCounterImpl();

    public ResultTask(int start, int end, List<String> list) {
        this.start = start;
        this.end = end;
        this.list = list;
    }

    @Override
    protected Map<Character, Long> compute() {
        Map<Character, Long> map = null;

        if (list == null || end > list.size() || start < 0)
            return Collections.emptyMap();

        if (end - start <= list.size() / Runtime.getRuntime().availableProcessors()) {
            for (String s : list.subList(start,end)) {
                map = m.merge(map, c.count(s));
                System.out.println(Thread.currentThread().getName());
            }
            return map;
        } else
           map = computeRecursively();

        return map;
    }

    private Map<Character, Long> computeRecursively() {
        System.out.println("computeRecursively(): " + Thread.currentThread().getName());
        int middle = (end + start) / 2;
        ResultTask firstPart = new ResultTask(start, middle, list);
        firstPart.fork();
        ResultTask secondPart = new ResultTask(middle, end, list);
        secondPart.fork();

        return m.merge(firstPart.join(), secondPart.join());

    }
}