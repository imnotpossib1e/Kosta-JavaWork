package ex0810.ch07.Problem11;

public class Activity {

    public void onCreate() {
        System.out.println("기본적인 실행 내용");
    }

}

class MainActivity extends Activity {

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("추가적인 실행 내용");
    }
}
