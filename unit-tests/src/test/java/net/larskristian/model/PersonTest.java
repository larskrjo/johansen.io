package net.larskristian.model;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Lars K. Johansen
 */
public class PersonTest {

    @Test
    public void testPerson() {
        Person person = new Person("Lars", "Johansen");
        assertThat(person.getFirstName(), is("Larss"));
        assertThat(person.getLastName(), is("Johansen"));
    }
}
