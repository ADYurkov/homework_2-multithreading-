package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.FileLetterCounter;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

//todo Make your impl
public class AsyncFileLetterCounter implements FileLetterCounter {

    public static void main(String[] args) {
        File file = new File("./src/test/resources/test.txt");
        AsyncFileLetterCounter asyncFileLetterCounter = new AsyncFileLetterCounter();
        System.out.println(asyncFileLetterCounter.count(file));
    }

    @Override
    public Map<Character, Long> count(File input) {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        List<String> list = new FileReaderImpl().readLines(input).collect(Collectors.toList());
        return pool.invoke(new ResultTask(0, list.size(), list));
    }
}
