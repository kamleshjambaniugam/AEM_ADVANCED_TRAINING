package com.personalproject.core.servlets;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletRequest;
import org.apache.sling.testing.mock.sling.servlet.MockSlingHttpServletResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import javax.servlet.ServletException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class ResourceTypeServletTest {

    ResourceTypeServlet resourceTypeServlet = new ResourceTypeServlet();
    private final AemContext aemContext=new AemContext();
    @BeforeEach
    void setUp() {
    }

    @Test
    void doGet() throws ServletException, IOException {
        MockSlingHttpServletRequest request = aemContext.request();
        MockSlingHttpServletResponse response = aemContext.response();
        aemContext.create().page("/content/personalproject/us/en");
        aemContext.create().page("/content/personalproject/us/en/advanced");
        resourceTypeServlet.doGet(request,response);
        List pageList = new ArrayList();
        pageList.add("advanced");
        assertEquals(pageList.toString(),response.getOutputAsString());
    }
}