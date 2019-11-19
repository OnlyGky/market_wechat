package com.in.market.pojo.evaluate;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class EvaluateExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EvaluateExample() {
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

//        protected void addCriterionForJDBCDate(String condition, String value, String property) {
//            if (value == null) {
//                throw new RuntimeException("Value for " + property + " cannot be null");
//            }
//            addCriterion(condition, new java.sql.Date(value.getTime()), property);
//        }
//
//        protected void addCriterionForJDBCDate(String condition, List<String> values, String property) {
//            if (values == null || values.size() == 0) {
//                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
//            }
//            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
//            Iterator<Date> iter = values.iterator();
//            while (iter.hasNext()) {
//                dateList.add(new java.sql.Date(iter.next().getTime()));
//            }
//            addCriterion(condition, dateList, property);
//        }

//        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
//            if (value1 == null || value2 == null) {
//                throw new RuntimeException("Between values for " + property + " cannot be null");
//            }
//            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
//        }
//
//        public Criteria andEvaIdIsNull() {
//            addCriterion("eva_Id is null");
//            return (Criteria) this;
//        }

        public Criteria andEvaIdIsNotNull() {
            addCriterion("eva_Id is not null");
            return (Criteria) this;
        }

        public Criteria andEvaIdEqualTo(Integer value) {
            addCriterion("eva_Id =", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdNotEqualTo(Integer value) {
            addCriterion("eva_Id <>", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdGreaterThan(Integer value) {
            addCriterion("eva_Id >", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("eva_Id >=", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdLessThan(Integer value) {
            addCriterion("eva_Id <", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdLessThanOrEqualTo(Integer value) {
            addCriterion("eva_Id <=", value, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdIn(List<Integer> values) {
            addCriterion("eva_Id in", values, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdNotIn(List<Integer> values) {
            addCriterion("eva_Id not in", values, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdBetween(Integer value1, Integer value2) {
            addCriterion("eva_Id between", value1, value2, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("eva_Id not between", value1, value2, "evaId");
            return (Criteria) this;
        }

        public Criteria andEvaUserIsNull() {
            addCriterion("eva_User is null");
            return (Criteria) this;
        }

        public Criteria andEvaUserIsNotNull() {
            addCriterion("eva_User is not null");
            return (Criteria) this;
        }

        public Criteria andEvaUserEqualTo(Integer value) {
            addCriterion("eva_User =", value, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserNotEqualTo(Integer value) {
            addCriterion("eva_User <>", value, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserGreaterThan(Integer value) {
            addCriterion("eva_User >", value, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("eva_User >=", value, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserLessThan(Integer value) {
            addCriterion("eva_User <", value, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserLessThanOrEqualTo(Integer value) {
            addCriterion("eva_User <=", value, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserIn(List<Integer> values) {
            addCriterion("eva_User in", values, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserNotIn(List<Integer> values) {
            addCriterion("eva_User not in", values, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserBetween(Integer value1, Integer value2) {
            addCriterion("eva_User between", value1, value2, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaUserNotBetween(Integer value1, Integer value2) {
            addCriterion("eva_User not between", value1, value2, "evaUser");
            return (Criteria) this;
        }

        public Criteria andEvaContentIsNull() {
            addCriterion("eva_Content is null");
            return (Criteria) this;
        }

        public Criteria andEvaContentIsNotNull() {
            addCriterion("eva_Content is not null");
            return (Criteria) this;
        }

        public Criteria andEvaContentEqualTo(String value) {
            addCriterion("eva_Content =", value, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentNotEqualTo(String value) {
            addCriterion("eva_Content <>", value, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentGreaterThan(String value) {
            addCriterion("eva_Content >", value, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentGreaterThanOrEqualTo(String value) {
            addCriterion("eva_Content >=", value, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentLessThan(String value) {
            addCriterion("eva_Content <", value, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentLessThanOrEqualTo(String value) {
            addCriterion("eva_Content <=", value, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentLike(String value) {
            addCriterion("eva_Content like", value, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentNotLike(String value) {
            addCriterion("eva_Content not like", value, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentIn(List<String> values) {
            addCriterion("eva_Content in", values, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentNotIn(List<String> values) {
            addCriterion("eva_Content not in", values, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentBetween(String value1, String value2) {
            addCriterion("eva_Content between", value1, value2, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaContentNotBetween(String value1, String value2) {
            addCriterion("eva_Content not between", value1, value2, "evaContent");
            return (Criteria) this;
        }

        public Criteria andEvaDateIsNull() {
            addCriterion("eva_Date is null");
            return (Criteria) this;
        }

        public Criteria andEvaDateIsNotNull() {
            addCriterion("eva_Date is not null");
            return (Criteria) this;
        }

//        public Criteria andEvaDateEqualTo(Date value) {
//            addCriterionForJDBCDate("eva_Date =", value, "evaDate");
//            return (Criteria) this;
//        }

//        public Criteria andEvaDateNotEqualTo(Date value) {
//            addCriterionForJDBCDate("eva_Date <>", value, "evaDate");
//            return (Criteria) this;
//        }

//        public Criteria andEvaDateGreaterThan(Date value) {
//            addCriterionForJDBCDate("eva_Date >", value, "evaDate");
//            return (Criteria) this;
//        }
//
//        public Criteria andEvaDateGreaterThanOrEqualTo(Date value) {
//            addCriterionForJDBCDate("eva_Date >=", value, "evaDate");
//            return (Criteria) this;
//        }
//
//        public Criteria andEvaDateLessThan(Date value) {
//            addCriterionForJDBCDate("eva_Date <", value, "evaDate");
//            return (Criteria) this;
//        }
//
//        public Criteria andEvaDateLessThanOrEqualTo(Date value) {
//            addCriterionForJDBCDate("eva_Date <=", value, "evaDate");
//            return (Criteria) this;
//        }
//
//        public Criteria andEvaDateIn(List<Date> values) {
//            addCriterionForJDBCDate("eva_Date in", values, "evaDate");
//            return (Criteria) this;
//        }
//
//        public Criteria andEvaDateNotIn(List<Date> values) {
//            addCriterionForJDBCDate("eva_Date not in", values, "evaDate");
//            return (Criteria) this;
//        }
//
//        public Criteria andEvaDateBetween(Date value1, Date value2) {
//            addCriterionForJDBCDate("eva_Date between", value1, value2, "evaDate");
//            return (Criteria) this;
//        }
//
//        public Criteria andEvaDateNotBetween(Date value1, Date value2) {
//            addCriterionForJDBCDate("eva_Date not between", value1, value2, "evaDate");
//            return (Criteria) this;
//        }

        public Criteria andEvaGoodsIsNull() {
            addCriterion("eva_Goods is null");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsIsNotNull() {
            addCriterion("eva_Goods is not null");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsEqualTo(Integer value) {
            addCriterion("eva_Goods =", value, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsNotEqualTo(Integer value) {
            addCriterion("eva_Goods <>", value, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsGreaterThan(Integer value) {
            addCriterion("eva_Goods >", value, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsGreaterThanOrEqualTo(Integer value) {
            addCriterion("eva_Goods >=", value, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsLessThan(Integer value) {
            addCriterion("eva_Goods <", value, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsLessThanOrEqualTo(Integer value) {
            addCriterion("eva_Goods <=", value, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsIn(List<Integer> values) {
            addCriterion("eva_Goods in", values, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsNotIn(List<Integer> values) {
            addCriterion("eva_Goods not in", values, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsBetween(Integer value1, Integer value2) {
            addCriterion("eva_Goods between", value1, value2, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaGoodsNotBetween(Integer value1, Integer value2) {
            addCriterion("eva_Goods not between", value1, value2, "evaGoods");
            return (Criteria) this;
        }

        public Criteria andEvaStateIsNull() {
            addCriterion("eva_State is null");
            return (Criteria) this;
        }

        public Criteria andEvaStateIsNotNull() {
            addCriterion("eva_State is not null");
            return (Criteria) this;
        }

        public Criteria andEvaStateEqualTo(Integer value) {
            addCriterion("eva_State =", value, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateNotEqualTo(Integer value) {
            addCriterion("eva_State <>", value, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateGreaterThan(Integer value) {
            addCriterion("eva_State >", value, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("eva_State >=", value, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateLessThan(Integer value) {
            addCriterion("eva_State <", value, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateLessThanOrEqualTo(Integer value) {
            addCriterion("eva_State <=", value, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateIn(List<Integer> values) {
            addCriterion("eva_State in", values, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateNotIn(List<Integer> values) {
            addCriterion("eva_State not in", values, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateBetween(Integer value1, Integer value2) {
            addCriterion("eva_State between", value1, value2, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaStateNotBetween(Integer value1, Integer value2) {
            addCriterion("eva_State not between", value1, value2, "evaState");
            return (Criteria) this;
        }

        public Criteria andEvaLevelIsNull() {
            addCriterion("eva_level is null");
            return (Criteria) this;
        }

        public Criteria andEvaLevelIsNotNull() {
            addCriterion("eva_level is not null");
            return (Criteria) this;
        }

        public Criteria andEvaLevelEqualTo(Integer value) {
            addCriterion("eva_level =", value, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelNotEqualTo(Integer value) {
            addCriterion("eva_level <>", value, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelGreaterThan(Integer value) {
            addCriterion("eva_level >", value, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("eva_level >=", value, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelLessThan(Integer value) {
            addCriterion("eva_level <", value, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelLessThanOrEqualTo(Integer value) {
            addCriterion("eva_level <=", value, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelIn(List<Integer> values) {
            addCriterion("eva_level in", values, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelNotIn(List<Integer> values) {
            addCriterion("eva_level not in", values, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelBetween(Integer value1, Integer value2) {
            addCriterion("eva_level between", value1, value2, "evaLevel");
            return (Criteria) this;
        }

        public Criteria andEvaLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("eva_level not between", value1, value2, "evaLevel");
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