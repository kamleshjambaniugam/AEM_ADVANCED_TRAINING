package com.personalproject.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Model(
        adaptables = SlingHttpServletRequest.class,
        adapters = Brands.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

public class BrandsImpl implements Brands{

    private static final Logger LOG = LoggerFactory.getLogger(BrandsImpl.class);


    @ValueMapValue
    private List<String> path;

//    @Inject
//    Resource componentResource;

    @Override
    public List<String> getPathField() {
        if (path != null) {
            return new ArrayList<String>(path);
        } else {
            return Collections.emptyList();
        }
    }

}
