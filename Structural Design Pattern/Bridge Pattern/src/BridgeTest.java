public class BridgeTest {
    public static void main(String[] args) {
        IEquipment objBulb = new Bulb();
        IEquipment objRefrigerator = new Refrigerator();

        ClsSwitch objSwitch = new ClsSwitch();

        objSwitch.setEquipment(objBulb);
        objSwitch.on();
        objSwitch.off();

        objSwitch.setEquipment(objRefrigerator);
        objSwitch.on();
        objSwitch.off();
    }
    // Bridge Pattern
    // Bridge Pattern creates a clear separation between abstraction and implementation
    // Bridge pattern helps decoupling an abstraction from implementation
    // Decoupling abstraction and implementation can vary independently without impacting the other

    // Adapter Pattern vs. Bridge Pattern
    // In Adapter Pattern, a class is used to convert one kind of interface to another
    // The bridge pattern is designed to separate a class's interface from its implementation, so that both can vary independently.

    // Where to use this pattern
    // Whenever you want to separate the abstract structure and its concrete implementation
    // Whenever you want to share an implementation among multiple objects
    // Whenever you want to hide implmentation details from clients. Changes in implementation should have no impact to the clients.
}