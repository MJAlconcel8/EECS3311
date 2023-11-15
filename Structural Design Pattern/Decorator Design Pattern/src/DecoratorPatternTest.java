public class DecoratorPatternTest {
    public static void main(String[] args) {
       Dress sportyDress = new SportyDress(new BasicDress());
       sportyDress.assemble();
       System.out.println();

       Dress fancyDress = new FancyDress(new BasicDress());
       fancyDress.assemble();
       System.out.println();

       Dress casualDress = new CasualDress(new BasicDress());
       casualDress.assemble();
       System.out.println();

       Dress sportyFancyDress = new SportyDress(new FancyDress(new BasicDress()));
       sportyFancyDress.assemble();
       System.out.println();

       Dress casualFancyDress = new CasualDress(new FancyDress(new BasicDress()));
       casualFancyDress.assemble();
       System.out.println();
    }

    // Decorator Design Pattern - Properties
    // Structural design pattern
    // Used when we want to modify functionality of an Object at runtime and it should not change individual object functionality
    // i.e Adding different functionalities in Dress
}