public class Main {
    public static void main(String[] args) {

        PQheap<String> queue = new PQheap<String>();
        queue.InsertElement(3, "Ala");
        queue.InsertElement(5,"kota");

        int size = queue.getSize();
        for (int i = 0; i < size; i++) {
            queue.pop();
            System.out.print(" ");
        }
        System.out.println();
    }

}