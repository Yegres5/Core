/**
 * <pre>
 * FactoryMethod.AbstractEntity factoryEntity = FactoryMethod.createObject(bool);
 * System.out.println(factoryEntity.getInfo());
 * </pre>
 */

public final class FactoryMethod {
    public static AbstractEntity createObject(Boolean property) {
        if (property) {
            return new FirstFactory().createEntity();
        }
        return new SecondFactory().createEntity();
    }

    public interface AbstractEntity {
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
