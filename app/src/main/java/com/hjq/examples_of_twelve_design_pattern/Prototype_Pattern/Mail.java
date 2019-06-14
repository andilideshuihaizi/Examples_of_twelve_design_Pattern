package com.hjq.examples_of_twelve_design_pattern.Prototype_Pattern;

/**
 * 要实例化的类
 */
public class Mail implements Cloneable{

    private String subject;
    private String receiver;
    private String content;

    public Mail(MailTemplate mailTemplate){
        this.subject = mailTemplate.getSubject();
        this.content = mailTemplate.getContent();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String sendEmail(){
        return "主题：" + getSubject() + ",收件人：" + getReceiver() + ",内容：" + getContent();
    }

    @Override
    protected Mail clone() throws CloneNotSupportedException {
        return (Mail)super.clone();
    }

    public Mail getCloneClass() throws CloneNotSupportedException {
        return this.clone();
    }
}
