package com.personalproject.core.schedulers;
import com.personalproject.core.config.SchedulerConfiguration;
import com.personalproject.core.models.DisplayDate;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.scheduler.ScheduleOptions;
import org.apache.sling.commons.scheduler.Scheduler;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Component(immediate = true, service = Runnable.class)
@Designate(ocd = SchedulerConfiguration.class)
public class PersonalScheduler implements Runnable {

    private static final Logger LOG = LoggerFactory.getLogger(PersonalScheduler.class);
    private int schedulerId;
    @Reference
    ResourceResolverFactory resourceResolverFactory;
    @Reference
    private Scheduler scheduler;
    @Reference
    DisplayDate displayDate;
    String path= "/content/personalproject/us/en/scheduler-page/jcr:content/root/container/container/displaydate";
    @Activate
    protected void activate(SchedulerConfiguration config) {
        schedulerId = config.schedulerName().hashCode();
        addScheduler(config);
    }

    @Deactivate
    protected void deactivate(SchedulerConfiguration config) {
        removeScheduler();
    }

    private void removeScheduler() {
        scheduler.unschedule(String.valueOf(schedulerId));
    }

    private void addScheduler(SchedulerConfiguration config) {
        ScheduleOptions scheduleOptions = scheduler.EXPR(config.cronExpression());
        scheduleOptions.name(String.valueOf(schedulerId));
        scheduleOptions.canRunConcurrently(true);
        scheduler.schedule(this, scheduleOptions);
        LOG.info("\n ---------Scheduler added----------");
        ScheduleOptions scheduleOptionsNow = scheduler.NOW(3,5);
        scheduler.schedule(this, scheduleOptionsNow);
    }
    @Override
    public void run() {
        LOG.info("\n ---------RUN METHOD EXECUTING----------");
        displayDate.displayDate(path);
    }
}