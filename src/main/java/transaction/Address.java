package transaction;

public class Address {
    String address;


    public Address(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "address(" + address + '\'' +
                ')';
    }
}
