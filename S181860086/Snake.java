package S181860086;

import java.util.Random;
import java.util.HashSet;

public class Snake {
    
    private static Snake theSnake;
    private static Monster[] monsters;

    public static Snake getTheSnake() {
        if (theSnake == null) {
            theSnake = new Snake();
        }
        return theSnake;
    }

    private Snake() {
        this.createMonsters();
    }

    private Sorter sorter;

    public void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    public String lineUp(Shape shape) {

        String log = new String();

        if (sorter == null) {
            return null;
        }

        Linable[] linables = shape.toArray();
        int[] ranks = new int[linables.length];

        for (int i = 0; i < linables.length; i++) {
            ranks[i] = linables[i].getValue();
        }

        sorter.load(ranks);
        sorter.sort();

        String[] sortSteps = this.parsePlan(sorter.getPlan());

        for (String step : sortSteps) {
            this.execute(step);
            log += shape.toString();
            log += "\n[frame]\n";
        }

        return log;

    }

    private int[] createRandom() {
        int[] res = new int[256];
        int cnt = 0;
        HashSet<Integer> s = new HashSet<>();
        Random r = new Random();
        while (cnt < 256) {
            int t = r.nextInt(1 << 24);
            if (s.contains(t)) {
                continue;
            }
            s.add(t);
            res[cnt] = t;
            cnt++;
        }
        return res;
    }

    private void createMonsters() {
        int[] colors = createRandom();
        monsters = new Monster[256];
        for (int i = 0; i < 256; i++) {
            int r = colors[i] & 0xFF;
            int g = (colors[i] & 0xFF00) >> 8;
            int b = (colors[i] & 0xFF0000) >> 16;
            Monster m = new Monster(r, g, b, i + 1);
            monsters[i] = m;
        }
    }

    public Monster getMonster(int i) {
        return monsters[i];
    }

    private String[] parsePlan(String plan) {
        return plan.split("\n");
    }

    private void execute(String step) {
        String[] couple = step.split("<->");
        monsters[Integer.parseInt(couple[0]) - 1]
                .swapPosition(monsters[Integer.parseInt(couple[1]) - 1]);
    }
}
