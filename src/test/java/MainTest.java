import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Initialize connection to database");
    }
    @AfterAll
    static void afterAll() {
        System.out.println("Close connection to database");
    }

    @BeforeEach
    void beforeEach(TestInfo info) {
        System.out.println("Initialize Test Data for " + info.getDisplayName());
    }

    @AfterEach
    void afterEach(TestInfo info) {
        System.out.println("Clean up Test Data for " + info.getDisplayName());
    }
    @Test
    @Disabled
    void lengthBasic() {
        int actualLength = "ABCD".length();
        int expectedLength = 4;
        assertEquals(expectedLength, actualLength);
    }

    @Test
    void performanceTest() {
        assertTimeout(Duration.ofSeconds(5), () -> {
                    for (int i = 0; i <= 3000000; i++) {
                        int j = i;
                        System.out.println(j);
                    }
        });
    }

    @Test
    void lengthGreaterThanZero() {
        assertTrue("ABCD".length() > 0);
        assertTrue("ABC".length() > 0);
        assertTrue("A".length() > 0);
        assertTrue("DEF".length() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"ABCD", "ABC", "A", "DEF", ""})
    void lengthGreaterThanZeroUsingParameterizedTest(String str) {
        assertTrue(str.length() > 0);
    }

    @ParameterizedTest
    @CsvSource(value = {"abcd, ABCD", "abc, ABC", ",", "ABCDEFG, abcdefg"})
    void upperCase(String word, String capitalizedWord) {
        assertEquals(capitalizedWord,word.toUpperCase());
    }

    @Test
    @DisplayName("When length is null, throw an exception")
    void lengthExeption() {
        String str = "ABCD";
        assertThrows(NullPointerException.class,
                () -> {
            str.length();
        });
    }

     @Test
     void toUpperCaseBasic() {
        String str = "abcd";
        String result = str.toUpperCase();
        assertNotNull(result);
        assertEquals("ABCD", result);
     }

     @Test
     void containsBasic() {
        String str = "abcdefgh";
        boolean result = str.contains("i jk");
        //assertEquals(false, result);
        assertFalse(result);
     }

    @Test
    void splitBasic() {
        String str = "abc def ghi";
        String actualResult [] = str.split(" ");
        String [] expectedResult = new String [] {"abc", "def", "ghi"};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Nested
    class EmptyStringClass {

        String str;

        @BeforeEach
        void setToEmpty() {
            str = "";
        }

        @Test
        @DisplayName("Length should be zero")
        void lengthIsZero() {
            assertEquals(0, str.length());
        }

        @Test
        void upperCaseIsEmpty() {
            assertEquals("", str.toUpperCase());
        }
    }

}