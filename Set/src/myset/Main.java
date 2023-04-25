package myset;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        MySet<Integer> set1 = new MySet<Integer>();
        MySet<Integer> set2 = new MySet<Integer>();
        MySet<Integer> set3 = new MySet<Integer>();
        MySet<Integer> set4 = new MySet<Integer>();
        MySet<Integer> set5 = new MySet<Integer>();


        set1.insertToSet(7);
        set1.insertToSet(2);
        set1.insertToSet(5);
        set1.displaySet();
        System.out.println("    ");
        set2.insertToSet(7);
        set2.insertToSet(9);
        set3 = set1.union(set2);
        System.out.println("    ");
        set3.displaySet();
        System.out.println("    ");
        set4 = set1.difference(set2);
        System.out.println("    ");
        set4.displaySet();
        set5 = set1.intersection(set2);
        System.out.println("    ");
        set5.displaySet();
        set1.popAll(set2);
        System.out.println("    ");
        set1.displaySet();
    }
}