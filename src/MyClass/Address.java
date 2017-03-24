package MyClass;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
final class Address {
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
        return this.street +' '+ this.house +' '+ this.flat;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        if (this == obj) {
            return true;
        }
        if (! (obj instanceof Address)) {
            return false;
        }
        return (this.street.equals(((Address) obj).street) &&
                this.house.equals(((Address) obj).house) &&
                this.flat.equals(((Address) obj).flat));
    }

    @Override
    public int hashCode(){
        return 33 * this.street.hashCode() + 13 * this.house.hashCode() + this.flat.hashCode();
    }
}
