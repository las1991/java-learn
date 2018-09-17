package com.las.learn.gof.specification.userExample;

import java.util.ArrayList;
import java.util.List;

public class GeneratedCriteria {
    protected List<Criterion> criteria;

    protected GeneratedCriteria() {
        super();
        criteria = new ArrayList<Criterion>();
    }

    public boolean isValid() {
        return criteria.size() > 0;
    }

    public List<Criterion> getCriteria() {
        return criteria;
    }

    protected void addCriterion(String condition) {
        if (condition == null) {
            throw new RuntimeException("Value for condition cannot be null");
        }
        criteria.add(new Criterion(condition));
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value));
    }

    protected void addCriterion(String condition, Object value1, Object value2, String property) {
        if (value1 == null || value2 == null) {
            throw new RuntimeException("Between values for " + property + " cannot be null");
        }
        criteria.add(new Criterion(condition, value1, value2));
    }

    public Criteria andUserIdIsNull() {
        addCriterion("USER_ID is null");
        return (Criteria) this;
    }

    public Criteria andUserIdEqualTo(Integer value) {
        addCriterion("USER_ID =", value, "userId");
        return (Criteria) this;
    }

    public Criteria andUserIdBetween(Integer value1, Integer value2) {
        addCriterion("USER_ID between", value1, value2, "userId");
        return (Criteria) this;
    }

}
