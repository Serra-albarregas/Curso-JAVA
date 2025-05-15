package UT6.ExamenA;

public class DragonOro extends Dragon implements Comparable<DragonOro>{
    private int oro;

    public DragonOro(String nombre, String castillo){
        super(nombre, castillo);
        this.oro=0;
    }

    public int getOro() {
        return this.oro;
    }

    public void setOro(int oro) {
        if (oro < 0) this.oro=0;
        else this.oro = oro;
    }

    @Override
    public String toString() {
        return super.toString() +
        " oro='" + getOro() + "'";
    }
    
    @Override
    public void usarAliento() throws Exception {
        super.usarAliento();
        oro+=100;
    }

    @Override
    public int compareTo(DragonOro o) {
        return Integer.compare(this.oro, o.getOro());
    }
}
