package com.graph.stuff;

public class EmployeeGraphDriver {
    public static void main(String[] args) {
        Employee e1 = new Employee("1", "raj", "-1");
        Employee e2 = new Employee("2", "jit", "1");
        Employee e3 = new Employee("3", "yog", "1");
        Employee e4 = new Employee("4", "yal", "3");
        Employee e5 = new Employee("5", "ish", "2");

        EmployeeGraph eg = new EmployeeGraph();
        eg.add("1", "raj", "-1");
        eg.add("2", "jit", "1");
        eg.add("3", "yog", "1");
        eg.add("4", "yal", "3");
        eg.add("5", "ish", "2");
        eg.add("6", "amt", "1");
        
        System.out.println(eg.toString());
        eg.print();

        System.out.println("------ordered-----------");
        eg.printInOrder();
        System.out.println("-----------------");

        eg.remove("2");
        System.out.println(eg.toString());
        eg.print();
    }
}
