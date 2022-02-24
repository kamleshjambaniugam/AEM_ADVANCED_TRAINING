package com.personalproject.core.models;
import com.personalproject.core.config.PersonalCAConfig;
import com.day.cq.wcm.api.Page;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import junitx.util.PrivateAccessor;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.testing.mock.sling.ResourceResolverType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})
class CAConfigImplTest {
    AemContext aemContext = new AemContext(ResourceResolverType.JCR_MOCK);
    CAConfigImpl caConfig;
    Page currentPage ;
    ResourceResolver resourceResolver = mock(ResourceResolver.class);
    Resource contentResource = mock(Resource.class);
    ConfigurationBuilder configurationBuilder = mock(ConfigurationBuilder.class);
    private String siteCountry;
    private String siteAdmin;
    private String siteSection;
    private String siteLocale;
    @BeforeEach
    void setUp() throws NoSuchFieldException {
        caConfig=aemContext.registerService(new CAConfigImpl());
        PersonalCAConfig personalCAConfig = mock(PersonalCAConfig.class);
        lenient().when(personalCAConfig.siteAdmin()).thenReturn("personalproject");
        lenient().when(personalCAConfig.siteCountry()).thenReturn("us");
        lenient().when(personalCAConfig.siteSection()).thenReturn("personal");
        lenient().when(personalCAConfig.siteLocale()).thenReturn("en");
        currentPage = aemContext.create().page("/content/personalproject/us/en");
        String currentPath = "/content/personalproject/us/en";
        PrivateAccessor.setField(caConfig,"currentPage",currentPage);
        PrivateAccessor.setField(caConfig,"resourceResolver",resourceResolver);
        when(resourceResolver.getResource(currentPath)).thenReturn(contentResource);
        when(contentResource.adaptTo(ConfigurationBuilder.class)).thenReturn(configurationBuilder);
        //PrivateAccessor.setField(caConfig,"currentPage",currentPath);
        when(configurationBuilder.as(PersonalCAConfig.class)).thenReturn(personalCAConfig);
        caConfig.postConstruct();
    }
    @Test
    void getSiteCountry() {
        assertEquals("us",caConfig.getSiteCountry());
    }

    @Test
    void getSiteAdmin() {
        assertEquals("personalproject",caConfig.getSiteAdmin());
    }

    @Test
    void getSiteSection() {
        assertEquals("personal",caConfig.getSiteSection());
    }

    @Test
    void getSiteLocale() {
        assertEquals("en",caConfig.getSiteLocale());
    }
}