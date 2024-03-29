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
    void indexOfNth() {
    	S s = new S("acdefabcdefabcdef");
    	assertEquals(8, s.indexOfNth("def", 2));
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

    @Test
    void testFrom() {
        S s = new S("acdefabcdefabc");
        S result = s.startingAfter("abc");
        assertEquals("acdefabcdefabc", s.toString());
        assertEquals("defabc", result.toString());
    }

    @Test
    void testFromNth() {
        S s = new S("abcdefabcdefabc");
        S result = s.startingAfter("abc", 2);
        S result2 = s.startingAfter("abc", 3);
        assertEquals("abcdefabcdefabc", s.toString());
        assertEquals("defabc", result.toString());
        assertEquals("", result2.toString());
    }

    @Test
    void testFrominc() {
        S s = new S("acdefabcdefabc");
        S result = s.startingWith("abc");
        assertEquals("acdefabcdefabc", s.toString());
        assertEquals("abcdefabc", result.toString());
    }

    @Test
    void testFromincNth() {
        S s = new S("abcdefabcdefabc");
        S result = s.startingWith("abc", 2);
        S result2 = s.startingWith("abc", 3);
        assertEquals("abcdefabcdefabc", s.toString());
        assertEquals("abcdefabc", result.toString());
        assertEquals("abc", result2.toString());
    }

    @Test
    void testUntil() {
        S s = new S("abcdefabcdefabc");
        S result = s.endingBefore("abc");
        assertEquals("abcdefabcdefabc", s.toString());
        assertEquals("", result.toString());
    }

    @Test
    void testUntilNth() {
        S s = new S("abcdefabcdefabc");
        S result = s.endingBefore("abc", 2);
        S result2 = s.endingBefore("abc", 3);
        assertEquals("abcdefabcdefabc", s.toString());
        assertEquals("abcdef", result.toString());
        assertEquals("abcdefabcdef", result2.toString());
    }

    @Test
    void testUntilinc() {
        S s = new S("abcdefabcdefabc");
        S result = s.endingWith("abc");
        assertEquals("abcdefabcdefabc", s.toString());
        assertEquals("abc", result.toString());
    }

    @Test
    void testUntilincNth() {
        S s = new S("abcdefabcdefabc");
        S result = s.endingWith("abc", 2);
        S result2 = s.endingWith("abc", 3);
        assertEquals("abcdefabcdefabc", s.toString());
        assertEquals("abcdefabc", result.toString());
        assertEquals("abcdefabcdefabc", result2.toString());
    }

}
