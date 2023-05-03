public class App {
    public static void main(String[] args) throws Exception {
        String data = "Test data";
        Boolean bool = true;

        // Singleton
        String helloMessage = "Hello, World!";
        System.out.println(Singleton.getInstance(helloMessage).value);

        // Builder
        BuilderPattern.Director director = new BuilderPattern.Director();
        BuilderPattern.Builder builder = new BuilderPattern.Builder();
        director.constructOneType(builder);
        BuilderPattern.Entity entity = builder.data(data).build();
        
        // Factory method 
        FactoryMethod.AbstractEntity factoryEntity = FactoryMethod.createObject(bool);
        System.out.println(factoryEntity.getInfo());

        // Chain of Responsibility
        ChainOfResponsibility.Object object = new ChainOfResponsibility.Object(0);
        ChainOfResponsibility.Chain_Node head = ChainOfResponsibility.build_chain(
            new ChainOfResponsibility.ObjectService(object, 15),
            new ChainOfResponsibility.ObjectValidator(object, 10)
        );
        ChainOfResponsibility.proceedWithChain(head);

        // Template Method
        TemplateMethod.AbstractTemplate templateClass;
        templateClass = new TemplateMethod.Summator(10, 10, 15);
        templateClass.templateMethod();
        System.out.println(String.format("Template method data value is %s", templateClass.getData()));  

        // Strategy
        Strategy.AbstractStrategy strategy;
        strategy = new Strategy.HalfValue(10);
        strategy.addValue(100);
        System.out.println(String.format("Strategy data value is %s", strategy.getData()));  
    }
}
