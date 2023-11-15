public class ClsFixedAddress {
    public String address = "#454 Prestige Tower";

    static ClsFixedAddress clsFixedAddress;

    private ClsFixedAddress(){

    }

    public static ClsFixedAddress getClsFixedAddress() {
        return clsFixedAddress;
    }

    public static void setClsFixedAddress(ClsFixedAddress clsFixedAddress) {
        ClsFixedAddress.clsFixedAddress = clsFixedAddress;
    }

    public static ClsFixedAddress getClsFixedAddressFixedAddress(){
        if(clsFixedAddress==null){
            clsFixedAddress = new ClsFixedAddress();
        }
        return clsFixedAddress;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
