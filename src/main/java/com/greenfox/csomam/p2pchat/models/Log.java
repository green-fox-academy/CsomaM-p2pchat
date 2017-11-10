package com.greenfox.csomam.p2pchat.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String path;
    private String method;
    private String dateAndTime;
    private String logLevel;
    private String requestData;

    public Log() {
        System.getenv();
    }

    public Log(String path, String method, String dateAndTime, String logLevel, String requestData) {
        this.path = path;
        this.method = method;
        this.dateAndTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.logLevel = logLevel;
        this.requestData = requestData;
    }
}
