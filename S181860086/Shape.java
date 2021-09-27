package S181860086;

public abstract class Shape {
    
    class Position {

        protected Linable linable;

        Position(Linable linable) {
            this.linable = linable;
        }

        public void setLinable(Linable linable) {
            this.linable = linable;
            linable.setPosition(this);
        }

    }

    public abstract Linable[] toArray();

}
