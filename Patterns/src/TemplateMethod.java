/**
 * <pre>
 * TemplateMethod.AbstractTemplate templateClass;
 * templateClass = new TemplateMethod.Summator(10, 10, 15);
 * templateClass.templateMethod();
 * System.out.println(String.format("Template method data value is %s", templateClass.getData()));
 * </pre>
 */
public class TemplateMethod {
    public static abstract class AbstractTemplate {
        protected int data;
        protected int treshold;
        protected int increment;

        public int getData() {
            return data;
        }

        public AbstractTemplate(int data, int treshold, int increment) {
            this.data = data;
            this.treshold = treshold;
            this.increment = increment;
        }

        public void templateMethod() {
            step1();
            if (step2()) {
                step3();
            }
        }

        protected abstract void step1();

        boolean step2() {
            return data > treshold;
        }

        protected abstract void step3();
    }

    public static class Multiplier extends AbstractTemplate {
        public Multiplier(int data, int treshold, int increment) {
            super(data, treshold, increment);
        }

        protected void step1() {
            this.data *= this.increment;
        }

        protected void step3() {
            this.data *= 2 * this.increment;
        }
    }

    public static class Summator extends AbstractTemplate {
        public Summator(int data, int treshold, int increment) {
            super(data, treshold, increment);
        }

        protected void step1() {
            this.data += this.increment;
        }

        protected void step3() {
            this.data += 2 * this.increment;
        }
    }
}
