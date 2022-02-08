package com.personalproject.core.models;
import com.day.cq.commons.date.DateUtil;
import com.day.cq.replication.*;
import com.personalproject.core.utils.ResolverUtils;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.Session;
import java.util.Calendar;
@Component(
        immediate = true
)
public class PreprocessorImpl implements Preprocessor {
    public static final Logger LOG = LoggerFactory.getLogger(PreprocessorImpl.class);
    @Reference
    private ResourceResolverFactory resourceResolverFactory;
    @Reference
    DisplayDate displayDate;
    String path1 = "/content/personalproject/us/en/scheduler-page/jcr:content/root/container/container/displaydate";
    @Override
    public void preprocess(ReplicationAction replicationAction, ReplicationOptions replicationOptions) throws ReplicationException {
        LOG.info("\nInside Method");
        if (replicationAction == null || !ReplicationActionType.ACTIVATE.equals(replicationAction.getType())) {
            return;
        }
        String path = replicationAction.getPath();
        if(path.equals("/content/personalproject/us/en/scheduler-page")){
            LOG.debug("\npath equal");
            try {
                ResourceResolver resourceResolver = ResolverUtils.newResolver(resourceResolverFactory);
                Session session = resourceResolver.adaptTo(Session.class);
                Resource resource = resourceResolver.getResource(path1);
                Node node = resource.adaptTo(Node.class);
                Property date = node.getProperty("NewTime");
                if(date == DateUtil.parseISO8601(DateUtil.getISO8601Date(Calendar.getInstance()))){
                    LOG.info("\nINSIDE IF");
                }else{
                    LOG.info("\nINSIDE ELSE");
                    displayDate.displayDate(path1);
                    session.save();
                    session.logout();
                }
                LOG.debug(path);
            } catch (Exception e) {
                LOG.info(e.getMessage());
            }
        }

    }
}