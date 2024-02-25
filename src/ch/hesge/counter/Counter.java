package ch.hesge.counter;

/**
 * javac src/ch/hesge/counter/*.java -d classes
 * jar -cvf MyCounter.jar -C ./classes .
 */
public class Counter implements ICounter {

    protected int value;

    public Counter(int value) {
        this.value = value;
    }

    @Override
    public void inc() throws CounterException {
        ++this.value;
    }

    @Override
    public void add(int step) throws CounterException {
        this.value += step;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}
