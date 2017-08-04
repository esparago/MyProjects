package com.ess.springmvc.domain;

public class Message2 {

    String name;
    String text;
    String extra;
 
    public Message2(String name, String text) {
        this.name = name;
        this.text = text;
        this.extra = "did this make it to Message2?";
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
