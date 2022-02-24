package com.personalproject.core.models;
import com.personalproject.core.models.HomeAbout;
import com.personalproject.core.models.HomeAboutImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class HomeAboutImplTest {

    private final AemContext aemContext=new AemContext();
    private HomeAbout homeAbout;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(HomeAboutImpl.class);
        aemContext.load().json("/com/personalproject/core/models/HomeAbout.json","/component");
    }

    @Test
    void getAbout() {
        aemContext.currentResource("/component/homeAbout");
        HomeAbout homeAbout = aemContext.request().adaptTo(HomeAbout.class);
        final String expected="THIS IS ME";
        String actual = homeAbout.getAbout();
        assertEquals(expected,actual);
    }

    @Test
    void getDetails() {
        aemContext.currentResource("/component/homeAbout");
        HomeAbout homeAbout = aemContext.request().adaptTo(HomeAbout.class);
        final String expected="PHILIP GILBERT";
        String actual = homeAbout.getDetails();
        assertEquals(expected,actual);
    }

    @Test
    void getIntro() {
        aemContext.currentResource("/component/homeAbout");
        HomeAbout homeAbout = aemContext.request().adaptTo(HomeAbout.class);
        final String expected="You will begin to realise why this exercise is called the Dickens Pattern with reference to the ghost showing Scrooge some different futures.";
        String actual = homeAbout.getIntro();
        assertEquals(expected,actual);
    }

    @Test
    void getButtonTitle() {
        aemContext.currentResource("/component/homeAbout");
        HomeAbout homeAbout = aemContext.request().adaptTo(HomeAbout.class);
        final String expected="DISCOVER NOW";
        String actual = homeAbout.getButtonTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getPath() {
        aemContext.currentResource("/component/homeAbout");
        HomeAbout homeAbout = aemContext.request().adaptTo(HomeAbout.class);
        final String expected="/content/personalproject/us/en/about";
        String actual = homeAbout.getPath();
        assertEquals(expected,actual);
    }

    @Test
    void getAboutImage() {
        aemContext.currentResource("/component/homeAbout");
        HomeAbout homeAbout = aemContext.request().adaptTo(HomeAbout.class);
        final String expected="/content/dam/personalproject/about-img.png";
        String actual = homeAbout.getAboutImage();
        assertEquals(expected,actual);
    }
}



