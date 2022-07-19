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
    void testEquals() {
    	S s1 = new S("Hello");
    	S s2 = new S("Hello");
    	assert s1.equals(s2);
    	assert s1.equals("Hello");
    }
    
}
