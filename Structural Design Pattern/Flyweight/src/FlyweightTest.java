public class FlyweightTest {
    public static void main(String[] args) {
        ClsVisitingCard visitingCardMark = new ClsVisitingCard("Mark");
        ClsVisitingCard visitingCardJoseph = new ClsVisitingCard("Joseph");
        ClsVisitingCard visitingCardAlconcel = new ClsVisitingCard("Alconcel");
        System.out.println(visitingCardMark.getName() + " - " + visitingCardMark.getAddress() + " - (hashcode #" + visitingCardMark.getAddress().hashCode() + ")");
        System.out.println(visitingCardJoseph.getName() + " - " + visitingCardJoseph.getAddress() + " - (hashcode #" + visitingCardJoseph.getAddress().hashCode() + ")");
        System.out.println(visitingCardAlconcel.getName() + " - " + visitingCardAlconcel.getAddress() + " - (hashcode #" + visitingCardAlconcel.getAddress().hashCode() + ")");
    }
    //Flyweight design pattern
    // Flyweight pattern provides a mechanism to avoid the creation of large number of expensive objects and instead reuse existing instances to represent new ones
    // Flyweight pattern is useful in optimizing the creation of too many objects by reusing the common data
    // Flyweight pattern reduce the creation of objects by sharing data, decreases the memory footprint and increase the performance

    //Where to use this pattern?
    // Whenever there is a need to create large number of objects that may not fit in memory.
    // Whenever most of an objects state can be derved at runtime.
    // Whenever there are groups of objects that shares the state
    // Whenever the remaining state can be factored into smaller objects with shared state.

    // Advantages of Pattern
    // This pattern helps in reducing the number of objects created
    // This pattern helps in decreasing the memory foorprint and incrwasing the performance

    // Summary
    // We understood, what is Flyweight pattern
    // We saw use-cases of Flyweight pattern
    // We also saw Java code implementation of Flyweight Pattern
    // At the end, we also discussed the benefits of Flyweight Pattern

}