public class Main {
    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactory();

        Product productA = productFactory.createProduct("A");
        productA.writeName("productA");
        Product productB = productFactory.createProduct("B");
        productB.writeName("productB");
    }
    // Factory Pattern
    // A factory pattern is one that provides an instance of one of the several possible classes based on provided input
    // This is very common pattern in object oriented programming languages
    // Usually factory pattern creates object of the classes having common parent. But these objects are different from each other and perform different tasks

    // Issue of Object Creation
    //Assume a scenario where you create library classes and you have clients who consume your library to buld their application
    // Now there are two issues with the traditional ways of object creation
    // 1) Client Code will have a lit of "new" keywords to create different types of objects
    // 2) Client Code will be doing lots of object creational activities instead of focusing on buisness logic
    // 3) Client needs to be aware of all types of classes available in creation

    //Where to use Factory Pattern?
    // Whenever a class can't anticipate in the type of object it must create
    // Whenever you want to be aware of which class gets created
    // Whenever you want to insulate the client from the actual type that is being instantiated

    //Advantages of Factory Pattern
    // The client does not need to know every subclass of objects in library
    // It only needs to know the abstract class or interface and the respective factory class
    // The factory class encapsulates the creation of object. This can be useful if the creation of object is very complex process

    //Summary
    // We understood factory pattern
    // We saw multiple usage and examples of factory pattern
    // we saw implementation of factory pattern
    // At the end, we covered the usage and benefits of factory pattern
}