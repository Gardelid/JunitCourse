import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class SomeCodeTest {
    @BeforeAll
    static void beforeAll() {
        System.out.println("Start testing some code");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("End testing some code");
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Starting test " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("Starting test " + info.getDisplayName());
    }

    @Test
    void square() {
        assertEquals(625, SomeCode.square(25));
    }

    @Test
    void addition() {
        assertEquals(100, SomeCode.addition(25, 75));
    }

    @Test
    void subtraction() {
        assertEquals(25, SomeCode.subtraction(75, 50));
    }

    @Test
    void division() {
        assertEquals(2, SomeCode.division(10, 5));
    }
}