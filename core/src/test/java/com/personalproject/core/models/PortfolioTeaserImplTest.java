package com.personalproject.core.models;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class PortfolioTeaserImplTest {

    private final AemContext aemContext=new AemContext();
    private PortfolioTeaser portfolioTeaser;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(PortfolioTeaserImpl.class);
        aemContext.load().json("/com/personalproject/core/models/Portfolio.json","/component");
    }

    @Test
    void getImage() {
        aemContext.currentResource("/component/portfolio");
        PortfolioTeaser portfolioTeaser = aemContext.request().adaptTo(PortfolioTeaser.class);
        final String expected="/content/dam/personalproject/p1.jpg";
        String actual = portfolioTeaser.getImage();
        assertEquals(expected,actual);
    }

    @Test
    void getTitle() {
        aemContext.currentResource("/component/portfolio");
        PortfolioTeaser portfolioTeaser = aemContext.request().adaptTo(PortfolioTeaser.class);
        final String expected="2D Vinyl Design";
        String actual = portfolioTeaser.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getType() {
        aemContext.currentResource("/component/portfolio");
        PortfolioTeaser portfolioTeaser = aemContext.request().adaptTo(PortfolioTeaser.class);
        final String expected="vector";
        String actual = portfolioTeaser.getType();
        assertEquals(expected,actual);
    }
}