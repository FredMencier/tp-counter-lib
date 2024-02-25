package ch.hesge.counter;

public class UpperLimitedPositiveCounter extends Counter {

    private final int max;

    public UpperLimitedPositiveCounter(int initValue, int max) throws CounterException {
        super(initValue);
        if (max < 0) {
            throw new CounterException("max can not be negative, provided value: %s".formatted(max));
        }
        if (initValue < 0 || initValue > max) {
            throw new CounterException("initial value: %s can not be negative or greater than max value: %s".formatted(initValue, max));
        }
        this.max = max;
    }

    @Override
    public void inc() throws CounterException {
        if (value < max) {
            super.inc();
        } else {
            throw new CounterException("counter reached max value %s".formatted(value));
        }
    }

    @Override
    public void add(int step) throws CounterException {
        if ((value + step) > max) {
            throw new CounterException("counter may exceed max value : %s current value: %s step: %s".formatted(max, value, step));
        }

        if ((value + step) < 0) {
            throw new CounterException("counter can not be negative, current value: %s step: %s".formatted(value, step));
        }
        super.add(step);
    }

    public int getMaxValue() {
        return max;
    }
}
