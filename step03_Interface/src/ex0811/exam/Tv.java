package ex0811.exam;

public class Tv extends Elec implements ElecFunction {

    private int chnnel;

    public Tv() {

    }

    public Tv(int chnnel) {
        this.chnnel = chnnel;
    }

    public Tv(String code, int cost, int chnnel) {
        super(code, cost);
        this.chnnel = chnnel;

    }

    @Override
    public void start() {
        System.out.println(
            getCode() + "제품 " + super.getClass().getSimpleName() + "를 " + chnnel + "을 본다.");
    }

    @Override
    public void stop() {

    }

    @Override
    public void display() {

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(super.toString());
        sb.append("제품 TV를 ").append(chnnel);
        sb.append("을 본다");
        return sb.toString();
    }
}
