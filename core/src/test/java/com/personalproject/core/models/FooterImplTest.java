package com.personalproject.core.models;
import com.personalproject.core.models.Footer;
import com.personalproject.core.models.FooterImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class FooterImplTest {

    private final AemContext aemContext=new AemContext();
    private Footer footer;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(FooterImpl.class);
        aemContext.load().json("/com/personalproject/core/models/Footer.json","/component");
    }

    @Test
    void getTitle() {
        aemContext.currentResource("/component/footer");
        Footer footer = aemContext.request().adaptTo(Footer.class);
        final String expected="About Me";
        String actual = footer.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getDescription() {
        aemContext.currentResource("/component/footer");
        Footer footer = aemContext.request().adaptTo(Footer.class);
        final String expected="Home";
        String actual = footer.getDescription();
        assertEquals(expected,actual);
    }

    @Test
    void getTitle1() {
        aemContext.currentResource("/component/footer");
        Footer footer = aemContext.request().adaptTo(Footer.class);
        final String expected="Newsletter";
        String actual = footer.getTitle1();
        assertEquals(expected,actual);
    }

    @Test
    void getDescription1() {
        aemContext.currentResource("/component/footer");
        Footer footer = aemContext.request().adaptTo(Footer.class);
        final String expected="Service";
        String actual = footer.getDescription1();
        assertEquals(expected,actual);
    }

    @Test
    void getTitle2() {
        aemContext.currentResource("/component/footer");
        Footer footer = aemContext.request().adaptTo(Footer.class);
        final String expected="Follow Me";
        String actual = footer.getTitle2();
        assertEquals(expected,actual);
    }

    @Test
    void getDescription2() {
        aemContext.currentResource("/component/footer");
        Footer footer = aemContext.request().adaptTo(Footer.class);
        final String expected="Portfolio";
        String actual = footer.getDescription2();
        assertEquals(expected,actual);
    }
}