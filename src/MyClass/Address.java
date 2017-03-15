package MyClass;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
final class Address {
    private String street;
    private String house;
    private String flat;

    //как сделать, чтобы методы(не все) были видны только классам из пакета
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

    @Override
    public boolean equals(Object obj) {
        if (! (obj instanceof Address)) return false;
        return (this.street.equals(((Address) obj).street) &&
                this.house.equals(((Address) obj).house) &&
                this.flat.equals(((Address) obj).flat));
    }
}
