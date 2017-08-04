package com.ess.springmvc.domain;

public class Message {

    String name;
    String text;
    String extra;
 
    public Message(String name, String text) {
        this.name = name;
        this.text = text;
        this.extra = "did this make it?";
    }
 
    public String getName() {
        return name;
    }
 
    public String getText() {
        return text;
    }
    
    public String getExtra() {
    	return extra;
    }
 

}
