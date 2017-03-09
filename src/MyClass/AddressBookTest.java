package MyClass;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by khoroshkovkirill on 27.02.17.
 */
public class AddressBookTest {
    @Test
    public void addPerson(){
        Map<String,Address> location = new TreeMap<>();
        Address shf = new Address("street","house","flat");
        location.put("name",shf);
        AddressBook ab = new AddressBook();
        ab.addPerson("name","street","house","flat");
        assertEquals(new AddressBook(location),ab);
    }

    @Test
    public void removePerson() throws Exception {
        AddressBook ab1 = new AddressBook();
        AddressBook ab2 = new AddressBook();
        ab2.addPerson("name","street","house","flat");
        ab2.removePerson("name");
        assertEquals(ab1,ab2);
    }

    @Test
    public void getAddress() throws Exception {
        Address shf = new Address("street","house","flat");
        AddressBook ab = new AddressBook();
        ab.addPerson("name","street","house","flat");
        assertEquals(shf,ab.getAddress("name"));
    }

    @Test
    public void changeAddress() throws Exception {
        AddressBook ab1 = new AddressBook();
        AddressBook ab2 = new AddressBook();
        ab1.addPerson("name","street","house","flat");
        ab1.changeAddress("name","street1","house1","flat1");
        ab2.addPerson("name","street1","house1","flat1");
        assertEquals(ab1,ab2);
    }

    @Test
    public void whoIsThere() throws Exception {
        AddressBook ab = new AddressBook();
        ab.addPerson("name1","street","house","flat222");
        ab.addPerson("name2","street","house222","flat");
        ab.addPerson("name3","street111","house","flat");
        List<String> s = new ArrayList<>();
        s.add("name1");
        s.add("name2");
        assertEquals(s,ab.whoIsThere("street"));
    }

    @Test
    public void whoIsThere1() throws Exception {
        AddressBook ab = new AddressBook();
        ab.addPerson("name1","street","house444","flat222");
        ab.addPerson("name2","street","house","flat");
        ab.addPerson("name3","street","house","flat");
        List<String> s = new ArrayList<>();
        s.add("name2");
        s.add("name3");
        assertEquals(s,ab.whoIsThere("street","house"));
    }

}