package MyClass;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
public class Address {
    private String street;
    private String house;
    private String flat;

    public Address(String street, String house, String flat){
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getStreet(){
        return street;
    }

    public String getHouse(){
        return house;
    }

    public String getFlat(){
        return flat;
    }

    @Override
    public String toString() {
        return street +' '+ house +' '+ flat;
    }

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Address)) return false;
        return (this.street.equals(((Address) obj).street) &&
                this.house.equals(((Address) obj).house) &&
                this.flat.equals(((Address) obj).flat));
    }

    @Override
    public int hashCode(){
        return 33 * this.street.hashCode() + 13 * this.house.hashCode() + this.flat.hashCode();
    }
}
