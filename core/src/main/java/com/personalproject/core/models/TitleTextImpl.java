package com.personalproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = TitleText.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)
public class TitleTextImpl implements TitleText {

//    final protected static String RESOURCE_TYPE = "personalproject/components/content/titletext";

    @ValueMapValue
    String title;

    @ValueMapValue
    String info;

    @ValueMapValue
    boolean sectiongap;

    @ValueMapValue
    boolean paddingbottom;

    @ValueMapValue
    boolean styling;

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getInfo() {
        return info;
    }

    @Override
    public Boolean getSectionGap() {
        return sectiongap;
    }

    @Override
    public Boolean getPaddingBottom() {
        return paddingbottom;
    }

    @Override
    public Boolean getStyling() {
        return styling;
    }

}