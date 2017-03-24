package MyClass;


import java.util.*;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
final public class AddressBook {//Erlang и  javafx глянуть
    final private Map<String, Address> location;

    public AddressBook() {
        this.location = new HashMap<>();
    }

    public AddressBook(Map<String, Address> location) {//Address проверить на null
        this();
        if (location == null){
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        this.location.putAll(location);
    }

    public AddressBook(AddressBook ab) {
        this(ab.location);
    }

    public void addPerson(String name, String street, String house, String flat) {
        if (name == null){
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (this.location.containsKey(name)) {
            throw new IllegalArgumentException("This name is already contained");
        }
        this.location.put(name, new Address(street, house, flat));
    }

    public void removePerson(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (!this.location.containsKey(name)) {
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

    public List<String> whoIsThere(String street) {
        if (street == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            final String name = entry.getKey();
            final Address address = entry.getValue();
            if (address.getStreet().equals(street))
                names.add(name);
        }
        return names;
    }

    public List<String> whoIsThere(String street, String house) {
        if (street == null || house == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
        List<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            final String name = entry.getKey();
            final Address address = entry.getValue();
            if (address.getStreet().equals(street) && address.getHouse().equals(house))
                names.add(name);
        }
        return names;
    }

    @Override
    public String toString() {
        return this.location.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Arguments cannot be null");
        }
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