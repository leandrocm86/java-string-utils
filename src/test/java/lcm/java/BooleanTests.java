package lcm.java;

import org.junit.jupiter.api.Test;

public class BooleanTests {

    @Test
    void testIn() {
        S s = new S("Hello");
        assert s.in("Hello", "World");
        assert !s.in("World", "Beyond");
    }

    @Test
    void testNone() {
        S s = new S("Hello");
        assert s.none("World", "Beyond");
        assert !s.none("World", "Hello");
    }
    
}
