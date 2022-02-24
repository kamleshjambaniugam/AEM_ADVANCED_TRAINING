package com.personalproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;


@Model(adaptables = SlingHttpServletRequest.class,
        adapters = HomeBanner.class,
        //resourceType = HomeBannerImpl.RESOURCE_TYPE,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class HomeBannerImpl implements HomeBanner {

    @ValueMapValue
    private String bio;
    @ValueMapValue
    private String fullname;
    @ValueMapValue
    private String intro;
    @ValueMapValue
    private String mybutton;
    @ValueMapValue
    private String pathfield;
    @ValueMapValue
    private String img;
    @Override
    public String getBio() {
        return bio;
    }

    @Override
    public String getFullName() {
        return fullname;
    }

    @Override
    public String getIntro() {
        return intro;
    }

    @Override
    public String getMyButton() {
        return mybutton;
    }

    @Override
    public String getPath() {
        return pathfield;
    }

    @Override
    public String getHeroImage() {
        return img;
    }
}


