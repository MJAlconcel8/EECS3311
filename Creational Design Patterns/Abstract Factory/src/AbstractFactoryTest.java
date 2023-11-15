import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AbstractFactoryTest {
    public static void main(String[] args) {
        while(true){
            int objectTypeInput = 0;
            InterfaceRenderer objectUiObject;
            System.out.println("Enter object type you want to render 0 for textbox and 1 for button");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            try {
                objectTypeInput = Integer.parseInt(bf.readLine());
                System.out.println("Creating object for inout - " + objectTypeInput);
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
            objectUiObject = ClsAbstractFactory.getUIObject(objectTypeInput);
            objectUiObject.render();
        }
    }
    // Abstract Factory Pattern
    // Abstract factory pattern s used to create instance of different families of classes
    // It is also called as factory of factories, i.e. the Abstract Factory Pattern is a factory pattern that returns one of several other factories
    // Abstract factory helps us to unite similar factory classes in to one unified interface

    // Where to use Abstract Factory Pattern
    // Rhe pattern can be used where we need to create sets of objects that share a common theme
    // The Abstract Factory is often used in the following scenarios.
        //1) Where there is a need to use different sets of object,
        //2) Or where the object could be added or changed during the runtime

    // Advantages of Abstract Factory Pattern
    // It makes possible to interchange concrete classes without changing the code that use them, even at run time

    // Summary
    // Revised Creational Design Pattern
    // Understanding of Abstract Factory Pattern
    // Usage of Abstract Factory Pattern
    // Simple implementation of Abstract Factory Pattern
    // Usage and Benefits of Abstract Factory Pattern
}