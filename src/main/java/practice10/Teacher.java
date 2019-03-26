package practice10;

import java.util.HashSet;
import java.util.Iterator;

public class Teacher extends Person {
    private HashSet classes;

    public HashSet getClasses() {
        return classes;
    }

    public void setClasses(HashSet classes) {
        this.classes = classes;
    }

    public Teacher(int id, String name, int age, HashSet classes) {
        super(id, name, age);
        this.classes = classes;
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public String introduce() {
        if (this.getClasses() != null) {
            String klass = "";
            Iterator<Klass> it = this.getClasses().iterator();
            while (it.hasNext()) {
                String str = it.next().getNumber() + "";
                klass += str;
            }
            klass = klass.split("")[0] + ", " + klass.split("")[1];
            return super.introduce() + " I am a Teacher. I teach Class " + klass + ".";
        }
        return super.introduce() + " I am a Teacher. I teach No Class.";
    }

    public Boolean isTeaching(Student student) {
        Klass klass = student.getKlass();
        return this.getClasses().contains(klass);
    }

    public String introduceWith(Student student) {
        if (isTeaching(student)) {

            return "My name is " + this.getName() + ". I am " + this.getAge() + " years old. I am a Teacher. I teach " + student.getName() + ".";
        }
        return "My name is " + this.getName() + ". I am " + this.getAge() + " years old. I am a Teacher. I don't teach " + student.getName() + ".";

    }
}
