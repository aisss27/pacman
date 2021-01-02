public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public boolean equals(Position o) {
        if(this.getX()==o.getX() && this.getY()==o.getY()){
            return true;
        }
    else
        return false;
    }


}
