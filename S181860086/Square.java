package S181860086;

public class Square extends Shape {
    
    public Square(int length) {
        this.positions = new Position[length][length];
        this.length = length;
    }

    private Position[][] positions;
    private int length;

    public void put(Linable linable, int i, int j) {
        if (this.positions[i][j] == null) {
            this.positions[i][j] = new Position(null);
        }
        this.positions[i][j].setLinable(linable);
    }

    public Linable get(int i, int j) {
        if ((i < 0) || (i >= this.length)) {
            return null;
        } else if ((j < 0) || (j >= this.length)) {
            return null;
        } else {
            return positions[i][j].linable;
        }
    }    

    @Override
    public String toString() {
        String lineString = "";
        for (Position[] ps : positions) {
            lineString += "\t";
            for (Position p : ps) {
                lineString += p.linable.toString();
            }
            lineString += "\n";
        }
        return lineString;
    }

    @Override
    public Linable[] toArray() {
        Linable[] linables = new Linable[this.length * this.length];

        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.length; j++) {
                linables[i * this.length + j] = positions[i][j].linable;
            }            
        }

        return linables;

    }

}
