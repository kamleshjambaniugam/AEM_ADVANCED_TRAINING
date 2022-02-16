package com.personalproject.core.config;
import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;
@Configuration(label = "Personal - Context aware configuration", description = "Context Aware Configuration for Personal Project")

public @interface PersonalCAConfig {

    @Property(label = "Personal Country Name",
            description ="Personal Site Name")
    String siteCountry() default "us";
    @Property(label = "Personal Site Locale",
            description ="Personal Site for different languages")
    String siteLocale() default "en";
    @Property(label = "Personal Site Admin",
            description ="Admin for updating DynamicCountry site")
    String siteAdmin() default "personal-project";
    @Property(label = "Site Section",
            description ="Site Section for Personal Site")
    String siteSection() default "personal";


}