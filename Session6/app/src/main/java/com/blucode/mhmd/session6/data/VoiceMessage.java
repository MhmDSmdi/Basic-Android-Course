package com.blucode.mhmd.session6.data;

import java.util.Date;

public class VoiceMessage {

    private String bodyMessage;
    private Date time;
    private String path;

    public VoiceMessage(String bodyMessage, Date time, String path) {
        this.bodyMessage = bodyMessage;
        this.time = time;
        this.path = path;
    }

    public String getBodyMessage() {
        return bodyMessage;
    }

    public void setBodyMessage(String bodyMessage) {
        this.bodyMessage = bodyMessage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
