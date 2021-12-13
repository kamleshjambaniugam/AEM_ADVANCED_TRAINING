package com.personalproject.core.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.inject.Inject;

@Model(
        adaptables = SlingHttpServletRequest.class,
        resourceType = HomeAboutImpl.RESOURCE_TYPE,
        adapters = HomeAbout.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = "jackson",extensions = "json", selector = "personal")

public class HomeAboutImpl implements HomeAbout {

//    final protected static String RESOURCE_TYPE = "personalproject/components/content/homeabout";

    static final String RESOURCE_TYPE="personalproject/components/content/homeabout";

    @Inject
    Resource resource;

    @Inject
    @Via("resource")
    String about;

    @Inject
    @Via("resource")
    String details;

    @ValueMapValue
    String intro;

    @ValueMapValue
    String mybutton;

    @ValueMapValue
    String img;

    @ValueMapValue
    String pathfield;

    @JsonProperty(value = "homeabout-details")
    public String details() {
        return "DETAILS:";
    }

    @Override
    public String getAbout() {
        return about;
    }

    @Override
    public String getDetails() {
        return details;
    }

    @Override
    public String getIntro() {
        return intro;
    }

    @JsonProperty(value = "title")
    @Override
    public String getButtonTitle() {
        return mybutton;
    }

    @Override
    public String getAboutImage() {
        return img;
    }

    @Override
    public String getPath() {
        return pathfield;
    }
}