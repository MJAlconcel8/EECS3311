public class ClsSwitch implements ISwitch{
    IEquipment equipment;

    @Override
    public void on() {
        equipment.start();
    }

    @Override
    public void off() {
        equipment.stop();
    }

    public void setEquipment(IEquipment equipment) {
        this.equipment = equipment;
    }
}
