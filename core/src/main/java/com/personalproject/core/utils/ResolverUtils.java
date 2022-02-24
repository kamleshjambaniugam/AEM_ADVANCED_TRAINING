package com.personalproject.core.utils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import java.util.HashMap;
import java.util.Map;
public class ResolverUtils {

    public static final String PROJECT_SERVICE_USER = "kamleshdemo";
    private ResolverUtils(){}
    public static ResourceResolver newResolver( ResourceResolverFactory resourceResolverFactory ) throws LoginException {

        final Map<String, Object> paramMap = new HashMap<>();
        paramMap.put( ResourceResolverFactory.SUBSERVICE, PROJECT_SERVICE_USER );
        // fetches the admin service resolver using service user.

        return resourceResolverFactory.getServiceResourceResolver(paramMap);
    }
}
