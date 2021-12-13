package com.personalproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = BlogTeaser.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class BlogTeaserImpl implements BlogTeaser{

    @ValueMapValue
    String img;

    @ValueMapValue
    String title;

    @ValueMapValue
    String description;

    @Override
    public String getImage() {
        return img;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
