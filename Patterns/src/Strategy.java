/**
 * <pre>
 * Strategy.AbstractStrategy strategy;
 * strategy = new Strategy.HalfValue(10);
 * strategy.addValue(100);
 * System.out.println(String.format("Strategy data value is %s", strategy.getData()));  
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
