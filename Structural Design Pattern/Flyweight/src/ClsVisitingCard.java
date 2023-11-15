public class ClsVisitingCard {

    private String name;

    public ClsVisitingCard(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress(){
        return ClsFixedAddress.getClsFixedAddressFixedAddress().address;
    }
}
