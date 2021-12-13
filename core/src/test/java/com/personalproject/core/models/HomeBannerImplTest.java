package com.personalproject.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class HomeBannerImplTest {

    private final AemContext aemContext=new AemContext();
    private HomeBanner homeBanner;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(HomeBannerImpl.class);
        aemContext.load().json("/com/personalproject/core/models/HomeBanner.json","/component");
    }

    @Test
    void getBio() {
        aemContext.currentResource("/component/homeBanner");
        HomeBanner homeBanner = aemContext.request().adaptTo(HomeBanner.class);
        final String expected="THIS IS ME";
        String actual = homeBanner.getBio();
        assertEquals(expected,actual);
    }

    @Test
    void getFullName() {
        aemContext.currentResource("/component/homeBanner");
        HomeBanner homeBanner = aemContext.request().adaptTo(HomeBanner.class);
        final String expected="PHILIP GILBERT";
        String actual = homeBanner.getFullName();
        assertEquals(expected,actual);
    }

    @Test
    void getIntro() {
        aemContext.currentResource("/component/homeBanner");
        HomeBanner homeBanner = aemContext.request().adaptTo(HomeBanner.class);
        final String expected="You will begin to realise why this exercise is called the Dickens Pattern with reference to the ghost showing Scrooge some different futures.";
        String actual = homeBanner.getIntro();
        assertEquals(expected,actual);
    }

    @Test
    void getMyButton() {
        aemContext.currentResource("/component/homeBanner");
        HomeBanner homeBanner = aemContext.request().adaptTo(HomeBanner.class);
        final String expected="DISCOVER NOW";
        String actual = homeBanner.getMyButton();
        assertEquals(expected,actual);
    }

    @Test
    void getHeroImage() {
        aemContext.currentResource("/component/homeBanner");
        HomeBanner homeBanner = aemContext.request().adaptTo(HomeBanner.class);
        final String expected="/content/dam/personalproject/hero-img.png";
        String actual = homeBanner.getHeroImage();
        assertEquals(expected,actual);
    }

    @Test
    void getPath() {
        aemContext.currentResource("/component/homeBanner");
        HomeBanner homeBanner = aemContext.request().adaptTo(HomeBanner.class);
      
        final String expected="/content/personalproject/us/en/about";
        String actual = homeBanner.getPath();

        assertEquals(expected,actual);
    }
}

