package io.github.smiousse.jgdo.utils;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import au.com.bytecode.opencsv.CSVWriter;
import io.github.smiousse.jgdo.utils.StatsLogger.StatsType;

public class StatscsvLogger {

    private CSVWriter writer;
    private int count = 0;

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

    /**
     * @param logFile
     */
    public StatscsvLogger(File logFile) {
        this.init(logFile);
    }

    /**
     * @param logFile
     */
    private void init(File logFile) {
        try {
            writer = new CSVWriter(new FileWriter(logFile, true));
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * @param statsType
     * @param value
     * @param info
     */
    public void log(StatsType statsType, Object value, String info) {
        this.log(statsType, value, info, null, new Date(System.currentTimeMillis()));
    }

    /**
     * @param statsType
     * @param value
     * @param info
     * @param extras
     */
    public void log(StatsType statsType, Object value, String info, String extras) {
        this.log(statsType, value, extras, null, new Date(System.currentTimeMillis()));
    }

    /**
     * @param statsType
     * @param value
     * @param info
     * @param extras
     * @param date
     */
    public void log(StatsType statsType, Object value, String info, String extras, Date date) {
        if (statsType != null && value != null) {
            writer.writeNext(new String[] { statsType.toString(), value.toString(), info, sdf.format(date), extras });
            if (count % 100 == 0) {
                try {
                    writer.flush();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 
     */
    public void dispose() {
        if (writer != null) {
            try {
                writer.flush();
                writer.close();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
