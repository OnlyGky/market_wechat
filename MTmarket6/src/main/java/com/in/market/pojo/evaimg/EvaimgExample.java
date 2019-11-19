package com.in.market.pojo.evaimg;

import java.util.ArrayList;
import java.util.List;

public class EvaimgExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaimgExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
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

        public Criteria andEvaimgIdIsNull() {
            addCriterion("evaimg_id is null");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdIsNotNull() {
            addCriterion("evaimg_id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdEqualTo(Integer value) {
            addCriterion("evaimg_id =", value, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdNotEqualTo(Integer value) {
            addCriterion("evaimg_id <>", value, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdGreaterThan(Integer value) {
            addCriterion("evaimg_id >", value, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("evaimg_id >=", value, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdLessThan(Integer value) {
            addCriterion("evaimg_id <", value, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdLessThanOrEqualTo(Integer value) {
            addCriterion("evaimg_id <=", value, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdIn(List<Integer> values) {
            addCriterion("evaimg_id in", values, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdNotIn(List<Integer> values) {
            addCriterion("evaimg_id not in", values, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdBetween(Integer value1, Integer value2) {
            addCriterion("evaimg_id between", value1, value2, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("evaimg_id not between", value1, value2, "evaimgId");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameIsNull() {
            addCriterion("evaimg_name is null");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameIsNotNull() {
            addCriterion("evaimg_name is not null");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameEqualTo(String value) {
            addCriterion("evaimg_name =", value, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameNotEqualTo(String value) {
            addCriterion("evaimg_name <>", value, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameGreaterThan(String value) {
            addCriterion("evaimg_name >", value, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameGreaterThanOrEqualTo(String value) {
            addCriterion("evaimg_name >=", value, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameLessThan(String value) {
            addCriterion("evaimg_name <", value, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameLessThanOrEqualTo(String value) {
            addCriterion("evaimg_name <=", value, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameLike(String value) {
            addCriterion("evaimg_name like", value, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameNotLike(String value) {
            addCriterion("evaimg_name not like", value, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameIn(List<String> values) {
            addCriterion("evaimg_name in", values, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameNotIn(List<String> values) {
            addCriterion("evaimg_name not in", values, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameBetween(String value1, String value2) {
            addCriterion("evaimg_name between", value1, value2, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaimgNameNotBetween(String value1, String value2) {
            addCriterion("evaimg_name not between", value1, value2, "evaimgName");
            return (Criteria) this;
        }

        public Criteria andEvaIsNull() {
            addCriterion("eva is null");
            return (Criteria) this;
        }

        public Criteria andEvaIsNotNull() {
            addCriterion("eva is not null");
            return (Criteria) this;
        }

        public Criteria andEvaEqualTo(Integer value) {
            addCriterion("eva =", value, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaNotEqualTo(Integer value) {
            addCriterion("eva <>", value, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaGreaterThan(Integer value) {
            addCriterion("eva >", value, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaGreaterThanOrEqualTo(Integer value) {
            addCriterion("eva >=", value, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaLessThan(Integer value) {
            addCriterion("eva <", value, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaLessThanOrEqualTo(Integer value) {
            addCriterion("eva <=", value, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaIn(List<Integer> values) {
            addCriterion("eva in", values, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaNotIn(List<Integer> values) {
            addCriterion("eva not in", values, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaBetween(Integer value1, Integer value2) {
            addCriterion("eva between", value1, value2, "eva");
            return (Criteria) this;
        }

        public Criteria andEvaNotBetween(Integer value1, Integer value2) {
            addCriterion("eva not between", value1, value2, "eva");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}