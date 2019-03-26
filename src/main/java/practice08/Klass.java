package practice08;

public class Klass {
    private int number;
    private Student leader;


    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDisplayName() {
        return "Class " + this.getNumber();
    }

    public void assignLeader(Student student) {
        this.leader = student;

    }
}
