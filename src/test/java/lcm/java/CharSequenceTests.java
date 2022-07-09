package lcm.java;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CharSequenceTests {

    @Test
    void testCharSequenceCharAtValid() {
        CharSequence s = new S("Hello");
        assertEquals('H', s.charAt(0));
        assertEquals('e', s.charAt(1));
        assertEquals('l', s.charAt(2));
        assertEquals('l', s.charAt(3));
        assertEquals('o', s.charAt(4));
    }

    @Test
    void testCharSequenceCharAtInvalid() {
        CharSequence s = new S("Hello");
        assertThrows(IndexOutOfBoundsException.class, () -> s.charAt(5));
    }

    @Test
    void testLength() {
        CharSequence s = new S("Hello");
        assertEquals(5, s.length());
    }

    @Test
    void testSubSequenceValid() {
        CharSequence s = new S("Hello");
        assertEquals("ell", s.subSequence(1, 4).toString());
        assertEquals("", s.subSequence(0, 0).toString());
    }

    @Test
    void testSubSequenceInvalid() {
        CharSequence s = new S("Hello");
        assertThrows(IndexOutOfBoundsException.class, () -> s.subSequence(1, 6));
    }
}
