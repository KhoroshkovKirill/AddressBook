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

    public void setStreet(String street){
        this.street = street;
    }

    public void setHouse(String house){
        this.house = house;
    }

    public void setFlat(String flat){
        this.flat = flat;
    }

    @Override
    public String toString() {
        return street +' '+ house +' '+ flat;
    }
}
