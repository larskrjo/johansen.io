package net.larskristian.ui;

import net.larskristian.framework.uri.UriPaths;
import net.larskristian.test.integration.base.BaseIntegrationTest;
import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Lars K. Johansen
 */
public class UITests extends BaseIntegrationTest {

    @Test
    public void simple() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name(UriPaths.JSP_HOME));
    }
}
