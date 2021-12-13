package com.personalproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = Price.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class PriceImpl implements Price{

    @ValueMapValue
    String number;

    @ValueMapValue
    String heading;

    @ValueMapValue
    String title;

    @ValueMapValue
    String tag1;

    @ValueMapValue
    String tag2;

    @ValueMapValue
    String tag3;

    @Override
    public String getNumber() {
        return number;
    }

    @Override
    public String getHeading() {
        return heading;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getTag1() {
        return tag1;
    }

    @Override
    public String getTag2() {
        return tag2;
    }

    @Override
    public String getTag3() {
        return tag3;
    }
}
