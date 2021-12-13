package com.personalproject.core.models.impl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.personalproject.core.models.BlogTeaser;


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
