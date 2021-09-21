package com.imdroid;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TripleSum {

    public static void main(String[] args) {

        int[]a={1,4,5};
        int[]b={2,3,3};
        int[]c={1,2,3};


        System.out.println(tripletsOptimized(a,b,c));

    }

    static long tripletsOptimized(int[] a, int[] b, int[] c) {

        long distinctTripletCount = 0;

        int[] distinctA = removeDuplicates(a);
        int[] distinctB = removeDuplicates(b);
        int[] distinctC = removeDuplicates(c);

        Arrays.sort(distinctA);
        Arrays.sort(distinctB);
        Arrays.sort(distinctC);

        for (int q : distinctB) {
            long c1 = getValidIndex(distinctA, q)+1 ;
            long c3 = getValidIndex(distinctC, q)+1;
            distinctTripletCount += c1 * c3;
        }

        return distinctTripletCount;

    }

    static int getValidIndex(int[] distinctA, int key) {
        int low = 0;
        int high = distinctA.length - 1;
        int count = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (distinctA[mid] <= key) {
                count = mid;
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return count;

    }

    private static int[] removeDuplicates(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int item : a) {
            set.add(item);
        }
        int len = set.size();

        int result[] = new int[len];
        int i = 0;
        for (int item : set) {
            result[i++] = item;
        }
        return result;
    }


    static long triplets(int[] a, int[] b, int[] c) {

        int count=0;
        Supplier<IntStream> aS = () -> Arrays.stream(a).distinct().sorted();
        Supplier<IntStream> cS = () -> Arrays.stream(c).distinct().sorted();
        PrimitiveIterator.OfInt h= Arrays.stream(b).distinct().sorted().iterator();
        while(h.hasNext()){
            int bValue= h.next();
            long i= aS.get().filter(iV->bValue>=iV).count();
            long j= cS.get().filter(iV->bValue>=iV).count();
            count+=i*j;
        }
        return count;
    }
}
