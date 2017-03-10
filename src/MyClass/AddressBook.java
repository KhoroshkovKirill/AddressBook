package MyClass;


import java.util.*;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
final class AddressBook {
    private Map<String, Address> location;

    public AddressBook() {
        this.location = new TreeMap<>();
    }

    public AddressBook(Map<String, Address> location) {
        this.location = new TreeMap<>();
        this.location.putAll(location);
    }

    public AddressBook(AddressBook ab) {
        this.location = new TreeMap<>();
        this.location.putAll(ab.location);
    }

    public boolean addPerson(String name, String street, String house, String flat) {
        if (location.containsKey(name)){
            return false;
        }
        else {
            this.location.put(name, new Address(street, house, flat));
            return true;
        }
    }

    public boolean removePerson(String name) {
        if (location.containsKey(name)) {
            this.location.remove(name);
            return true;
        }
        else return false;
    }

    public Address getAddress(String name) {//Что мне лучше вернуть?
        return this.location.get(name);
    }

    public void changeAddress(String name, String street, String house, String flat) {
        this.location.get(name).setStreet(street);
        this.location.get(name).setHouse(house);
        this.location.get(name).setFlat(flat);
    }

    public List<String> whoIsThere(String street) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            if (entry.getValue().getStreet().equals(street))
                names.add(entry.getKey());
        }
        return names;
    }

    public List<String> whoIsThere(String street, String house) {
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            if (entry.getValue().getStreet().equals(street) && entry.getValue().getHouse().equals(house))
                names.add(entry.getKey());
        }
        return names;
    }

    @Override
    public String toString() {
        return location.toString();
    }

    @Override
    public boolean equals(Object o) {
        return ((o instanceof AddressBook) && this.location.equals(((AddressBook) o).location));
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }

}