public class ClsFactoryTextBox extends ClsAbstractFactory {
    public static InterfaceRenderer getTextBoxObject(){

        return new ClsTextBox();
    }
}
