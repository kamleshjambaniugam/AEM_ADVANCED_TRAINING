package com.personalproject.core.models;
import com.personalproject.core.services.OSGiConfigImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class OSGiConfigDemoImplTest {

    private final AemContext aemContext=new AemContext();
    private OSGiConfigImpl osgiConfig;
    private String[] countries = {"de","en"};
    @BeforeEach
    void setUp() throws NoSuchFieldException {
        osgiConfig = aemContext.registerService(new OSGiConfigImpl());
        OSGiConfigImpl.ServiceConfig serviceConfig = mock(OSGiConfigImpl.ServiceConfig.class);
        when(serviceConfig.serviceName()).thenReturn("Demo Service");
        when(serviceConfig.getRunMode()).thenReturn("author");
        when(serviceConfig.getServiceCount()).thenReturn(0);
        when(serviceConfig.getLiveData()).thenReturn(false);
        when(serviceConfig.getCountries()).thenReturn(countries);
        osgiConfig.activate(serviceConfig);
    }

    @Test
    void getServiceName() {
        OSGiConfigDemo osgiConfigDemo = aemContext.request().adaptTo(OSGiConfigDemo.class);
        assertEquals("Demo Service", osgiConfigDemo.getServiceName());
    }

    @Test
    void getServiceCount() {
        OSGiConfigDemo osgiConfigDemo = aemContext.request().adaptTo(OSGiConfigDemo.class);
        assertEquals(0, osgiConfigDemo.getServiceCount());
    }

    @Test
    void isLiveData() {
        OSGiConfigDemo osgiConfigDemo = aemContext.request().adaptTo(OSGiConfigDemo.class);
        assertEquals(false, osgiConfigDemo.isLiveData());
    }

    @Test
    void getCountries() {
        OSGiConfigDemo osgiConfigDemo = aemContext.request().adaptTo(OSGiConfigDemo.class);
        assertEquals(countries, osgiConfigDemo.getCountries());
    }

    @Test
    void getRunModes() {
        OSGiConfigDemo osgiConfigDemo = aemContext.request().adaptTo(OSGiConfigDemo.class);
        assertEquals("author", osgiConfigDemo.getRunModes());
    }
}