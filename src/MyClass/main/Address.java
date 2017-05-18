package MyClass.main;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
final public class Address {
    final private String street;
    final private String house;
    final private String flat;

    public Address(String street, String house, String flat){
        if (street == null || house == null || flat == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getStreet(){
        return this.street;
    }

    public String getHouse(){
        return this.house;
    }

    public String getFlat(){
        return this.flat;
    }

    @Override
    public String toString() {
        return "street: " + this.street + " house: " + this.house +" flat: " + this.flat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (! (obj instanceof Address)) {
            return false;
        }
        final Address addr = (Address) obj;
        return (this.street.equals(addr.street) &&
                this.house.equals(addr.house) &&
                this.flat.equals(addr.flat));
    }

    @Override
    public int hashCode(){
        int result = 1;
        result = 31 * result + this.street.hashCode();
        result = 31 * result + this.house.hashCode();
        result = 31 * result + this.flat.hashCode();
        return result;
    }
}
