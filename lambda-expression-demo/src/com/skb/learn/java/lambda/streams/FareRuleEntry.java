package com.skb.learn.java.lambda.streams;

import java.util.Objects;

public class FareRuleEntry {

    private static final long serialVersionUID = 1L;

    private String number;
    private String text;

    public FareRuleEntry() {

    }

    public FareRuleEntry(String number, String text) {
        this.number = number;
        this.text = text;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FareRuleEntry that = (FareRuleEntry) o;
        return Objects.equals(number, that.number)
                && Objects.equals(text, that.text);
    }

    public int hashCode() {
        return Objects.hash(number, text);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("FareRuleEntry{");
        sb.append("number='").append(number).append('\'');
        sb.append(", text='").append(text).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
