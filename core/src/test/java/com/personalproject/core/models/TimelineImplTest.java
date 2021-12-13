package com.personalproject.core.models;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith({AemContextExtension.class, MockitoExtension.class})

class TimelineImplTest {

    private final AemContext aemContext=new AemContext();
    private Timeline timeline;

    @BeforeEach
    void setUp() {
        aemContext.addModelsForClasses(TimelineImpl.class);
        aemContext.load().json("/com/personalproject/core/models/Timeline.json","/component");
    }

    @Test
    void getTimelineDetailsWithMap() {
        aemContext.currentResource("/component/timeline");
        timeline = aemContext.request().adaptTo(Timeline.class);
        assertEquals(5, timeline.getTimelineDetailsWithMap().size());
        assertEquals("Masters in Graphics & Fine Arts", timeline.getTimelineDetailsWithMap().get(0).get("heading"));
        assertEquals("Session: 2010-11", timeline.getTimelineDetailsWithMap().get(0).get("title"));
        assertEquals("Result: 3.78 (In the Scale of 4.00)", timeline.getTimelineDetailsWithMap().get(0).get("text"));
    }
}