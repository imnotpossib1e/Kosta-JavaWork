package ex0811.exam;

public class Audio extends Elec implements ElecFunction {

    private int volumn;

    public Audio() {

    }

    public Audio(int volumn) {
        this.volumn = volumn;
    }

    public Audio(String code, int cost, int volumn) {
        super(code, cost);
        this.volumn = volumn;
    }

    @Override
    public void start() {
        // class 이름 가져오는 메소드
        System.out.println(
            getCode() + "제품 " + super.getClass().getSimpleName() + "를 " + volumn + "으로 듣는다.");
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
        sb.append("의 Audio를 ").append(volumn);
        sb.append("으로 듣는다.");
        return sb.toString();
    }
}
