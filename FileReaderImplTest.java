package ru.digitalhabbits.homework2.impl;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileReaderImplTest {
    File file = new File("./src/test/resources/test1.txt");

    @Test
    void readLines() {
        Stream<String> stringStream = new FileReaderImpl().readLines(file);
        assertEquals(stringStream.count(), 10);
    }
}