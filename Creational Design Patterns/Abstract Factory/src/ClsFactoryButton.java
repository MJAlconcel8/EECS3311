public class ClsFactoryButton extends ClsAbstractFactory {
    public static InterfaceRenderer getButtonObject(){
        return new ClsButton();
    }
}
