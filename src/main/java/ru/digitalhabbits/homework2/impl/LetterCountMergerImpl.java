package ru.digitalhabbits.homework2.impl;

import ru.digitalhabbits.homework2.LetterCountMerger;

import java.util.Collections;
import java.util.Map;

public class LetterCountMergerImpl implements LetterCountMerger {

    @Override
    public Map<Character, Long> merge(Map<Character, Long> first, Map<Character, Long> second) {

        if (first == null && second == null)
            return Collections.emptyMap();
        if (first == null || first.isEmpty())
            return second;
        if (second == null || second.isEmpty())
            return first;

        second.forEach((k, v) -> first.merge(k, v, Long::sum));
        return first;
    }
}
