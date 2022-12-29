# JAVA-STRING-UTILS
### Utility methods for string parsing and manipulation


This project provides the <i>S</i> class, a wrapper for native String.
It adds many utility methods to make parsing and manipulation easier.

#### Examples of use:
- Getting substrings by strings (not indexes!):

```
new S("apple banana pineapple grape orange").startingAfter("banana").endingBefore("orange") // "pineapple grape"
new S("apple banana pineapple grape orange").startingWith("banana").endingBefore("orange") // "banana pineapple grape"
new S("apple banana pineapple grape orange").startingWith("banana").endingWith("orange") // "banana pineapple grape orange"
```

- Counting occurrences of substring and getting substrings of specific occurrences:

```
new S("banana apple banana grape banana").count("banana") // gives 3
new S("banana apple banana grape banana").startingWith("banana", 2) // "banana grape banana"
new S("banana apple banana grape banana").endingWith("banana", 2) // "banana apple banana"
new S("banana apple banana grape banana").startingAfter("banana", 1).endingBefore("banana", 3) // "apple banana grape"
```

- Easy comparison with multiple elements inline or in a Collection:

```
new S("banana").in("apple", "banana", "grape") // gives true
```

- Easy concatanation with spaces or new line:

```
new S("I bought ").adds("apples").adds("and").addln("bananas") // "I bought apples and bananas\n"
```

- Easy text formatting with the <i>f</i> method (similar to <i>String.format</i>, but simpler):

```
S.f("Hello, --! There are -- planets nearby...", "world", 9) // "Hello, world! There are 9 planets nearby..."
```

