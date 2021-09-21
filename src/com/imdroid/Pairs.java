package com.imdroid;

import java.util.*;

public class Pairs {
    public static void main(String[] args) {

        List<Integer> elems = new ArrayList<>(Arrays.asList(1, 5, 3, 4, 2));
        int k = 2;


        System.out.println(  pairs(k,elems));

    }

    public static int pairs(int k, List<Integer> arr) {

        int count=0;
        int n = arr.size();

        Collections.sort(arr);
        int l=0,r=0;
        while(r<n){
            int rV = arr.get(r);
            int lV = arr.get(l);

            if(rV-lV == k){
                count++; l++;r++;
            }else if(rV - lV >k){
                l++;
            }else r++;

        }




//            if(arr.contains(a+k))
//                count++;


        return count;

    }
}
