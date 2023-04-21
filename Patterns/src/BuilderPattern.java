/**
 * <pre>
 * BuilderPattern.FirstEntityBuilder firstBuilder = new BuilderPattern.FirstEntityBuilder();
 * BuilderPattern.Director.constructEntityOneWay(firstBuilder);
 * BuilderPattern.FirstEntity entity1 = firstBuilder.getResult();
 * System.out.println(entity1.getType());
 *
 * BuilderPattern.SecondEntityBuilder secondBuilder = new BuilderPattern.SecondEntityBuilder();
 * BuilderPattern.Director.constructEntityOneWay(secondBuilder);
 * BuilderPattern.SecondEntity entity2 = secondBuilder.getResult();
 * System.out.println(entity2.getInfo());
 * </pre> 
 */
public final class BuilderPattern {
    
    public static enum EntityTypes {
        FIRST_TYPE, SECOND_TYPE
    }

    public static class FirstEntity {
        private String feature;
        private EntityTypes type;

        public FirstEntity(String feature, EntityTypes type) {
            this.feature = feature;
            this.type = type;
        }

        public String getFeature() { return this.feature; }
        public EntityTypes getType() { return this.type; }
    }

    public static class SecondEntity {
        private String feature;
        private EntityTypes type;

        public SecondEntity(String feature, EntityTypes type) {
            this.feature = feature;
            this.type = type;
        }
        
        public String getInfo() {
            return String.format("This is %s entity with %s feature", type, feature);
        }
    }

    private interface Builder {
        void setFeature(String feature);
        void setType(EntityTypes type);
    }

    public static class FirstEntityBuilder implements Builder {
        private EntityTypes type;
        private String feature;

        @Override
        public void setFeature(String feature) { this.feature = feature; }
        @Override
        public void setType(EntityTypes type) { this.type = type; }
        public FirstEntity getResult() { return new FirstEntity(feature, type); }
    }

    public static class SecondEntityBuilder implements Builder {
        private EntityTypes type;
        private String feature;

        @Override
        public void setFeature(String feature) { this.feature = feature; }
        @Override
        public void setType(EntityTypes type) { this.type = type; }
        public SecondEntity getResult() { return new SecondEntity(feature, type); }
    }

    public static class Director {
        public static void constructEntityOneWay(Builder builder) {
            builder.setFeature("Fancy");
            builder.setType(EntityTypes.FIRST_TYPE);
        }

        public static void constructEntitySecondWay(Builder builder) {
            builder.setFeature("Not that fancy");
            builder.setType(EntityTypes.SECOND_TYPE);
        }
    }
}