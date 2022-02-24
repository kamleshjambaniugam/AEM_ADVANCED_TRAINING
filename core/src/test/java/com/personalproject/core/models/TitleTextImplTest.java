package com.personalproject.core.models;
import com.personalproject.core.models.HomeBannerImpl;
import com.personalproject.core.models.TitleText;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class TitleTextImplTest {

    private final AemContext aemContext=new AemContext();
    private TitleText titleText;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(HomeBannerImpl.class);
        aemContext.load().json("/com/personalproject/core/models/TitleText.json","/component");
    }

    @Test
    void getTitle() {
        aemContext.currentResource("/component/titleText");
        TitleText titleText = aemContext.request().adaptTo(TitleText.class);
        final String expected="My Qualifications";
        String actual = titleText.getTitle();
        assertEquals(expected,actual);
    }

    @Test
    void getInfo() {
        aemContext.currentResource("/component/titleText");
        TitleText titleText = aemContext.request().adaptTo(TitleText.class);
        final String expected="Who are in extremely love with eco friendly system.";
        String actual = titleText.getInfo();
        assertEquals(expected,actual);
    }

    @Test
    void getSectionGap() {
        aemContext.currentResource("/component/titleText");
        TitleText titleText = aemContext.request().adaptTo(TitleText.class);
        final Boolean expected= true;
        Boolean actual = titleText.getSectionGap();
        assertEquals(expected,actual);
    }

    @Test
    void getPaddingBottom() {
        aemContext.currentResource("/component/titleText");
        TitleText titleText = aemContext.request().adaptTo(TitleText.class);
        final Boolean expected= true;
        Boolean actual = titleText.getPaddingBottom();
        assertEquals(expected,actual);
    }

    @Test
    void getTestimonialStyling() {
        aemContext.currentResource("/component/titleText");
        TitleText titleText = aemContext.request().adaptTo(TitleText.class);
        final Boolean expected= false;
        Boolean actual = titleText.getStyling();
        assertEquals(expected,actual);
    }
}