public class App {
    public static void main(String[] args) throws Exception {
        Boolean bool = true;

        // Singleton
        String helloMessage = "Hello, World!";
        System.out.println(Singleton.getInstance(helloMessage).value);

        // Builder
        BuilderPattern.CarBuilder carBuilder = new BuilderPattern.CarBuilder();
        BuilderPattern.Car car = carBuilder
                .setNumberOfSeats(16)
                .setNumberOfDoors(3)
                .setModel("Bus")
                .build();
        System.out.println(String.format("Car model is %s", car.model));

        // Factory method
        FactoryMethod.AbstractEntity factoryEntity = FactoryMethod.createObject(bool);
        System.out.println(factoryEntity.getInfo());

        // Chain of Responsibility
        ChainOfResponsibilityPattern.Object object = new ChainOfResponsibilityPattern.Object(5);
        ChainOfResponsibilityPattern.ChainOfResponsibility chain = new ChainOfResponsibilityPattern.ChainOfResponsibility(
                new ChainOfResponsibilityPattern.AbstractValidator[] {
                        new ChainOfResponsibilityPattern.ThresholdValidator(10),
                        new ChainOfResponsibilityPattern.ThresholdValidator(5)
                });

        ChainOfResponsibilityPattern.SummationService service = new ChainOfResponsibilityPattern.SummationService(chain,
                object);
        if (service.usefulWork(15)) {
            System.out.println(String.format("Success: object value is %s", object.value));
        }

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
