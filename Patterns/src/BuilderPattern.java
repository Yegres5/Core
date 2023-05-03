/**
 * <pre>
 * BuilderPattern.Director director = new BuilderPattern.Director();
 * BuilderPattern.Builder builder = new BuilderPattern.Builder();
 * director.constructOneType(builder);
 * BuilderPattern.Entity entity = builder.data(data).build();
 * </pre> 
 */
public final class BuilderPattern {
    public static class Entity {
        public String type;
        public String data;

        public Entity(String type, String data) {
            this.type = type;
            this.data = data;
        }
    }

    public static class Builder {
        private String type;
        private String data;

        public Builder type(String type) {
            this.type = type;
            return this;
        }

        public Builder data(String data) {
            this.data = data;
            return this;
        }

        public Entity build() {
            return new Entity(type, data);
        }
    }


    public static class Director {
        public void constructOneType(Builder builder) {
            builder.type("Type 1");
        }

        public void constructSecondType(Builder builder) {
            builder.type("Type 2");
        }
    }
}