package lcm.java.benchmarks;

import java.util.Collection;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

class Benchmark {

    static Long[] generateNanos(int size) {
        Long[] arr = new Long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = System.nanoTime() / 100;
        }
        return arr;
    }
    
    static Long[] generateSequence(int size) {
        Long[] arr = new Long[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Long.valueOf(i);
        }
        return arr;
    }

    static Long[] generateRandoms(int size) {
        return generateRandoms(size, 0);
    }

    static Long[] generateRandoms(int size, int minValue) {
        Long[] arr = new Long[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextLong(minValue, Long.MAX_VALUE);
        }
        return arr;
    }
    
    static String generateRandomString() {
    	 return UUID.randomUUID().toString(); // Strings of size 32
    }

    static boolean equalObjects(Object o1, Object o2) {
        if (!o1.equals(o2)) {
            if (o1.getClass().isArray() && o2.getClass().isArray()) {
                var arr1 = (Object[]) o1;
                var arr2 = (Object[]) o2;
                for (int i = 0; i < arr1.length; i++)
                    if (!arr1[i].equals(arr2[i]))
                        return false;
            }
            else return false;
        }
        return true;
    }

    static String printObject(Object o) {
        if (o instanceof Collection) {
            return printFirstElements((Collection<?>) o);
        } else {
            return String.valueOf(o);
        }
    }

    static String printFirstElements(Collection<?> c) {
        return "[" + c.stream().limit(5).map(e -> String.valueOf(e)).collect(Collectors.joining(", ")) + "]";
    }

    static void printSeparator() {
        System.out.println("-----------------------------------------------------");
    }
    
}
