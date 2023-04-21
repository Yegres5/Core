public class App {
    public static void main(String[] args) throws Exception {
        // Singleton
        String helloMessage = "Hello, World!";
        System.out.println(Singleton.getInstance(helloMessage).value);

        // Builder
        BuilderPattern.FirstEntityBuilder firstBuilder = new BuilderPattern.FirstEntityBuilder();
        BuilderPattern.Director.constructEntityOneWay(firstBuilder);
        BuilderPattern.FirstEntity entity1 = firstBuilder.getResult();
        System.out.println(entity1.getType());

        BuilderPattern.SecondEntityBuilder secondBuilder = new BuilderPattern.SecondEntityBuilder();
        BuilderPattern.Director.constructEntityOneWay(secondBuilder);
        BuilderPattern.SecondEntity entity2 = secondBuilder.getResult();
        System.out.println(entity2.getInfo());
        
        // Factory method
        Boolean bool = true;
        FactoryMethod.Factory factory;
        if (bool) {
            factory = new FactoryMethod.FirstFactory();
        } else {
            factory = new FactoryMethod.SecondFactory();
        }
        System.out.println(factory.getInfo());

        // Chain of Responsibility
        ChainOfResponsibility.Object object = new ChainOfResponsibility.Object(0);
        ChainOfResponsibility.Chain_Node head = ChainOfResponsibility.Chain_Node.build_chain(
            new ChainOfResponsibility.ObjectService(object, 5),
            new ChainOfResponsibility.ObjectValidator(object, 10)
        );
        if (head.doWork()) {
            System.out.println(String.format("Success value of object is %s", object.value));
        } else {
            System.out.println(String.format("Fail value of object is %s", object.value)); 
        }
        System.out.println(object.value);

        // Template Method
        TemplateMethod.AbstractTemplate templateClass;
        if (bool) {
            templateClass = new TemplateMethod.Summator(10, 10, 15);
        } else {
            templateClass = new TemplateMethod.Multiplier(10, 10, 15);
        }
        templateClass.templateMethod();
        System.out.println(String.format("Template method data value is %s", templateClass.getData()));  

        // Strategy
        Strategy.AbstractStrategy strategy;
        if (bool) {
            strategy = new Strategy.FullValue(10);
        } else {
            strategy = new Strategy.HalfValue(10);
        }
        strategy.addValue(100);
        System.out.println(String.format("Strategy data value is %s", strategy.getData()));  
    }
}
