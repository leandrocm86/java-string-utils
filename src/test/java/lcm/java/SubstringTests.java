package lcm.java;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class SubstringTests {
    
    @Test
    void testCount() {
        S s = new S("abcdefabcdefabc");
        assertEquals(3, s.count("abc"));
        s = new S("aaaaa");
        assertEquals(2, s.count("aa"));
    }

    @Test
    void testReplaceFirst() {
        S s = new S("acdefabcdefabc");
        S result = s.replaceFirst("abc", "xxx");
        assertEquals("acdefabcdefabc", s.toString());
        assertEquals("acdefxxxdefabc", result.toString());
    }

    @Test
    void testChangeFirst() {
        S s = new S("acdefabcdefabc");
        S result = s.changeFirst("abc", "xxx");
        assertEquals("acdefxxxdefabc", s.toString());
        assertEquals("acdefxxxdefabc", result.toString());
    }

    @Test
    void testReplace() {
        S s = new S("acdefabcdefabc");
        S result = s.replace("abc", "xxx");
        assertEquals("acdefabcdefabc", s.toString());
        assertEquals("acdefxxxdefxxx", result.toString());
    }

    @Test
    void testChange() {
        S s = new S("acdefabcdefabc");
        S result = s.change("abc", "xxx");
        assertEquals("acdefxxxdefxxx", s.toString());
        assertEquals("acdefxxxdefxxx", result.toString());
    }

}
