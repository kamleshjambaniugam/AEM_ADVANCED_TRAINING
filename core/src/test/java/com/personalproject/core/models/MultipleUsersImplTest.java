package com.personalproject.core.models;
import com.personalproject.core.models.MultipleUsers;
import com.personalproject.core.models.MultipleUsersImpl;
import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.Assert.assertEquals;
@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class MultipleUsersImplTest {

    private final AemContext aemContext = new AemContext();
    private MultipleUsers multipleUsers;
    @BeforeEach
    void setUp() {

        aemContext.addModelsForClasses(MultipleUsersImpl.class);
//        aemContext.load().json("/com/personalproject/core/models/SingleUser.json","/component");
    }

    @Test
    void getData() throws  Exception{

        multipleUsers = aemContext.request().adaptTo(MultipleUsers.class);
        assertEquals("George", aemContext.registerService(new MultipleUsersImpl()).getData().get(0).get("fname"));
        assertEquals("Bluth", aemContext.registerService(new MultipleUsersImpl()).getData().get(0).get("lname"));
        assertEquals("george.bluth@reqres.in", aemContext.registerService(new MultipleUsersImpl()).getData().get(0).get("email"));
        assertEquals("https://reqres.in/img/faces/1-image.jpg", aemContext.registerService(new MultipleUsersImpl()).getData().get(0).get("avatar"));
    }
}

