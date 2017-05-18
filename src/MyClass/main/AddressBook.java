package MyClass.main;


import java.util.*;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
final public class AddressBook {
    final private Map<String, Address> location;

    public AddressBook() {
        this.location = new HashMap<>();
    }

    public AddressBook(Map<String, Address> location) {
        this();
        if (location == null){
            throw new IllegalArgumentException("Argument cannot be null");
        }
        if (location.containsKey(null) || location.containsValue(null)){
            throw new IllegalArgumentException("Argument cannot contain null");
        }
        this.location.putAll(location);
    }

    public AddressBook(AddressBook ab) {
        location = new HashMap<>(ab.location);
    }

    public void addPerson(String name, Address address) {
        if (name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (address == null){
            throw new IllegalArgumentException("Address cannot be null");
        }
        if (this.location.containsKey(name)) {
            throw new IllegalArgumentException("This name is already contained");
        }
        this.location.put(name,address);
    }

    public void addPerson(String name, String street, String house, String flat) {
        addPerson(name, new Address(street, house, flat));
    }

    public Address removePerson(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (!this.location.containsKey(name)) {
            throw new IllegalArgumentException("Name is absent");
        }
        return this.location.remove(name);
    }

    public Address getAddress(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        return this.location.get(name);
    }

    public void changeAddress(String name, Address address){
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (!this.location.containsKey(name)) {
            throw new IllegalArgumentException("Name is absent");
        }
        this.location.put(name,address);
    }

    public void changeAddress(String name, String street, String house, String flat) {
        changeAddress(name, new Address(street, house, flat));
    }

    public List<String> whoIsThere(String street) {
        if (street == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            final String curName = entry.getKey();
            final Address curAddress = entry.getValue();
            if (curAddress.getStreet().equals(street))
                names.add(curName);
        }
        return names;
    }

    public List<String> whoIsThere(String street, String house) {
        if (street == null || house == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            final String curName = entry.getKey();
            final Address curAddress = entry.getValue();
            if (curAddress.getStreet().equals(street) && curAddress.getHouse().equals(house))
                names.add(curName);
        }
        return names;
    }

    @Override
    public String toString() {
        return this.location.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return ((o instanceof AddressBook) && this.location.equals(((AddressBook) o).location));
    }

    @Override
    public int hashCode() {
        return this.location.hashCode();
    }

}