package S181860086;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;

public class Scene {

    private static ArrayList<Integer> createOrder() {
        ArrayList<Integer> li = new ArrayList<Integer>();
        for (int i = 0; i < 256; i++) {
            li.add(i);
        }
        Collections.shuffle(li);
        return li;
    }

    public static void main(String[] args) throws IOException {

        boolean isLine = true;
        Line line = new Line(256);
        Square square = new Square(16);

        Snake theSnake = Snake.getTheSnake();

        ArrayList<Integer> order = createOrder();
        for (int i = 0; i < 256; i++) {
            if (isLine) {
                line.put(theSnake.getMonster(i), order.get(i));
            }
            else {
                square.put(theSnake.getMonster(i),
                           order.get(i) / 16, order.get(i) % 16);
            }            
        }

        Sorter sorter = new HeapSorter();

        theSnake.setSorter(sorter);

        String log = new String();
        if (isLine) {
            log = theSnake.lineUp(line);
        }
        else {
            log = theSnake.lineUp(square);
        }

        BufferedWriter writer;
        writer = new BufferedWriter(new FileWriter("result.txt"));
        writer.write(log);
        writer.flush();
        writer.close();

    }

}
