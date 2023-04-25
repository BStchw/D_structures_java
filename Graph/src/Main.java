import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Graph graph = new Graph<>();

        File file = new File("src/5.csv");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] fields = line.split(",");
            graph.addNode(fields[0]);
            graph.addNode(fields[1]);
            graph.addEdge(fields[0], fields[1], Integer.parseInt(fields[2]));
        }
        scanner.close();
        graph.printAdjList();
    }


}