package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCounter;

import java.util.Collections;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

public class LetterCounterImpl implements LetterCounter {

    @Override
    public Map<Character, Long> count(String input) {

        if (input == null || input.length() == 0)
            return Collections.emptyMap();

        Map<Character, Long> counter = input.chars()
                .boxed()
                .collect(toMap(
                        k -> (char) k.intValue(),
                        v -> 1l,
                        Long::sum));
        return counter;
    }
}
