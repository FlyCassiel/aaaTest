package Test;

/**
 * 构建器
 */
public class Student {
    /*必填*/
    private String name;
    private int age;
    /*选填*/
    private String sex;
    private String grade;

    public static class Builder {
        private String name;
        private int age;
        private String sex = "";
        private String grade = "";

        public Builder(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }
        public Builder grade(String grade) {
            this.grade = grade;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }

    /**
     * 有参构造
     * @param builder
     */
    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.grade = builder.grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }

    public static void main(String[] args){
        Student student = new Student.Builder("liufei",12).grade("一年级").build();
        System.out.println(student.age);
        System.out.println(student.grade);
        System.out.println(student.toString());
    }
}
