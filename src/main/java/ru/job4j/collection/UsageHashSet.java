package ru.job4j.collection;

import java.util.HashSet;

public class UsageHashSet {
    public static void main(String[] args) {
        HashSet<String> autos = new HashSet<String>();
        autos.add("LADA");
        autos.add("Volvo");
        autos.add("Toyota");
        autos.add("BMW");
        autos.add("LADA");
        autos.add("Toyota");
        autos.add("Volvo");
        autos.add("LADA");
        autos.add("Toyota");
        autos.add("Toyota");
        autos.add("Volvo");
        for (String auto : autos) {
            System.out.println(auto);
        }
    }
}
