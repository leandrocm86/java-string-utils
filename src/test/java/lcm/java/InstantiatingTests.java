package lcm.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class InstantiatingTests {
    
    @Test
    void testNullInstantiating() {
        S s = new S(null);
        assert s.equals("null");
    }

    @Test
    void testEmptyInstantiating() {
        S s = new S();
        assertEquals("", s.toString());
    }

    @Test 
    void testFInvalid() {
        assertThrows(IllegalArgumentException.class, () -> S.f("Test --"));
        assertThrows(IllegalArgumentException.class, () -> S.f("Test ------", 1, 2));
        assertThrows(IllegalArgumentException.class, () -> S.f("Test --", 1, 2));
    }

    @Test
    void testF() {
        String s = S.f("Hello --! Hello --! These are -- hellos!", "World", "Galaxy", 2);
        assertEquals("Hello World! Hello Galaxy! These are 2 hellos!", s);
        s = S.f("Hello --! I love this --!", "World");
        assertEquals("Hello World! I love this World!", s);
    }
}
