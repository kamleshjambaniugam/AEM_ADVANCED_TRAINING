package com.personalproject.core.models;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class BrandsImplTest {

    private final AemContext aemContext=new AemContext();
    private Brands brands;
    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(BlogTeaserImpl.class);
        aemContext.load().json("/com/personalproject/core/models/Brands.json","/component");
    }

    @Test
    void getPathField() {
        aemContext.currentResource("/component/brands");
        Brands brands = aemContext.request().adaptTo(Brands.class);
        final List<String> expected = new ArrayList<String>();
        expected.add("/content/dam/personalproject/l1.png");
        expected.add("/content/dam/personalproject/l2.png");
        expected.add("/content/dam/personalproject/l3.png");
        expected.add("/content/dam/personalproject/l4.png");
        expected.add("/content/dam/personalproject/l5.png");
        List<String> actual = brands.getPathField();
        assertEquals(expected,actual);
    }
}