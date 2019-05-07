package com.github.xtermi2.kotlin.playground;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

/**
 * @author Andreas Keefer
 */
public class MyJavaClass {

    public static int x = 5;

    private String name = "myName";
    private String lastName = "LastName";
    private Boolean admin = false;

    public void printInJava(String s) {
        System.out.println(s);
    }

    public void printInJava(boolean b) {
        System.out.println(b);
    }

    public void printInJava(int[] ints) {
        System.out.println(Arrays.toString(ints));
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nullable String lastName) {
        this.lastName = lastName;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public void printVarargs(String... strings) {
        System.out.println(Arrays.toString(strings));
    }

    public void run(Runnable r) {
        new Thread(r).start();
    }

    public static void printX() {
        System.out.println("X=" + x);
    }

    @Override
    public String toString() {
        return "MyJavaClass{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", admin=" + admin +
                '}';
    }
}
