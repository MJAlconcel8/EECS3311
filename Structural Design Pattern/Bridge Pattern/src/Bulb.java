public class Bulb implements IEquipment{
    @Override
    public void start() {
        System.out.println("Started Buld");
    }

    @Override
    public void stop() {
        System.out.println("Stopped Bulb");
    }
}
