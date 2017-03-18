package MyClass;


import java.util.*;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
final class AddressBook {
    private Map<String, Address> location;

    public AddressBook() {
        this.location = new HashMap<>();
    }

    public AddressBook(Map<String, Address> location) {
        this();
        this.location.putAll(location);
    }

    public AddressBook(AddressBook ab) {
        this(ab.location);
    }

    public void addPerson(String name, String street, String house, String flat) {
        if (name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (location.containsKey(name)) {
            throw new IllegalArgumentException("This name is already contained");
        }
        this.location.put(name, new Address(street, house, flat));
    }

    public void removePerson(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (!location.containsKey(name)) {
            throw new IllegalArgumentException("Name is absent");
        }
        this.location.remove(name);
    }

    public Address getAddress(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        return this.location.get(name);
    }

    public void changeAddress(String name, String street, String house, String flat) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (!this.location.containsKey(name)) {
            throw new IllegalArgumentException("Name is absent");
        }
        this.location.put(name, new Address(street, house, flat));
    }
//////////////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public List<String> whoIsThere(String street) {
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            if (entry.getValue().getStreet().equals(street))
                names.add(entry.getKey());
        }
        return names;
    }

    public List<String> whoIsThere(String street, String house) {
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            if (entry.getValue().getStreet().equals(street) && entry.getValue().getHouse().equals(house))
                names.add(entry.getKey());
        }
        return names;
    }
/////////////<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
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
        return location.hashCode();
    }

}