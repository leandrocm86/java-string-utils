package lcm.java;

public class S implements CharSequence {
    private String val;
    
    /* BEGIN OF CONSTRUCTORS */
    
    public S() {
        this.val = "";
    }
    
    public S(Object o) {
        this.val = String.valueOf(o);
    }
    
    /* END OF CONSTRUCTORS */

    /* BEGIN OBJECT METHODS */

    @Override
    public boolean equals(Object o) {
        return val.equals(o);
    }

    public boolean equals(String s) {
        return val.equals(s);
    }

    /* END OF OBJECT METHODS */
    

    /* BEGIN OF CHARSEQUENCE METHODS */
    
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

    /* END OF CHARSEQUENCE METHODS */

    /* BEGIN OF REGULAR STRING METHODS */

    /**
     * Implementation of the original replaceFirst method from native String.
     * Wraps the return in a S object.
     * @see java.lang.String#replaceFirst(java.lang.String, java.lang.String)
     */
    public S replaceFirst(CharSequence oldSubstring, CharSequence newSubstring) {
        return new S(val.replaceFirst(String.valueOf(oldSubstring), String.valueOf(newSubstring)));
    }

    /**
     * Implementation of the original replace method from native String.
     * Wraps the return in a S object.
     * @see java.lang.String#replace(java.lang.String, java.lang.String)
     */
    public S replace(CharSequence oldSubstring, CharSequence newSubstring) {
        return new S(val.replace(String.valueOf(oldSubstring), String.valueOf(newSubstring)));
    }

    /* END OF REGULAR STRING METHODS */  

    /* BEGIN OF UTILITY METHODS */

    /**
     * Formats a text using each ocurrence of "--" as a placeholder.
     * The parameters given replace each placeholder in sequence.
     * It is possible to pass a single value to replace all placeholders.
     * But if more than one value is passed, the number of values must match the number of placeholders.
     * @param text The text to format.
     * @param parameters The parameters to replace each placeholder.
     * @throws IllegalArgumentException If there is more than one parameter, but less than the number of placeholders.
     * @see java.lang.String#changeFirst(java.lang.String, java.lang.String)
     */
    public static S f(CharSequence text, Object... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("No arguments provided to format string.");
        }
        S in = new S(text);
        if (args.length > 1 && in.count("--") != args.length) {
            String errorMsg = """
                Number of arguments does not match number of placeholders ("--").
                This is only allowed if the number of arguments is exactly one """;
            throw new IllegalArgumentException(errorMsg);
        }
        S out = new S(text);
        if (args.length == 1) {
            return out.change("--", String.valueOf(args[0]));
        }
		int trocas = 0;
		while (trocas < args.length) {
            out.changeFirst("--", String.valueOf(args[trocas].toString()));
			trocas++;
		}
        return out;
    }

    /**
     * Counts the number of occurrences of a substring in a string.
     * @param s The substring to be counted.
     * @return The number of occurrences of the substring in the string.
     */
    public int count(CharSequence s) {
        return val.split(String.valueOf(s), -1).length - 1;
    }

    /**
     * Mutable version of the replaceFirst method.
     * Replaces the first ocurrence of the given substring with the given replacement.
     * @param oldSubstring The substring to be replaced.
     * @param newSubstring The substring to replace the old one.
     * @return The same S object, that now has a new value.
     * @see #replaceFirst(CharSequence, CharSequence)
     */
    public S changeFirst(CharSequence oldSubstring, CharSequence newSubstring) {
        val = val.replaceFirst(String.valueOf(oldSubstring), String.valueOf(newSubstring));
        return this;
    }

    /**
     * Mutable version of the replace method.
     * Replaces the value of all ocurrences of the given substring with the given replacement.
     * @param oldSubstring The substring to be replaced.
     * @param newSubstring The substring to replace the old one.
     * @return The same S object, that now has a new value.
     * @see #replace(CharSequence, CharSequence)
     */
    public S change(CharSequence oldSubstring, CharSequence newSubstring) {
        val = val.replace(String.valueOf(oldSubstring), String.valueOf(newSubstring));
        return this;
    }

    /* END OF UTILITY METHODS */
}
