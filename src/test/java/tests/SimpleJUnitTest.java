package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class SimpleJUnitTest {

    int result;

    @BeforeAll
    static void beforeALll() {
        System.out.println("\n### beforeAll()\n");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("###    beforeEach()");
        result = getResult();
    }

    @AfterEach
    void afterEach() {
        System.out.println("###    afterEach()\n");
        result = 0;
    }

    @AfterAll
    static void afterALll() {
        System.out.println("\n### afterAll()\n");
    }

    @Test
    void firstTest() {
        System.out.println("###    firstTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void secondTest() {
        System.out.println("###    secondTest()");
        Assertions.assertTrue(result > 2);
    }

    @Test
    void thirdTest() {
        System.out.println("###    thirdTest()");
        Assertions.assertTrue(result > 2);
    }

    private int getResult() {
        return 3;
    }
}
