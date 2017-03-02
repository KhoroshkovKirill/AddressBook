package MyClass;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by khoroshkovkirill on 16.02.17.
 */
public class AddressBook {
    private Map<String,Address> location;//Использовать класс как ключ?
    //А если просто наследовать map?
    public AddressBook(){
        this.location = new TreeMap<>();
    }

    public AddressBook(Map<String,Address> location){
        this.location = new TreeMap<>();
        this.location.putAll(location);
    }

    public void addPerson(String name, String street, String house, String flat){
        this.location.put(name, new Address(street,house,flat));//Правильно с new?
    }//Если name совпадает, что делать?

    public void removePerson(String name){
        this.location.remove(name);//А если нет такого, Exception? Или вернуть что-нибудь?
    }

    public Address getAddress(String name){//Что мне лучше вернуть?
        return this.location.get(name);
    }

    public void changeAddress(String name, String street, String house, String flat){
        this.location.get(name).setStreet(street);
        this.location.get(name).setHouse(house);
        this.location.get(name).setFlat(flat);
    }

    public List<String> whoIsThere(String street){
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            if(entry.getValue().getStreet().equals(street))
                names.add(entry.getKey());
        }
        return names;
    }

    public List<String> whoIsThere(String street, String house){
        ArrayList<String> names = new ArrayList<>();
        for (Map.Entry<String, Address> entry : this.location.entrySet()) {
            if(entry.getValue().getStreet().equals(street) && entry.getValue().getHouse().equals(house))
                names.add(entry.getKey());
        }
        return names;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Address> entry : this.location.entrySet()){
            sb.append(entry.getKey() +' '+ entry.getValue().toString());
        }
        return sb.toString();
    }

    @Override//что не так?
    public boolean equals(Object o) {
        return this.location.equals(o.location);
    }

    @Override
    public int hashCode() {
        return location != null ? location.hashCode() : 0;
    }
}
