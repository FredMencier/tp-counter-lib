package ch.hesge.counter;

public interface ICounter {
    void inc() throws CounterException;

    void add(int step) throws CounterException;

    int getValue();
}
