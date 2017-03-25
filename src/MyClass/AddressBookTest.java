package MyClass;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by khoroshkovkirill on 27.02.17.
 */
public class AddressBookTest {
    @Test
    public void addPerson(){
        Map<String,Address> location = new HashMap<>();
        Address shf = new Address("street","house","flat");
        location.put("name",shf);
        AddressBook ab = new AddressBook();
        ab.addPerson("name","street","house","flat");
        assertEquals(new AddressBook(location),ab);
    }

    @Test
    public void removePerson(){
        AddressBook ab1 = new AddressBook();
        AddressBook ab2 = new AddressBook();
        ab2.addPerson("name","street","house","flat");
        ab2.removePerson("name");
        assertEquals(ab1,ab2);
    }

    @Test
    public void removePerson2(){
        Address addr = new Address("street","house","flat");
        AddressBook ab2 = new AddressBook();
        ab2.addPerson("name","street","house","flat");
        assertEquals(addr,ab2.removePerson("name"));
    }

    @Test
    public void getAddress(){
        Address shf = new Address("street","house","flat");
        AddressBook ab = new AddressBook();
        ab.addPerson("name","street","house","flat");
        assertEquals(shf,ab.getAddress("name"));
    }

    @Test
    public void changeAddress(){
        AddressBook ab1 = new AddressBook();
        AddressBook ab2 = new AddressBook();
        ab1.addPerson("name","street","house","flat");
        ab1.changeAddress("name","street111","house111","flat111");
        ab2.addPerson("name","street111","house111","flat111");
        assertEquals(ab1,ab2);
    }

    @Test
    public void whoIsThere(){
        AddressBook ab = new AddressBook();
        ab.addPerson("name1","street","house","flat222");
        ab.addPerson("name2","street","house222","flat");
        ab.addPerson("name3","street111","house","flat");
        List<String> s = new ArrayList<>();
        s.add("name1");
        s.add("name2");
        List<String> wit = ab.whoIsThere("street");
        Collections.sort(wit);
        assertEquals(s,wit);
    }

    @Test
    public void whoIsThere1(){
        AddressBook ab = new AddressBook();
        ab.addPerson("name1","street","house444","flat222");
        ab.addPerson("name2","street","house","flat");
        ab.addPerson("name3","street","house","flat555");
        List<String> s = new ArrayList<>();
        s.add("name2");
        s.add("name3");
        List<String> wit = ab.whoIsThere("street","house");
        Collections.sort(wit);
        assertEquals(s,wit);
    }

    @Test
    public void copyAddressBook(){
        AddressBook ab = new AddressBook();
        ab.addPerson("name1","street1","house1","flat1");
        ab.addPerson("name2","street2","house2","flat2");
        AddressBook copiedAb = new AddressBook(ab);
        assertEquals(copiedAb,ab);
    }

}