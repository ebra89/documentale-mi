package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest
public class MainApplicationTest {

    @Test
    void mainTest() {
        assertDoesNotThrow(() -> DocApiApplication.main(new String[] {}));
    }

}
