package com.greenfox.csomam.p2pchat.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
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
    }

    public Log(HttpServletRequest request) {
        this.path = request.getServletPath();
        this.method = request.getMethod();
        this.dateAndTime = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        this.logLevel = System.getenv("CHAT_APP_LOGLEVEL");
        this.requestData = request.getQueryString();
    }

    public String toString() {
        return dateAndTime + " " + logLevel + " " + path + " " + method + " " + requestData;
    }
}
