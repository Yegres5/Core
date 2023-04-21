/**
 * <pre>
 * Boolean bool = true;
 * FactoryMethod.Factory factory;
 * 
 * if (bool) {
 *     factory = new FactoryMethod.FirstFactory();
 * } else {
 *     factory = new FactoryMethod.SecondFactory();
 * }
 *
 * System.out.println(factory.getInfo());
 * </pre>
 */

public final class FactoryMethod {

    private interface AbstractEntity {
        String getInfo();
    }

    public static class FirstEntity implements AbstractEntity {
        @Override
        public String getInfo() {
            return "First Entity";
        }
    }

    public static class SecondEntity implements AbstractEntity {
        String feature;

        public SecondEntity(String feature) {
            this.feature = feature;
        }

        @Override
        public String getInfo() {
            return String.format("Second Entity with %s feature", feature);
        }
    }

    public static abstract class Factory {
        private static AbstractEntity entity;

        public String getInfo() {
           entity = createEntity();
           return entity.getInfo();
        }

        public abstract AbstractEntity createEntity();
    }

    public static class FirstFactory extends Factory {
        @Override
        public AbstractEntity createEntity() {
            return new FirstEntity();
        }
    }

    public static class SecondFactory extends Factory {
        @Override
        public AbstractEntity createEntity() {
            return new SecondEntity("Fancy feature");
        }
    }
}
