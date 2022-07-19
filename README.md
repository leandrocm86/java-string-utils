# JAVA-STRING-UTILS
### Utility methods for string parsing and manipulation


This project provides the <i>S</i> class, a wrapper for native String.
It adds many utility methods to make parsing and manipulation easier.

#### Examples of use:
- Getting substrings by strings (not indexes!):

```
new S("apple banana pineapple grape orange").from("banana").until("orange") // "pineapple grape"
new S("apple banana pineapple grape orange").frominc("banana").until("orange") // "banana pineapple grape"
new S("apple banana pineapple grape orange").frominc("banana").untilinc("orange") // "banana pineapple grape orange"
```

- Counting ocurrences of substring and getting substrings from/until specific ocurrences:

```
new S("banana apple banana grape banana").count("banana") // gives 3
new S("banana apple banana grape banana").frominc("banana", 2) // "banana grape banana"
new S("banana apple banana grape banana").untilinc("banana", 2) // "banana apple banana"
new S("banana apple banana grape banana").from("banana", 1).until("banana", 3) // "apple banana grape"
```

- Easy comparison with multiple elements inline or in a Collection:

```
new S("banana").in("apple", "banana", "grape") // gives <i>true</i>
```

- Easy concatanation with spaces or new line:

```
new S("I bought ").adds("apples").adds("and").addln("bananas") // "I bought apples and bananas\n"
```

- Easy text formatting with the <i>f</i> method:

```
S.f("Hello, --! There are -- planets nearby...", "world", 9) // "Hello, world! There are 9 planets nearby..."
```

