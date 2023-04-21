/**
 * <pre>
 * Boolean bool = true;
 * Strategy.AbstractStrategy strategy;
 * 
 * if (bool) {
 *     strategy = new Strategy.FullValue(10);
 * } else {
 *     strategy = new Strategy.HalfValue(10);
 * }
 * strategy.addValue(100);
 * </pre>
 */
public final class Strategy {
    public static abstract class AbstractStrategy {
        protected int data;
        public int getData() { return this.data; }

        AbstractStrategy(int data) {
            this.data = data;
        }
        public abstract void addValue(int value);
    }

    public static class FullValue extends AbstractStrategy {
        FullValue(int data) {
            super(data);
        }

        public void addValue(int value) {
            this.data += value;
        }
    }

    public static class HalfValue extends AbstractStrategy {
        HalfValue(int data) {
            super(data);
        }

        public void addValue(int value) {
            this.data += value/2;
        }
    }
}
