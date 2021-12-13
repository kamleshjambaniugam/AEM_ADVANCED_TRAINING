package com.personalproject.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class PriceImplTest {
    private final AemContext aemContext=new AemContext();
    private Price price;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(PriceImpl.class);
        aemContext.load().json("/com/personalproject/core/models/Price.json","/component");
    }

    @Test
    void getNumber() {
        aemContext.currentResource("/component/price");
        Price price = aemContext.request().adaptTo(Price.class);
        final String expected="01";
        String actual = price.getNumber();
        assertEquals(expected,actual);
    }

    @Test
    void getHeading() {
        aemContext.currentResource("/component/price");
        Price price = aemContext.request().adaptTo(Price.class);
        final String expected="Economy";
        String actual = price.getHeading();
        assertEquals(expected,actual);
    }

    @Test
    void getTitle() {
        aemContext.currentResource("/component/price");
        Price price = aemContext.request().adaptTo(Price.class);
        final String expected="For the individuals";
        String actual = price.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getTag1() {
        aemContext.currentResource("/component/price");
        Price price = aemContext.request().adaptTo(Price.class);
        final String expected="Secure Online Transfer";
        String actual = price.getTag1();
        assertEquals(expected,actual);
    }

    @Test
    void getTag2() {
        aemContext.currentResource("/component/price");
        Price price = aemContext.request().adaptTo(Price.class);
        final String expected="Unlimited Styles for interface";
        String actual = price.getTag2();
        assertEquals(expected,actual);
    }

    @Test
    void getTag3() {
        aemContext.currentResource("/component/price");
        Price price = aemContext.request().adaptTo(Price.class);
        final String expected="Reliable Customer Service";
        String actual = price.getTag3();
        assertEquals(expected,actual);
    }
}