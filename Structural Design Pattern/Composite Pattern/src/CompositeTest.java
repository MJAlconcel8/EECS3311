import java.util.ArrayList;
import java.util.List;

public class CompositeTest {
    public static void main(String[] args) {
        List<IUserInterface> list = new ArrayList<>();

        IUserInterface circle = new ClsCircle();
        IUserInterface line = new ClsLine();
        IUserInterface square = new ClsSquare();

        list.add(circle);
        list.add(line);
        list.add(square);

        for(IUserInterface obj: list){
            obj.draw();
        }
    }
    // Composite Pattern
    // Composite pattern allows treating the different objects in a similar fashion
    // Composite pattern arranges objects into tree structures to rpresent PART-WHOLE hiearchy
    // Composite pattern ets clients treat individual obejects and compositions of objects uniformly

    // Where to use this pattern?
    // Whenever you want to represent a part-whole relationship in a tree structure
    // Whenever you want clients to be able to ignore the differences between compositions of objects and individual objects
    // Whenever the structure can have any level of complexity and is dynamic

    // Advantages of Pattern
    // Define class hierarchies consisting of primitive objects and composite objects
    // Makes it easier to add new kind of components

    // Summary
    // We understood, what is Composite Pattern
    // We saw use-case of Composite Pattern
    // We also saw Java code implementation of Composite Pattern
    // At the end, we also discussed the benefits of Composite pattern
}