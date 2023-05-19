/**
 * <pre>
 * ChainOfResponsibilityPattern.Object object = new ChainOfResponsibilityPattern.Object(5);
 * ChainOfResponsibilityPattern.ChainOfResponsibility chain = new ChainOfResponsibilityPattern.ChainOfResponsibility(
 *         new ChainOfResponsibilityPattern.AbstractValidator[] {
 *                 new ChainOfResponsibilityPattern.ThresholdValidator(10),
 *                 new ChainOfResponsibilityPattern.ThresholdValidator(5)
 *         });
 * 
 * ChainOfResponsibilityPattern.SummationService service = new ChainOfResponsibilityPattern.SummationService(chain,
 *         object);
 * if (service.usefulWork(15)) {
 *     System.out.println(String.format("Success: object value is %s", object.value));
 * }
 * </pre>
 */
public final class ChainOfResponsibilityPattern {
    public static class ChainOfResponsibility {
        private AbstractValidator[] chain;

        public ChainOfResponsibility(AbstractValidator[] chain) {
            this.chain = chain;
        }

        public boolean proceedWithChain(Object object) {
            boolean isChainSucessull = true;
            for (AbstractValidator validator : chain) {
                isChainSucessull &= validator.validate(object);
            }

            return isChainSucessull;
        }
    }

    public static class Object {
        public int value;

        public Object(int value) {
            this.value = value;
        }
    }

    public static abstract class AbstractValidator {
        public abstract boolean validate(Object object);
    }

    public static class ThresholdValidator extends AbstractValidator {
        private int validationThreshold;

        public ThresholdValidator(int treshold) {
            this.validationThreshold = treshold;
        }

        public boolean validate(Object object) {
            if (object.value > validationThreshold) {
                System.out.format("Error: fail, the value: %d, is greater than the threshold: %d\n", object.value,
                        validationThreshold);
                return false;
            }
            return true;
        }
    }

    public static class SummationService {
        private ChainOfResponsibility chain;
        private Object object;

        public SummationService(ChainOfResponsibility chain, Object object) {
            this.chain = chain;
            this.object = object;
        }

        public boolean usefulWork(Integer increment) {
            if (chain.proceedWithChain(object)) {
                object.value += increment;
                return true;
            }

            return false;
        }
    }
}
