public class Main {
    public static void main(String[] args) {
        ClsOrder order = new ClsOrder();
        order.placeOrderFacadeMethod();
    }
    // Facade Design Pattern
    // The Facade pattern simplify the complexity of system py providing a simplified interface to the system
    // The design pattern provides an integrated interface to a set of interfaces in a subsystem
    // This design pattern defines higher-level interface that makes the subsystem easier to use
    // A Flywight is an object that provides a simplified interface to a code such as a class library

    // Where to Use Facade Design Pattern
    // Whenever you want to add responsibilities to individual objects dynamically and transparently, without affecting thr original object or other objects
    // Whenever you want to add responsibilities to the object that you might want to change in the future
    // Whenever extension by static sub-classing is impractical

    //Advantages of Pattern
    // More flexibility than static inheritance
    // Avoids feature-laden classes high up in the hierarchy.
    // Simplifies coding because you write a series of classes targeted at a specific part of the functionality rather than coding all behavior into the object
    // Enhances the object's extensibility because you maje changes by coding
}