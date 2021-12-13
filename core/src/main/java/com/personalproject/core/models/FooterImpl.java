package com.personalproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = Footer.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class FooterImpl implements Footer{


    @ValueMapValue
    String title;

    @ValueMapValue
    String description;

    @ValueMapValue
    String title1;

    @ValueMapValue
    String description1;

    @ValueMapValue
    String email;

    @ValueMapValue
    String title2;

    @ValueMapValue
    String description2;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getTitle1() {
        return title1;
    }

    @Override
    public String getDescription1() {
        return description1;
    }

    @Override
    public String getTitle2() {
        return title2;
    }

    @Override
    public String getDescription2() {
        return description2;
    }
}
