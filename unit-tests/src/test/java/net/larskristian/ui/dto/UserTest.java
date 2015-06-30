package net.larskristian.ui.dto;

import net.larskristian.api.dto.User;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Lars K. Johansen
 */
public class UserTest {

    User sut;

    @Before
    public void setUp() {
        sut = new User();
    }

    @Test
    public void testPerson() {
        String firstName = "Lars";

        sut.setFirstName(firstName);

        assertThat(sut.getFirstName(), is("Lars"));
    }
}
