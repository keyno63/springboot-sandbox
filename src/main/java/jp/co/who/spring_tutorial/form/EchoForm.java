package jp.co.who.spring_tutorial.form;

import java.io.Serializable;

public class EchoForm implements Serializable {

    private static final long serialVersionID = 1L;
    private String text;
    private boolean bool;
    private String errText;

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public boolean getBool() { return bool; }
    public void setBool(boolean bool) { this.bool = bool; }
    public String getErrText() { return this.errText; }
    public void setErrText(String errText) { this.errText = errText; }
}
