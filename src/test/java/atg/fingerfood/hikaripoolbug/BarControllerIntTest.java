package atg.fingerfood.hikaripoolbug;

import atg.fingerfood.hikaripoolbug.domain.Bar;
import atg.fingerfood.hikaripoolbug.service.BarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.UUID;

import static atg.fingerfood.hikaripoolbug.api.BarController.BAR_ENDPOINT;
import static java.util.UUID.randomUUID;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@RunWith(SpringRunner.class)
public class BarControllerIntTest {
    @Autowired
    private WebApplicationContext context;

    @MockBean
    private BarService barService;

    @Test
    public void test() throws Exception {
        Bar foo = new Bar(randomUUID(), randomUUID().toString());

        doReturn(foo)
                .when(barService)
                .getOneById(any(UUID.class));

        MockMvc mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();

        MockHttpServletRequestBuilder builder = get(BAR_ENDPOINT)
                .param("id", randomUUID().toString());

        MockHttpServletResponse result = mockMvc.perform(builder)
                .andReturn()
                .getResponse();

        assertThat(result.getStatus(), is(200));
    }
}
