package service.stats.models;

import models.Course;

import java.util.List;

public class CourseStats {

    public List<HoleStats> getHoleStats() {
        return holeStats;
    }

    public void setHoleStats(List<HoleStats> holeStats) {
        this.holeStats = holeStats;
    }

    private List<HoleStats> holeStats;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    private Course course;



}
