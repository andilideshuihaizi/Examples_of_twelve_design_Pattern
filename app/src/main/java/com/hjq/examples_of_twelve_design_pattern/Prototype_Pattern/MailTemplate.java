package com.hjq.examples_of_twelve_design_pattern.Prototype_Pattern;

/**
 * 模板类，在这个例子中辅助作用：
 */
public class MailTemplate {

    private String subject;
    private String content;

    public MailTemplate(String subject, String content) {
        this.subject = subject;
        this.content = content;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
