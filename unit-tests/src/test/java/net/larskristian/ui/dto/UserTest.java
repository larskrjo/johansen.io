package net.larskristian.ui.dto;

import net.larskristian.api.dto.User;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Lars K. Johansen
 */
public class UserTest {

    @Test
    public void testPerson() {
        User user = new User();
        user.setFirstName("Lars");
        user.setLastName("Johansen");

        assertThat(user.getFirstName(), is("Lars"));
        assertThat(user.getLastName(), is("Johansen"));
    }
}
