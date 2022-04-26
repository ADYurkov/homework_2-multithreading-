package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LetterCountMergerImplTest {
    @Test
    void merge() {
        Map<Character, Long> f = new HashMap<>();
        f.put('q', 1l);
        f.put('w', 1l);
        f.put('e', 1l);
        f.put('r', 1l);
        f.put('t', 1l);
        f.put('y', 3l);
        Map<Character, Long> s = new HashMap<>();
        s.put('q', 1l);
        s.put('w', 1l);
        s.put('e', 1l);
        s.put('r', 1l);
        s.put('t', 1l);
        s.put('y', 3l);

        Map<Character, Long> ex = new HashMap<>();
        ex.put('q', 2l);
        ex.put('w', 2l);
        ex.put('e', 2l);
        ex.put('r', 2l);
        ex.put('t', 2l);
        ex.put('y', 6l);

        Map<Character, Long> res = new LetterCountMergerImpl().merge(f,s);
        assertEquals(res, ex);
    }
}