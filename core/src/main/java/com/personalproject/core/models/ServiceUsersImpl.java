package com.personalproject.core.models;



import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.personalproject.core.utils.ResolverUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



@Model(adaptables = SlingHttpServletRequest.class,
        adapters = ServiceUsers.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL
)



public class ServiceUsersImpl implements ServiceUsers {



    private static final Logger LOG= LoggerFactory.getLogger(ServiceUsersImpl.class);




    @SlingObject
    ResourceResolver resolver;



    @Inject
    QueryBuilder queryBuilder;



    @OSGiService
    ResourceResolverFactory resourceResolverFactory;



    String eachUser = " ";



    @PostConstruct
    protected void init(){
        LOG.info("\n ========Printing Logs========");
    }



    @Override
    public String getServiceUsers() throws RepositoryException {



        List<String> usernames = new ArrayList<>();
        Map<String, String> userMap = new HashMap<>();
        userMap.put("p.hits", "selective");
        userMap.put("p.limit", "-1");
        userMap.put("property", "jcr:primaryType");
        userMap.put("property.value", "rep:SystemUser");
        userMap.put("path", "/home/users/system");
        userMap.put("type", "rep:User");
        userMap.put("p.properties", "rep:principalName");



        try(ResourceResolver serviceResourceResolver = ResolverUtils.newResolver(resourceResolverFactory)){



            LOG.info("\n Inside Try Block..");
            Session session = serviceResourceResolver.adaptTo(Session.class);
            Query userQuery = queryBuilder.createQuery(PredicateGroup.create(userMap), session);
            SearchResult result = userQuery.getResult();
            List<Hit> Hits = result.getHits();
            for (Hit hit : Hits) {
                eachUser = eachUser + "\r\n" + hit.getProperties().get("rep:principalName", String.class);
            }
        } catch (RepositoryException e) {
            LOG.info("ERROR : ",e.getMessage());
        }
        catch (LoginException e) {
            e.printStackTrace();
        }
        return eachUser;
    }
}