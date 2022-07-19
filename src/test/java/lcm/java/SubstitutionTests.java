package lcm.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubstitutionTests {

    @Test
    void testSubstitution() {
        S s = new S("Hello");
        s.change("world");
        assert s.equals("world");
    }
    
    @Test
    void testChange() {
    	 S s = new S("HelloabcHelloabcHello");
    	 S s2 = s.change("abc", "x");
    	 assert s.equals("HelloxHelloxHello") && s == s2;
    }
    
    @Test
    void testChangeAll() {
    	S s = new S("Hello    Hello\n");
    	S s2 = s.changeAll("\\s+", " ");
    	assert s == s2;
    	assertEquals("Hello Hello ", s.toString());
    }

    @Test
    void testLower() {
        S s = new S("Hello");
        S s2 = s.lower();
        assert s2.equals("hello") && s == s2;
    }

    @Test
    void testUpper() {
        S s = new S("Hello");
        S s2 = s.upper();
        assert s2.equals("HELLO") && s == s2;
    }

    @Test
    void testStrip() {
        S s = new S(" Hello ");
        S s2 = s.strip();
        assert s2.equals("Hello") && s == s2;
    }
    
}
