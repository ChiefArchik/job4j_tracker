package ru.job4j.oop;

public class Computer {

    private boolean multiMonitor;

    private String cpu;

    private int ssd;

    public Computer() {
    }

    public Computer(boolean multiMonitor, String cpu, int ssd) {
        this.multiMonitor = multiMonitor;
        this.cpu = cpu;
        this.ssd = ssd;
    }

    public Computer(int ssd, String cpu) {
        this.ssd = ssd;
        this.cpu = cpu;
    }

    public Computer(boolean multiMonitor, String cpu, double ssd) {
        this.multiMonitor = multiMonitor;
        this.cpu = cpu;
        this.ssd = (int) ssd;
    }

    public void printInfo() {
        System.out.println("Много мониторов: " + multiMonitor);
        System.out.println("Модель CPU: " + cpu);
        System.out.println("SSD: " + ssd + " GB");
        System.out.println();
    }

    public static void main(String[] args) {
        Computer first = new Computer();
        first.printInfo();
        Computer second = new Computer(true, "Intel Core I7-10700K", 500);
        second.printInfo();
        Computer third = new Computer(250, "AMD Ryzen 5 3600");
        third.printInfo();
        Computer forth = new Computer(true, "AMD Ryzen 7 3700", 512.0);
        forth.printInfo();
    }
}
