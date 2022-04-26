package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LetterCounterImplTest {
    String s = "qwertyyy";

    @Test
    void count() {
        Map<Character, Long> ex = new HashMap<>();
        ex.put('q', 1l);
        ex.put('w', 1l);
        ex.put('e', 1l);
        ex.put('r', 1l);
        ex.put('t', 1l);
        ex.put('y', 3l);

        Map<Character, Long> res = new LetterCounterImpl().count(s);
        assertEquals(res, ex);
    }
}