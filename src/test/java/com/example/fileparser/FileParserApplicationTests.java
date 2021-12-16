package com.example.fileparser;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(args = {"src/test/resources/test.csv", "src/test/resources/test.csv"})
class FileParserApplicationTests {

    @Test
    void contextLoads() {
    }

}
