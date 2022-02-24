package com.personalproject.core.models;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class FactAreaImplTest {

    private final AemContext aemContext=new AemContext();
    private FactArea factArea;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(FactAreaImpl.class);
        aemContext.load().json("/com/personalproject/core/models/FactArea.json","/component");
    }

    @Test
    void getFactDetailsWithMap() {
        aemContext.currentResource("/component/factArea");
        factArea = aemContext.request().adaptTo(FactArea.class);
        assertEquals(4, factArea.getFactDetailsWithMap().size());
        assertEquals("2536", factArea.getFactDetailsWithMap().get(0).get("factnumber"));
        assertEquals("Projects Completed", factArea.getFactDetailsWithMap().get(0).get("factlabel"));
    }
}