package StudentManagement.model;

public class Report {

    private int id;
    private String courseName;
    private int totalCourse;

    public Report() {
    }

    public Report(int id, String courseName, int totalCourse) {
        this.id = id;
        this.courseName = courseName;
        this.totalCourse = totalCourse;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the totalCourse
     */
    public int getTotalCourse() {
        return totalCourse;
    }

    /**
     * @param totalCourse the totalCourse to set
     */
    public void setTotalCourse(int totalCourse) {
        this.totalCourse = totalCourse;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}