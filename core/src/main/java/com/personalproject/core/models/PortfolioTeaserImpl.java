package com.personalproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = PortfolioTeaser.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class PortfolioTeaserImpl implements PortfolioTeaser{

    @ValueMapValue
    String img;

    @ValueMapValue
    String title;

    @ValueMapValue
    String type;

    @Override
    public String getImage() {
        return img;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getType() {
        return type;
    }
}
