package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book coreJava = new Book("Core Java. Volume - I ", 860);
        Book lordOfTheRings = new Book("Lord of the rings ", 870);
        Book headJava = new Book("Head First Java ", 688);
        Book javaStart = new Book("Java. A beginner`s guide ", 712);
        Book[] books = new Book[4];
        books[0] = coreJava;
        books[1] = lordOfTheRings;
        books[2] = headJava;
        books[3] = javaStart;
        for (Book bk : books) {
            System.out.println(bk.getName() + bk.getCount());
        }

        System.out.println();
        Book cleanCode = new Book("Clean Code", 420);
        books[1] = cleanCode;
        for (Book bk : books) {
            System.out.println(bk.getName() + bk.getCount());
        }

        System.out.println();
        books[0] = javaStart;
        books[3] = coreJava;
        for (Book bk : books) {
            System.out.println(bk.getName() + bk.getCount());
        }
    }
}
