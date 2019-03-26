package practice11;

import com.google.common.collect.Lists;

import java.util.Collection;

public class Klass {
    private int number;
    private Student leader;
    private Collection<Listener> joinJoinListeners;
    private Collection<Listener> assignLeaderListeners;


    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Klass(int number) {
        this.number = number;
        this.joinJoinListeners = Lists.newArrayList();
        this.assignLeaderListeners = Lists.newArrayList();
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
        if (student.getKlass().equals(this)) {
            this.leader = student;
            assignLeaderListeners.forEach(l -> l.notifyAssignLeader(student, this));
        } else {
            System.out.println("It is not one of us.");
        }
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        joinJoinListeners.forEach(l -> l.notifyJoin(student, this));
    }

    public Boolean isIn(Student student) {
        return student.getKlass().equals(this);
    }

    public void registerJoinListener(Listener joinListener) {
        this.joinJoinListeners.add(joinListener);
    }

    public void registerAssignLeaderListener(Listener listener) {
        this.assignLeaderListeners.add(listener);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Klass klass = (Klass) o;

        if (number != klass.number) return false;
        return leader != null ? leader.equals(klass.leader) : klass.leader == null;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
