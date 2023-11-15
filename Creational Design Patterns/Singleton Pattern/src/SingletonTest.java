public class SingletonTest {
    public static void main(String[] args) {
        ConnectionManager connectionManager1 = ConnectionManager.getSingletonConnectionManager();
        System.out.println("ConnectionManager1 - " + connectionManager1.hashCode());
        ConnectionManager connectionManagerManager2 = ConnectionManager.getSingletonConnectionManager();
        System.out.println("ConnectionManager2 - " + connectionManagerManager2.hashCode());
    }
    // Singleton Pattern
    // Singleton pattern restricts the number if instances of any class to one.
    // Singleton pattern restricts object creation from outside.
    // Signleton pattern suggest to have a single instance of class and that is shared between other resources

    // Singleton Pattern in Spring Framework
    // Do you know by defult all components in Spring container is singleton
    // Spring container makes sure that single instance of any component exist
    // Single instance of that component are shared between the threads and other resources

    // Where to use Singleton Patterm
    // Whenever we want only one instance of class
    // Whenever we want a global object that is independent of a request or session

    //Advantages of Singleton Pattern
    // Controlled access to unique instance
    // Reduced name space
    // Application consumes less memory because it keeps the object count low
    // Avoid unwanted object creation if single instance can serve the request

    // Summary
    // We understood what the is Singleton Pattern
    // We saw use case of Singleton Pattern
    // We also saw how to implement and use Signleton pattern in our code
    // At the end, we also discussed the benefits of Singleton pattern
}