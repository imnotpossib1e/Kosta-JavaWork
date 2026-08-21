package ex0821;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SerializableSaveExam {

    // step11_IOStream/src/ex0821/save.txt
    public SerializableSaveExam() {
        // 객체 저장 - 직렬
        try (ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream("step11_IOStream/src/ex0821/save.txt"))) {
            Member m1 = new Member("lee", 20, "서울");
            Member m2 = new Member("kim", 25, "경기");
            Member m3 = new Member("park", 28, "대전");

            List<Member> list = new ArrayList<Member>();
            list.add(m1);
            list.add(m2);
            list.add(m3);

//            oos.writeObject(m1);
//            oos.writeObject(m2);
//            oos.writeObject(m3);

            oos.writeObject(list);

            System.out.println("저장 완료");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new SerializableSaveExam();
    }
}
