package com.personalproject.core.models;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class ServicesImplTest {

    private final AemContext aemContext = new AemContext();
    private Services services;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(ServicesImpl.class);
        aemContext.load().json("/com/personalproject/core/models/Services.json","/component");
    }

    @Test
    void getTitle() {
        aemContext.currentResource("/component/services");
        Services services = aemContext.request().adaptTo(Services.class);
        final String expected="Web Design";
        String actual = services.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getDescription() {
        aemContext.currentResource("/component/services");
        Services services = aemContext.request().adaptTo(Services.class);
        final String expected="“It is not because things are difficult that we do not dare; it is because we do not dare that they are difficult.”";
        String actual = services.getDescription();
        assertEquals(expected,actual);
    }
}