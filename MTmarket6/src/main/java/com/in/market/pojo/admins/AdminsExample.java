package com.in.market.pojo.admins;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AdminsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminsExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_Id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_Id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(Integer value) {
            addCriterion("admin_Id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(Integer value) {
            addCriterion("admin_Id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(Integer value) {
            addCriterion("admin_Id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_Id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(Integer value) {
            addCriterion("admin_Id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(Integer value) {
            addCriterion("admin_Id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<Integer> values) {
            addCriterion("admin_Id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<Integer> values) {
            addCriterion("admin_Id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(Integer value1, Integer value2) {
            addCriterion("admin_Id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_Id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNull() {
            addCriterion("admin_Name is null");
            return (Criteria) this;
        }

        public Criteria andAdminNameIsNotNull() {
            addCriterion("admin_Name is not null");
            return (Criteria) this;
        }

        public Criteria andAdminNameEqualTo(String value) {
            addCriterion("admin_Name =", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotEqualTo(String value) {
            addCriterion("admin_Name <>", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThan(String value) {
            addCriterion("admin_Name >", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameGreaterThanOrEqualTo(String value) {
            addCriterion("admin_Name >=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThan(String value) {
            addCriterion("admin_Name <", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLessThanOrEqualTo(String value) {
            addCriterion("admin_Name <=", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameLike(String value) {
            addCriterion("admin_Name like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotLike(String value) {
            addCriterion("admin_Name not like", value, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameIn(List<String> values) {
            addCriterion("admin_Name in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotIn(List<String> values) {
            addCriterion("admin_Name not in", values, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameBetween(String value1, String value2) {
            addCriterion("admin_Name between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminNameNotBetween(String value1, String value2) {
            addCriterion("admin_Name not between", value1, value2, "adminName");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIsNull() {
            addCriterion("admin_Phone is null");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIsNotNull() {
            addCriterion("admin_Phone is not null");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneEqualTo(String value) {
            addCriterion("admin_Phone =", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotEqualTo(String value) {
            addCriterion("admin_Phone <>", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneGreaterThan(String value) {
            addCriterion("admin_Phone >", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("admin_Phone >=", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLessThan(String value) {
            addCriterion("admin_Phone <", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLessThanOrEqualTo(String value) {
            addCriterion("admin_Phone <=", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneLike(String value) {
            addCriterion("admin_Phone like", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotLike(String value) {
            addCriterion("admin_Phone not like", value, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneIn(List<String> values) {
            addCriterion("admin_Phone in", values, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotIn(List<String> values) {
            addCriterion("admin_Phone not in", values, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneBetween(String value1, String value2) {
            addCriterion("admin_Phone between", value1, value2, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminPhoneNotBetween(String value1, String value2) {
            addCriterion("admin_Phone not between", value1, value2, "adminPhone");
            return (Criteria) this;
        }

        public Criteria andAdminDateIsNull() {
            addCriterion("admin_Date is null");
            return (Criteria) this;
        }

        public Criteria andAdminDateIsNotNull() {
            addCriterion("admin_Date is not null");
            return (Criteria) this;
        }

        public Criteria andAdminDateEqualTo(Date value) {
            addCriterionForJDBCDate("admin_Date =", value, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("admin_Date <>", value, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateGreaterThan(Date value) {
            addCriterionForJDBCDate("admin_Date >", value, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("admin_Date >=", value, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateLessThan(Date value) {
            addCriterionForJDBCDate("admin_Date <", value, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("admin_Date <=", value, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateIn(List<Date> values) {
            addCriterionForJDBCDate("admin_Date in", values, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("admin_Date not in", values, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("admin_Date between", value1, value2, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("admin_Date not between", value1, value2, "adminDate");
            return (Criteria) this;
        }

        public Criteria andAdminStateIsNull() {
            addCriterion("admin_State is null");
            return (Criteria) this;
        }

        public Criteria andAdminStateIsNotNull() {
            addCriterion("admin_State is not null");
            return (Criteria) this;
        }

        public Criteria andAdminStateEqualTo(Integer value) {
            addCriterion("admin_State =", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateNotEqualTo(Integer value) {
            addCriterion("admin_State <>", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateGreaterThan(Integer value) {
            addCriterion("admin_State >", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_State >=", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateLessThan(Integer value) {
            addCriterion("admin_State <", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateLessThanOrEqualTo(Integer value) {
            addCriterion("admin_State <=", value, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateIn(List<Integer> values) {
            addCriterion("admin_State in", values, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateNotIn(List<Integer> values) {
            addCriterion("admin_State not in", values, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateBetween(Integer value1, Integer value2) {
            addCriterion("admin_State between", value1, value2, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminStateNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_State not between", value1, value2, "adminState");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIsNull() {
            addCriterion("admin_Role is null");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIsNotNull() {
            addCriterion("admin_Role is not null");
            return (Criteria) this;
        }

        public Criteria andAdminRoleEqualTo(Integer value) {
            addCriterion("admin_Role =", value, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleNotEqualTo(Integer value) {
            addCriterion("admin_Role <>", value, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleGreaterThan(Integer value) {
            addCriterion("admin_Role >", value, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("admin_Role >=", value, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleLessThan(Integer value) {
            addCriterion("admin_Role <", value, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleLessThanOrEqualTo(Integer value) {
            addCriterion("admin_Role <=", value, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleIn(List<Integer> values) {
            addCriterion("admin_Role in", values, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleNotIn(List<Integer> values) {
            addCriterion("admin_Role not in", values, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleBetween(Integer value1, Integer value2) {
            addCriterion("admin_Role between", value1, value2, "adminRole");
            return (Criteria) this;
        }

        public Criteria andAdminRoleNotBetween(Integer value1, Integer value2) {
            addCriterion("admin_Role not between", value1, value2, "adminRole");
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