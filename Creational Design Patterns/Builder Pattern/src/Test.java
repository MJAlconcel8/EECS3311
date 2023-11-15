public class Test {
    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();

        HouseBuilder woodBuilder = new WoodBuilder();
        House woodHouse = director.constructHouse(woodBuilder);

        HouseBuilder brickBuilder = new BrickBuilder();
        House brickHouse = director.constructHouse(brickBuilder);
    }

    // Builder Pattern
    // The builder pattern ease the construction of a complex object from simple objects.
    // Builder pattern is useful when the construction of the object is very complex
    // The Builder pattern also separates the construction of a complex object from its representation so that the same construction process can bee used to create another composition of objects
    // The main objective is to separate the construction of objects and representations

    // Parts of Builder Pattern
    // Builder - Builder is responsible for defining the construction process for individual parts. Builder has those individual processes to initialize the configure the product
    // Director - Director takes those individual processes fro the builder and defines the sequence to build the product
    // Product - Product is the final object which is produced from the builder and coordination

    // Where to use Builder Pattern?
    // When the algorithm for creating a complex object should be independent of the parts that maje up the object
    // When the construction process must allow different representation for the object that is constructed
    // When you want to insulate clients from the knowedge of the actual creation process and resulting product

    // Advantages of Builder Pattern
    // The built object is shielded from the details of its construction
    // Code for construction is isolated from the code for representation and both are easy to replace without affecting the other
    // Gives you control over the construction process
    // Gives you the possibility to reuse and change the process and product

    //Summary
    // We understood Builder Pattern
    // We saw multiple usage and examples of Builder Pattern
    // At the end, we covered the usage and benefits of Builder pattern
}