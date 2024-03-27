
/**
 * Intervale
 */
public class Intervale {

    private Double left;
    private Double right;

    private int numereTestate = 0;
    private int numereTestateContinute = 0;

    public Intervale(Double left, Double right) {
        this.left = left;
        this.right = right;
    }

    public void test(Double double1) {
        numereTestate++;
        if (left <= double1 && double1 <= right) {
            numereTestateContinute++;
        }
    }

    public String getProcent() {
        return (double) numereTestateContinute / numereTestate * 100 + "%\n";
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "[" + left + ", " + right + "] " + getProcent();
    }

    public void printResults() {
        System.out.println(this);
    }
}