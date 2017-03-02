package MyClass;

import org.junit.jupiter.api.Test;

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

    }

    @Test
    public void getAddress() throws Exception {

    }

    @Test
    public void changeAddress() throws Exception {

    }

    @Test
    public void whoIsThere() throws Exception {

    }

    @Test
    public void whoIsThere1() throws Exception {

    }

}