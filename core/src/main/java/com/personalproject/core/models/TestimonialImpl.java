package com.personalproject.core.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Model(
        adaptables = SlingHttpServletRequest.class,
        resourceType = TestimonialImpl.RESOURCE_TYPE,
        adapters = Testimonial.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)

@Exporter(name = "jackson",extensions = "json", selector = "personal")

public class TestimonialImpl implements Testimonial {

    static final String RESOURCE_TYPE="personalproject/components/content/testimonial";

    private static final Logger LOG = LoggerFactory.getLogger(TestimonialImpl.class);

    @ChildResource
    Resource testimonialdetailswithmap;

    @JsonProperty(value = "testimonial-details")
    @Override
    public List<Map<String, String>> getTestimonialDetailsWithMap() {


        List<Map<String, String>> testimonialDetailsMap=new ArrayList<>();
        try {
//            Resource testimonialDetail=componentResource.getChild("testimonialdetailswithmap");
            if(testimonialdetailswithmap!=null){
                for (Resource testimonial : testimonialdetailswithmap.getChildren()) {
                    Map<String,String> testimonialMap=new HashMap<>();
                    testimonialMap.put("description",testimonial.getValueMap().get("description",String.class));
                    testimonialMap.put("heading",testimonial.getValueMap().get("heading",String.class));
                    testimonialMap.put("title",testimonial.getValueMap().get("title",String.class));
                    testimonialDetailsMap.add(testimonialMap);
                }
            }
        }catch (Exception e){
            LOG.info("\n ERROR while getting Fact Details {} ",e.getMessage());
        }

        LOG.info("\n SIZE {} ",testimonialDetailsMap.size());
        return testimonialDetailsMap;
    }
}
