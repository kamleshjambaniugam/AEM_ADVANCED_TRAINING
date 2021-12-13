package com.personalproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = MenuNav.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class MenuNavImpl implements MenuNav{

    @ValueMapValue
    String title;

    @ValueMapValue
    String path;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getPath() {
        return path;
    }

}
