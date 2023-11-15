public class PrototypeTest {
    public static void main(String[] args) {
       Customer customer1 = new Customer();
       customer1.setName("customer1");
       customer1.setAge(30);

       Customer customer2 = (Customer) customer1.clone();

       System.out.println("--- Before Updating Clonned Object -----");
       System.out.println("Customer1 - " + customer2.getName() + " " + customer1.getAge());
       System.out.println("Customer1 - " + customer1.getName() + " " + customer2.getAge());

       customer2.setName("customer2");
       customer2.setAge(40);

       System.out.println("--- After Updating Clonned Object ---");
       System.out.println("Customer 1 - " + customer1.getName() + " " + customer1.getAge());
       System.out.println("Customer 2 - " + customer2.getName() + " " + customer2.getAge());
    }
    // Prototype pattern
    // Prototype pattern is the pattern that creates new objects from the existing object
    // Prototype pattern suggest the creation of new object by cloning an existing object
    // Prototype pattern says, after cloning any changes to the cloned object should not affect the original object
    // Prototype pattern is used when creating a fresh object of a class, which is used in a consuming or complex process

    //Prototype Pattern is not Copying
    // Prototype pattern is not setting one object in to other object
    // Prototype pattern talks about cloning the object

    // Where to use Prototype Pattern?
    // Whenever a system needs to be independent of how its objects are created, composed, and represented
    // Whenever adding and removing objects at runtime
    // Whenever fresh object creation is a complex process
    // Whenever we want less number of classes in our system

    //Advantages of Prototype Pattern
    // Speeds up instantiation of large, dynamically loaded classes
    // Reduced Sub Classes
}