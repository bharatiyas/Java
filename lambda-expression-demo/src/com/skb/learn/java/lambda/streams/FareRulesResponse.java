package com.skb.learn.java.lambda.streams;

import java.util.List;
import java.util.Objects;

public class FareRulesResponse {

    private static final long serialVersionUID = 1L;

    private List<FareRuleEntry> rules;

    public List<FareRuleEntry> getRules() {
        return rules;
    }

    public void setRules(List<FareRuleEntry> rules) {
        this.rules = rules;
    }

    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        } else if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final FareRulesResponse that = (FareRulesResponse) o;
        return Objects.equals(rules, that.rules);
    }

    public int hashCode() {
        return Objects.hash(rules);
    }

    public String toString() {
        final StringBuffer sb = new StringBuffer("FareRulesResponse{");
        sb.append("rules=").append(rules);
        sb.append('}');
        return sb.toString();
    }
}
