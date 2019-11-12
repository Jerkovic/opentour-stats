package models;

public class Hole {

    private int hcpIndex;
    private int number;
    private int par;

    public int getHcpIndex() {
        return hcpIndex;
    }

    public void setHcpIndex(int hcpIndex) {
        this.hcpIndex = hcpIndex;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    @Override
    public String toString() {
        return "Hole{" +
                "number=" + number +
                ", par=" + par +
                '}';
    }
}
