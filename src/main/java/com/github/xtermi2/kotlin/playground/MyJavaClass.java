package com.github.xtermi2.kotlin.playground;

import java.util.Arrays;

/**
 * @author Andreas Keefer
 */
public class MyJavaClass {
    public void printInJava(String s) {
        System.out.println(s);
    }

    public void printInJava(boolean b) {
        System.out.println(b);
    }

    public void printInJava(int[] ints) {
        System.out.println(Arrays.toString(ints));
    }
}
