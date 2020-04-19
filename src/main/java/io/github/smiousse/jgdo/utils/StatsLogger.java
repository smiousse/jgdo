package io.github.smiousse.jgdo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StatsLogger {

    public enum StatsType {
        DOOR_OPENED, DOOR_CLOSED
    };

    private BolluxClient bolluxClient;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * @param logFile
     */
    public StatsLogger(BolluxClient bolluxClient) {
        this.bolluxClient = bolluxClient;

    }

    /**
     * @param statsType
     * @param value
     * @param deviceIdentifier
     */
    public void log(StatsType statsType, Object value, String deviceIdentifier) {
        this.log(statsType, value, deviceIdentifier, null, new Date(System.currentTimeMillis()));
    }

    /**
     * @param statsType
     * @param value
     * @param info
     * @param extras
     * @param date
     */
    public void log(StatsType statsType, Object value, String deviceIdentifier, String extras, Date date) {
        if (statsType != null && value != null) {
            this.bolluxClient.log(statsType, value, deviceIdentifier, extras, sdf.format(date));
        }
    }

}
