public class ObjectAdapter extends ClsCollection{

    private ClsStack objStack = new ClsStack();

    public void add(String s){
        objStack.push(s);
    }
}
