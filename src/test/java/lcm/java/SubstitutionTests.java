package lcm.java;

import org.junit.jupiter.api.Test;

public class SubstitutionTests {

    @Test
    void testSubstitute() {
        S s = new S("Hello");
        s.substitute("world");
        assert s.equals("world");
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
