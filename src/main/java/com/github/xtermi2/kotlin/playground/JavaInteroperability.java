package com.github.xtermi2.kotlin.playground;

import java.io.IOException;

/**
 * @author Andreas Keefer
 */
public class JavaInteroperability {
    public static void main(String[] args) {
        HouseKt.topLevel();

        // renamed static class
        Functions.custom(1, 2);

        // call extension functions
        System.out.println(ExtensionFunctions.myUpper("make it upper"));

        Car car = new Car("VW", 123);
        System.out.println(car.getModel());

        MyHouse house = new MyHouse("mountain");

        // you can annotate properties in kotlin with @JvmField when you want to access them directly
        System.out.println(house.location);

        // access companion object
        MyHouse.Companion.build();
        // with @JvmStatic we can use it like expected
        MyHouse.build();
        Logger.INSTANCE.log("from java");

        try {
            house.print(null);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            // we need to annotate a method which can throw a checked exception in kotlin for java
            house.throwCheckedException();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // default values/parameters
        house.defaultParams("with default");
        house.defaultParams("override default", false);
    }
}
