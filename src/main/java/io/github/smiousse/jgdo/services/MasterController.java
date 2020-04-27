package io.github.smiousse.jgdo.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.github.smiousse.jgdo.utils.ApplicationPropertyManager;
import io.github.smiousse.jgdo.utils.BolluxClient;

public class MasterController {

    private static final Logger log = LoggerFactory.getLogger(MasterController.class);

    private BolluxClient bolluxClient;

    public MasterController() {
        this.bolluxClient = new BolluxClient(ApplicationPropertyManager.getApplicationPropertyValue("bollux.server.url"));

    }

    /**
     * 
     */
    public void dispose() {
        bolluxClient.dispose();

    }

}
