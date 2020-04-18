package models;

import java.util.List;

public class Course {

    private String id;
    private String name;
    private int numHoles;
    private List<Hole> holes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumHoles() {
        return numHoles;
    }

    public void setNumHoles(int numHoles) {
        this.numHoles = numHoles;
    }

    public List<Hole> getHoles() {
        return holes;
    }

    public int getTotalPar() {
        return getHoles().stream().mapToInt(Hole::getPar).sum();
    }

    public Hole getHole(int nr) {
        return holes.get(nr - 1);
    }

    public void setHoles(List<Hole> holes) {
        this.holes = holes;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", numHoles=" + numHoles +
                '}';
    }
}
