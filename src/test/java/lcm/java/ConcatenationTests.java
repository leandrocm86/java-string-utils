package lcm.java;

import org.junit.jupiter.api.Test;

public class ConcatenationTests {
    
    @Test
    void testAddDefault() {
        S s = new S("Hello");
        S s2 = new S("World");
        S s3 = s.add(s2);
        assert s3.equals("HelloWorld") && s3 == s;
    }

    @Test
    void testAddCustomSeparatorAndSuffix() {
        S s = new S("Hello");
        S s3 = s.add(", ", 1, "!");
        assert s3.equals("Hello, 1!") && s3 == s;
    }

    @Test
    void testAdds() {
        S s = new S("Hello");
        S s3 = s.adds("World");
        assert s3.equals("HelloWorld ") && s3 == s;
    }

    @Test
    void testSadd() {
        S s = new S("Hello");
        S s3 = s.sadd("World");
        assert s3.equals("Hello World") && s3 == s;
    }

    @Test
    void testAddln() {
        S s = new S("Hello");
        S s2 = new S("World");
        S s3 = s.addln(s2);
        assert s3.equals("HelloWorld\n") && s3 == s;
    }

    @Test
    void testLnadd() {
        S s = new S("Hello");
        S s2 = new S("World");
        S s3 = s.lnadd(s2);
        assert s3.equals("Hello\nWorld") && s3 == s;
    }

}
