package com.kxj.hrserver.bean;

import java.util.Date;

/**
 * @ClassName ChatMsg
 * @Description TODO
 * @Author kxj
 * @Date 2020/2/29 23:06
 * @Version 1.0
 **/
public class ChatMsg {

    private String from;

    private String to;

    private String content;

    private Date date;

    private String fromNickname;


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }
}
