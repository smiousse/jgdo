package io.github.smiousse.jgdo.services;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasterControllerJob implements Job {

    private static final Logger log = LoggerFactory.getLogger(MasterControllerJob.class);
    private static MasterController master;

    static {
        master = new MasterController();

    }

    @Override
    public void execute(JobExecutionContext paramJobExecutionContext) throws JobExecutionException {

        log.trace("MasterControllerJob execute");
        // master.refreshSettings();

    }

}
