package lcm.java;

import java.util.Collection;

public class S implements CharSequence {
    private String val;
    
    /* BEGIN OF CONSTRUCTORS */
    
    public S() {
        this.val = "";
    }
    
    public S(Object o) {
        this.val = String.valueOf(o);
    }

    public static S[] wrap(String[] strings) {
        S[] result = new S[strings.length];
        for (int i = 0; i < strings.length; i++) {
            result[i] = new S(strings[i]);
        }
        return result;
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

    @Override
    public int hashCode() {
		return val.hashCode();
	}

    @Override
    public String toString() {
        return val;
    }

    /* END OF OBJECT METHODS */
    

    /* BEGIN OF CHARSEQUENCE METHODS */
    
    /**
     * @see java.lang.CharSequence#length()
     */
    @Override
    public int length() {
        return val.length();
    }
    
    /**
     * @see java.lang.CharSequence#charAt(int)
     */
    public char charAt(int index) {
        return val.charAt(index);
    }
    
    /**
     * @see java.lang.CharSequence#subSequence(int, int)
     */
    public CharSequence subSequence(int start, int end) {
        return new S(val.subSequence(start, end));
    }
    
    /* END OF CHARSEQUENCE METHODS */

    /* BEGIN OF REGULAR STRING METHODS */

    /**
     * @see java.lang.String#replaceFirst(java.lang.String, java.lang.String)
     */
    public S replaceFirst(CharSequence oldSubstring, CharSequence newSubstring) {
        return new S(val.replaceFirst(String.valueOf(oldSubstring), String.valueOf(newSubstring)));
    }

    /**
     * @see java.lang.String#replace(java.lang.String, java.lang.String)
     */
    public S replace(CharSequence oldSubstring, CharSequence newSubstring) {
        return new S(val.replace(String.valueOf(oldSubstring), String.valueOf(newSubstring)));
    }

    /**
     * @see java.lang.String#compareTo(java.lang.String)
     */
    public int compareTo(CharSequence anotherString) {
		return val.compareTo(anotherString.toString());
	}

    /**
     * @see java.lang.String#compareToIgnoreCase(java.lang.String)
     */
	public int compareToIgnoreCase(CharSequence str) {
		return val.compareToIgnoreCase(str.toString());
	}

    /**
     * @see java.lang.String#contains(java.lang.CharSequence)
     */
	public boolean contains(CharSequence s) {
		return val.contains(s.toString());
	}

    /**
     * @see java.lang.String#endsWith(java.lang.String)
     */
	public boolean endsWith(CharSequence suffix) {
		return val.endsWith(suffix.toString());
	}

    /**
     * @see java.lang.String#equalsIgnoreCase(java.lang.String)
     */
	public boolean equalsIgnoreCase(CharSequence anotherString) {
		return val.equalsIgnoreCase(anotherString.toString());
	}

    /**
     * @see java.lang.String#indexOf(String)
     */
	public int indexOf(CharSequence str) {
		return val.indexOf(str.toString());
	}

    /**
     * @see java.lang.String#indexOf(String, int)
     */
	public int indexOf(CharSequence str, int fromIndex) {
		return val.indexOf(str.toString(), fromIndex);
	}

    /**
     * @see java.lang.String#isBlank()
     */
	public boolean isBlank() {
		return val.isBlank();
	}

    /**
     * @see java.lang.String#lastIndexOf(String)
     */
	public int lastIndexOf(CharSequence str) {
		return val.lastIndexOf(str.toString());
	}

    /**
     * @see java.lang.String#matches(java.lang.String)
     */
	public boolean matches(CharSequence regex) {
		return val.matches(regex.toString());
	}

    /**
     * @see java.lang.String#split(java.lang.String)
     */
	public S[] split(CharSequence regex) {
		return wrap(val.split(regex.toString()));
	}

    /**
     * @see java.lang.String#startsWith(java.lang.String)
     */
	public boolean startsWith(CharSequence prefix) {
		return val.startsWith(prefix.toString());
	}

    /**
     * @see java.lang.String#toLowerCase()
     */
	public S toLowerCase() {
		return new S(val.toLowerCase());
	}

    /**
     * @see java.lang.String#trim()
     */
    public S trim() {
        return new S(val.trim());
    }

    /* END OF REGULAR STRING METHODS */  

    /* BEGIN OF UTILITY METHODS */

    /**
     * Formats a text using each occurrence of "--" as a placeholder.
     * The parameters given replace each placeholder in sequence.
     * It is possible to pass a single value to replace all placeholders.
     * But if more than one value is passed, the number of values must match the number of placeholders.
     * @param text The text to format.
     * @param parameters The parameters to replace each placeholder.
     * @throws IllegalArgumentException If there is more than one parameter, but less than the number of placeholders.
     */
    public static String f(CharSequence text, Object... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("No arguments provided to format string.");
        S in = new S(text);
        if (args.length > 1 && in.count("--") != args.length) {
            String errorMsg = """
                Number of arguments does not match number of placeholders ("--").
                This is only allowed if the number of arguments is exactly one """;
            throw new IllegalArgumentException(errorMsg);
        }
        S out = new S(text);
        if (args.length == 1)
            return out.change("--", String.valueOf(args[0])).toString();
		int trocas = 0;
		while (trocas < args.length) {
            out.changeFirst("--", String.valueOf(args[trocas].toString()));
			trocas++;
		}
        return out.toString();
    }

    /**
     * Returns true if the string is empty or null.
     */
	public static boolean blank(CharSequence str) {
		return str == null || str.toString().isBlank();
	}

    /**
     * Mutable method.
     * Changes the string to lower case.
     * @return The same S object, now in lower case.
     */
    public S lower() {
        val = val.toLowerCase();
        return this;
    }

    /**
     * Mutable method.
     * Changes the string to upper case.
     * @return The same S object, now in upper case.
     */
    public S upper() {
        val = val.toUpperCase();
        return this;
    }

    /**
     * Mutable version of the trim method from the native String class.
     * @see java.lang.String#trim()
     * @return The same S object, now trimmed.
     */
    public S strip() {
        val = val.trim();
        return this;
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
     * Replaces the first occurrence of the given substring with the given replacement.
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
     * Replaces the value of all occurrences of the given substring with the given replacement.
     * @param oldSubstring The substring to be replaced.
     * @param newSubstring The substring to replace the old one.
     * @return The same S object, that now has a new value.
     * @see #replace(CharSequence, CharSequence)
     */
    public S change(CharSequence oldSubstring, CharSequence newSubstring) {
        val = val.replace(String.valueOf(oldSubstring), String.valueOf(newSubstring));
        return this;
    }

    /**
     * Mutable method.
     * Replaces the whole current string value with the given string.
     * If the given string is null, the empty string ("") is used. S is always null-safe.
     * @return The same S object, that now has a new value.
     */
    public void substitute(String s) {
        val = s != null ? s : "";
    }

    /**
     * Mutable version of the concat method from native String.
     * Concatenates the given string to the end of the current one.
     * An optional separator can be passed to be appended between the two strings.
     * @param separator Optional separator to be appended between the strings.
     * @param string The string to be concatenated.
     * @param suffix Optional suffix to be appended after the resulting string.
     * @return The same S object, that now has a new value.
    */
    public S add(CharSequence seperator, Object string, CharSequence suffix) {
        if (seperator != null)
            val += seperator;
        val += string;
        if (suffix != null)
            val += suffix;
        return this;
    }

    /**
     * Overload of the add method without a separator or suffix.
     * @see #add(CharSequence, Object, CharSequence)
     */
    public S add(Object string) {
        return this.add(null, string, null);
    }

    /**
     * Overload of the add method with space as suffix.
     * @see #add(CharSequence, Object, CharSequence)
     */
    public S adds(Object string) {
        return this.add(null, string, " ");
    }

    /**
     * Overload of the add method with space as separator.
     * @see #add(CharSequence, Object, CharSequence)
     */
    public S sadd(Object string) {
        return this.add(" ", string, null);
    }

    /**
     * Overload of the add method with a new line as suffix.
     * @see #add(CharSequence, Object, CharSequence)
     */
    public S addln(Object string) {
        return this.add(null, string, "\n");
    }

    /**
     * Overload of the add method with a new line as separator.
     * @see #add(CharSequence, Object, CharSequence)
     */
    public S lnadd(Object string) {
        return this.add("\n", string, null);
    }

    /**
     * Returns a string starting after the given substring until the end.
     * If the optional ocurrence is given, it returns the string starting from the Nth occurrence of the substring.
     * @param substring The starting substring from which the return is extracted.
     * @param occurrence The Nth occurrence of the substring from which the return is extracted.
     */
    public S from(CharSequence start, Integer occurrence) {
        int index = val.indexOf(start.toString(), 0);
        if (index == -1)
            throw new IllegalArgumentException(S.f("The substring '--' was not found in the string '--'", start, val));
        if (occurrence == null)
            return new S(val.substring(index + start.length()));
        else {
            if (occurrence < 1)
                throw new IllegalArgumentException("Ocurrence must be greater than 0.");
            int count = 1;
            while (count < occurrence) {
                index = val.indexOf(start.toString(), index + 1);
                if (index == -1)
                    throw new IllegalArgumentException(S.f("Not found -- occurrences of substring '--' in the string '--'", occurrence, start, val));
                count++;
            }
            return new S(val.substring(index + start.length()));
        }
    }

    /**
     * Returns a string starting after the given substring until the end.
     * @param substring The starting substring from which the return is extracted.
     */
    public S from(CharSequence start) {
        return this.from(start, null);
    }

    /**
     * Returns a string starting from the beginning and ending on the given substring.
     * If the optional ocurrence is given, it returns the string ending on the Nth occurrence of the substring.
     * @param substring The ending substring up to which the return is extracted.
     * @param occurrence The Nth occurrence of the substring up to which the return is extracted.
     */
    public S until(CharSequence end, Integer occurrence) {
        int index = val.indexOf(end.toString(), 0);
        if (index == -1)
            throw new IllegalArgumentException(S.f("The substring '--' was not found in the string '--'", end, val));
        if (occurrence == null)
            return new S(val.substring(0, index));
        else {
            if (occurrence < 1)
                throw new IllegalArgumentException("Ocurrence must be greater than 0.");
            int count = 1;
            while (count < occurrence) {
                index = val.indexOf(end.toString(), index + 1);
                if (index == -1)
                    throw new IllegalArgumentException(S.f("Not found -- occurrences of substring '--' in the string '--'", occurrence, end, val));
                count++;
            }
            return new S(val.substring(0, index));
        }
    }

    /**
     * Returns a string starting from the begining and ending in the given substring.
     * @param substring The ending substring up to which the return is extracted.
     */
    public S until(CharSequence end) {
        return this.until(end, null);
    }

    /**
     * Returns a string starting from the given substring (inclusive) until the end.
     * If the optional ocurrence is given, it returns the string starting from the Nth occurrence of the substring.
     * @param substring The starting substring from which the return is extracted (including this start).
     * @param occurrence The Nth occurrence of the substring from which the return is extracted.
     */
    public S frominc(CharSequence start, Integer occurrence) {
        int index = val.indexOf(start.toString(), 0);
        if (index == -1)
            throw new IllegalArgumentException(S.f("The substring '--' was not found in the string '--'", start, val));
        if (occurrence == null)
            return new S(val.substring(index));
        else {
            if (occurrence < 1)
                throw new IllegalArgumentException("Ocurrence must be greater than 0.");
            int count = 1;
            while (count < occurrence) {
                index = val.indexOf(start.toString(), index + 1);
                if (index == -1)
                    throw new IllegalArgumentException(S.f("Not found -- occurrences of substring '--' in the string '--'", occurrence, start, val));
                count++;
            }
            return new S(val.substring(index));
        }
    }

    /**
     * Returns a string starting from the given substring (inclusive) until the end.
     * @param substring The starting substring from which the return is extracted (including this start).
     */
    public S frominc(CharSequence start) {
        return this.frominc(start, null);
    }

    /**
     * Returns a string starting from 0 and ending after the given substring.
     * If the optional ocurrence is given, it returns the string ending on the Nth occurrence of the substring.
     * @param substring The ending substring up to which the return is extracted (including this end).
     * @param occurrence The Nth occurrence of the substring up to which the return is extracted.
     */
    public S untilinc(CharSequence end, Integer occurrence) {
        int index = val.indexOf(end.toString(), 0);
        if (index == -1)
            throw new IllegalArgumentException(S.f("The substring '--' was not found in the string '--'", end, val));
        if (occurrence == null)
            return new S(val.substring(0, index + end.length()));
        else {
            if (occurrence < 1)
                throw new IllegalArgumentException("Ocurrence must be greater than 0.");
            int count = 1;
            while (count < occurrence) {
                index = val.indexOf(end.toString(), index + 1);
                if (index == -1)
                    throw new IllegalArgumentException(S.f("Not found -- occurrences of substring '--' in the string '--'", occurrence, end, val));
                count++;
            }
            return new S(val.substring(0, index + end.length()));
        }
    }

    /**
     * Returns a string starting from 0 and ending after the given substring.
     * @param substring The ending substring up to which the return is extracted, including this end.
     */
    public S untilinc(CharSequence end) {
        return this.untilinc(end, null);
    }

    /**
     * Returns wether the string is equal to any of the given values.
     */
    public boolean in(CharSequence... strings) {
        for (CharSequence string : strings) {
            if (this.equals(string))
                return true;
        }
        return false;
    }

    /**
     * Returns wether the string is equal to any of the values in a given collection.
     */
    public boolean in(Collection<CharSequence> strings) {
        for (CharSequence string : strings) {
            if (this.equals(string))
                return true;
        }
        return false;
    }

    /**
     * Returns wether the string is different than all the given values.
     */
    public boolean none(CharSequence... strings) {
        for (CharSequence string : strings) {
            if (this.equals(string))
                return false;
        }
        return true;
    }

    /**
     * Returns wether the string is different than all the values in a given collection.
     */
    public boolean none(Collection<CharSequence> strings) {
        for (CharSequence string : strings) {
            if (this.equals(string))
                return false;
        }
        return true;
    }


    /* END OF UTILITY METHODS */
}
