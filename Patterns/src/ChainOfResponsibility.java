/**
 * <pre>
 * ChainOfResponsibility.Object object = new ChainOfResponsibility.Object(0);
 * ChainOfResponsibility.Chain_Node head = ChainOfResponsibility.Chain_Node.build_chain(
 *     new ChainOfResponsibility.ObjectService(object, 5),
 *     new ChainOfResponsibility.ObjectValidator(object, 10)
 * );
 * 
 * if (head.doWork()) {
 *     System.out.println(String.format("Success value of object is %s", object.value));
 * } else {
 *     System.out.println(String.format("Fail value of object is %s", object.value)); 
 * }
 * System.out.println(object.value);
 * </pre> 
 */
public final class ChainOfResponsibility {
    public static class Object {
        public int value;
        public Object(int value) { this.value = value; }
    }
   
    public static abstract class Chain_Node {
        private Chain_Node next;

        public static Chain_Node build_chain(Chain_Node firstNode, Chain_Node... chain) {
            Chain_Node node = firstNode;
            for (Chain_Node nextNode : chain) {
                node.next = nextNode;
                node = nextNode;
            }
            return firstNode;
        }

        public abstract boolean doWork();

        protected boolean checkNextNode() {
            if (next == null) {
                return true;
            }
            
            return next.doWork();
        }
    }

    public static class ObjectService extends Chain_Node {
        private Object object;
        private int increment;

        public ObjectService(Object object, int increment) {
            this.object = object;
            this.increment = increment;
        }

        public boolean doWork() {
            this.object.value += this.increment;
            return checkNextNode();
        }
    }

    public static class ObjectValidator extends Chain_Node {
        private Object object;
        private int validationThreshold;

        public ObjectValidator(Object object, int treshold) {
            this.object = object;
            this.validationThreshold = treshold;
        }

        public boolean doWork() {
            if (object.value < validationThreshold) {
                return false;
            }
            return checkNextNode();
        }
    }

}
