import java.util.jar.JarEntry;

/**
 * The main method of this class plays out a scenario...
 * Jack has two cans of soda, RootBeer and GingerAle,
 * Jill also has two cans, Cherry and Grape.
 * Jack opens his RootBeer first, and gives it to Jill.
 * Jill completely drinks the RootBeer.
 * Jack asks her if she is still thirsty, Jill responds.
 * Now Jill opens her Cherry soda and drinks it until
 * she is satisfied, then gives it to Jack.
 * He takes a sip, but doesn't like it.
 * Jill checks how much is left in her Cherry soda, but decides
 * not to drink anymore. Jack asks Jill if he can try her Grape soda.
 * Jill gives it to Jack and he opens it.
 * Jack drinks about half of it, then stops and tells Jill how he now feels.
 * Finally, they check the amount available in all of the cans.
 */
public class Scenario {
   public static void main(String[] args){
       System.out.println("The main method of this class plays out a scenario...");
       Person jack = new Person("Jack");
       SodaCan rootBeer = new SodaCan("RootBeer");
       SodaCan gingerAle = new SodaCan("GingerAle");
       System.out.println("Jack has two cans of soda, RootBeer and GingerAle");
       Person jill = new Person("Jill");
       SodaCan cherry = new SodaCan("Cherry");
       SodaCan grape = new SodaCan("Grape");
       System.out.println("Jill also has two cans, Cherry and Grape.");
       rootBeer.open();
       System.out.println("Jack opens his RootBeer first, and gives it to Jill.");
       while( rootBeer.isOpen() && rootBeer.getAmount()>0){
           jill.gulpFrom(rootBeer);
       }
       System.out.println("Jack asks her if she is still thirsty, Jill responds.");
       System.out.println(jill);
       System.out.println("Now Jill opens her Cherry soda and drinks it until she is satisfied");
       cherry.open();
       while(!jill.getThirstStatus().equals("satisfied") && cherry.isOpen() && cherry.getAmount() > 0) {
          jill.sipFrom(cherry);
       }
       System.out.println(jill);
       System.out.println("she is satisfied, then gives it to Jack.");
       for(int i=0; i<1; i++){
           jack.sipFrom(cherry);
       }
       System.out.println("He takes a sip, but doesn't like it.");
       System.out.println("Jill checks how much is left in her Cherry soda, but decides not to drink anymore.");
       System.out.println("Jack asks Jill if he can try her Grape soda.");
       grape.open();
       System.out.println("Jill gives it to Jack and he opens it.");
       while( grape.isOpen() && grape.getAmount()>125){
           jack.sipFrom(grape);
       }
       System.out.println("Jack drinks about half of it, then stops and tells Jill how he now feels.");
       System.out.println(jack);
       System.out.println(String.format("Amount of GingerAle: %d cc",gingerAle.getAmount()));
       System.out.println(String.format("Amount of RootBeer: %d cc",rootBeer.getAmount()));
       System.out.println(String.format("Amount of Cherry: %d cc",cherry.getAmount()));
       System.out.println(String.format("Amount of Grape: %d cc",grape.getAmount()));
   }
}
