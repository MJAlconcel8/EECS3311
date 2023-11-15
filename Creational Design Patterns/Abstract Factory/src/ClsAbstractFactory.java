public class ClsAbstractFactory {
    public static InterfaceRenderer getUIObject(int typeOfObject) {
        switch(typeOfObject) {
            case 0:
                return ClsFactoryTextBox.getTextBoxObject();

            case 1:
                return ClsFactoryButton.getButtonObject();

            default:
                return null;
        }
    }
}
