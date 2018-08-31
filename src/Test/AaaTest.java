package Test;

import java.io.*;

public class AaaTest {
    public static void main(String[] args) throws Exception {
        /**
         * 对象的输出流   即把对象写入到硬盘中  序列化
         */
        /*File file = new File("D:\\objFile.obj");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);
        Instance instance = Instance.getInstance();
        out.writeObject(instance);
        out.close();*/

        /**
         * 对象的输入流   即从硬盘中读对象的过程    反序列化
         */
        /*ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Instance instance1 = (Instance) in.readObject();

        in = new ObjectInputStream(new FileInputStream(file));
        Instance instance2 = (Instance) in.readObject();
        System.out.println("obj1 hashcode:" + instance1.hashCode());
        System.out.println("obj2 hashcode:" + instance2.hashCode());
        in.close();*/


       /* Student2 student = new Student2("LIUFEI",24);
        Student2 student2 = student;
        student2.setAge(23);
        System.out.println(student.getAge());*/

        Student2 student = new Student2("LIUFEI",24);
        Student2 student2 = student.clone();
        /*System.out.println("studnet :"+student.getAge()+","+student.getName());
        System.out.println("studnet2 :"+student2.getAge()+","+student2.getName());*/
        System.out.println(student);
        System.out.println(student2);
    }
}
