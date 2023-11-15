public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("WIN10_10MB_Photo1");
        Image image2 = new ProxyImage("WIN10_10MB_Photo2");
        image1.displayImage();
        image2.displayImage();
    }
    // Proxy Pattern
    // Proxy Pattern is like proxy that all request must go through
    // Proxy pattern suggest a simple object to access the complex object
    // Proxy pattern avoid the need of creating an expensive objects
    // In proxy pattern, one instance of the complex object is created, objects are created as a reference to the single original comoplex code
    // Any operations performed on the proxies are forwarded to the client

    //Where to use this pattern?
    // Whenever the creation of big object is expensive
    // Whenever we want authority checking befre one reaches the actual object that's requested
    // Proxy Pattern can provide a local representation for an object in a remote location

    // Advantages of Pattern
    // This pattern provides ability to control access to an object whether its is due to the cost of creating the complex object or security issue

    //Summary
    // We understood, what is Proxy Pattern
    // We saw use-case of proxy pattern
    // We also saw Java code implementation of Proxy Pattern
    // At the end, we also discussed the benefits of Proxy Pattern
}