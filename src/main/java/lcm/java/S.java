package lcm.java;

public class S implements CharSequence {
    private String val;
    
    public S() {
        this.val = "";
    }

    public S(Object o) {
        this.val = String.valueOf(o);
    }
    
    public int length() {
        return val.length();
    }
    
    public char charAt(int index) {
        return val.charAt(index);
    }
    
    public CharSequence subSequence(int start, int end) {
        return val.subSequence(start, end);
    }
    
    public String toString() {
        return val;
    }
}
