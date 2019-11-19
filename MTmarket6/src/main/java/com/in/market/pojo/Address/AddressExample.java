package com.in.market.pojo.address;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andAddrIdIsNull() {
            addCriterion("addr_Id is null");
            return (Criteria) this;
        }

        public Criteria andAddrIdIsNotNull() {
            addCriterion("addr_Id is not null");
            return (Criteria) this;
        }

        public Criteria andAddrIdEqualTo(Integer value) {
            addCriterion("addr_Id =", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotEqualTo(Integer value) {
            addCriterion("addr_Id <>", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdGreaterThan(Integer value) {
            addCriterion("addr_Id >", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("addr_Id >=", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdLessThan(Integer value) {
            addCriterion("addr_Id <", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdLessThanOrEqualTo(Integer value) {
            addCriterion("addr_Id <=", value, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdIn(List<Integer> values) {
            addCriterion("addr_Id in", values, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotIn(List<Integer> values) {
            addCriterion("addr_Id not in", values, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdBetween(Integer value1, Integer value2) {
            addCriterion("addr_Id between", value1, value2, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("addr_Id not between", value1, value2, "addrId");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIsNull() {
            addCriterion("addr_province is null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIsNotNull() {
            addCriterion("addr_province is not null");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceEqualTo(String value) {
            addCriterion("addr_province =", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotEqualTo(String value) {
            addCriterion("addr_province <>", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceGreaterThan(String value) {
            addCriterion("addr_province >", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("addr_province >=", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLessThan(String value) {
            addCriterion("addr_province <", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLessThanOrEqualTo(String value) {
            addCriterion("addr_province <=", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceLike(String value) {
            addCriterion("addr_province like", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotLike(String value) {
            addCriterion("addr_province not like", value, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceIn(List<String> values) {
            addCriterion("addr_province in", values, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotIn(List<String> values) {
            addCriterion("addr_province not in", values, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceBetween(String value1, String value2) {
            addCriterion("addr_province between", value1, value2, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrProvinceNotBetween(String value1, String value2) {
            addCriterion("addr_province not between", value1, value2, "addrProvince");
            return (Criteria) this;
        }

        public Criteria andAddrCityIsNull() {
            addCriterion("addr_city is null");
            return (Criteria) this;
        }

        public Criteria andAddrCityIsNotNull() {
            addCriterion("addr_city is not null");
            return (Criteria) this;
        }

        public Criteria andAddrCityEqualTo(String value) {
            addCriterion("addr_city =", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotEqualTo(String value) {
            addCriterion("addr_city <>", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityGreaterThan(String value) {
            addCriterion("addr_city >", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityGreaterThanOrEqualTo(String value) {
            addCriterion("addr_city >=", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLessThan(String value) {
            addCriterion("addr_city <", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLessThanOrEqualTo(String value) {
            addCriterion("addr_city <=", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityLike(String value) {
            addCriterion("addr_city like", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotLike(String value) {
            addCriterion("addr_city not like", value, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityIn(List<String> values) {
            addCriterion("addr_city in", values, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotIn(List<String> values) {
            addCriterion("addr_city not in", values, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityBetween(String value1, String value2) {
            addCriterion("addr_city between", value1, value2, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrCityNotBetween(String value1, String value2) {
            addCriterion("addr_city not between", value1, value2, "addrCity");
            return (Criteria) this;
        }

        public Criteria andAddrAreaIsNull() {
            addCriterion("addr_area is null");
            return (Criteria) this;
        }

        public Criteria andAddrAreaIsNotNull() {
            addCriterion("addr_area is not null");
            return (Criteria) this;
        }

        public Criteria andAddrAreaEqualTo(String value) {
            addCriterion("addr_area =", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaNotEqualTo(String value) {
            addCriterion("addr_area <>", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaGreaterThan(String value) {
            addCriterion("addr_area >", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaGreaterThanOrEqualTo(String value) {
            addCriterion("addr_area >=", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaLessThan(String value) {
            addCriterion("addr_area <", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaLessThanOrEqualTo(String value) {
            addCriterion("addr_area <=", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaLike(String value) {
            addCriterion("addr_area like", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaNotLike(String value) {
            addCriterion("addr_area not like", value, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaIn(List<String> values) {
            addCriterion("addr_area in", values, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaNotIn(List<String> values) {
            addCriterion("addr_area not in", values, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaBetween(String value1, String value2) {
            addCriterion("addr_area between", value1, value2, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrAreaNotBetween(String value1, String value2) {
            addCriterion("addr_area not between", value1, value2, "addrArea");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIsNull() {
            addCriterion("addr_detail is null");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIsNotNull() {
            addCriterion("addr_detail is not null");
            return (Criteria) this;
        }

        public Criteria andAddrDetailEqualTo(String value) {
            addCriterion("addr_detail =", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotEqualTo(String value) {
            addCriterion("addr_detail <>", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailGreaterThan(String value) {
            addCriterion("addr_detail >", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailGreaterThanOrEqualTo(String value) {
            addCriterion("addr_detail >=", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLessThan(String value) {
            addCriterion("addr_detail <", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLessThanOrEqualTo(String value) {
            addCriterion("addr_detail <=", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailLike(String value) {
            addCriterion("addr_detail like", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotLike(String value) {
            addCriterion("addr_detail not like", value, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailIn(List<String> values) {
            addCriterion("addr_detail in", values, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotIn(List<String> values) {
            addCriterion("addr_detail not in", values, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailBetween(String value1, String value2) {
            addCriterion("addr_detail between", value1, value2, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrDetailNotBetween(String value1, String value2) {
            addCriterion("addr_detail not between", value1, value2, "addrDetail");
            return (Criteria) this;
        }

        public Criteria andAddrUserIsNull() {
            addCriterion("addr_user is null");
            return (Criteria) this;
        }

        public Criteria andAddrUserIsNotNull() {
            addCriterion("addr_user is not null");
            return (Criteria) this;
        }

        public Criteria andAddrUserEqualTo(Integer value) {
            addCriterion("addr_user =", value, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserNotEqualTo(Integer value) {
            addCriterion("addr_user <>", value, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserGreaterThan(Integer value) {
            addCriterion("addr_user >", value, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("addr_user >=", value, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserLessThan(Integer value) {
            addCriterion("addr_user <", value, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserLessThanOrEqualTo(Integer value) {
            addCriterion("addr_user <=", value, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserIn(List<Integer> values) {
            addCriterion("addr_user in", values, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserNotIn(List<Integer> values) {
            addCriterion("addr_user not in", values, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserBetween(Integer value1, Integer value2) {
            addCriterion("addr_user between", value1, value2, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrUserNotBetween(Integer value1, Integer value2) {
            addCriterion("addr_user not between", value1, value2, "addrUser");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeIsNull() {
            addCriterion("addr_zipcode is null");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeIsNotNull() {
            addCriterion("addr_zipcode is not null");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeEqualTo(String value) {
            addCriterion("addr_zipcode =", value, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeNotEqualTo(String value) {
            addCriterion("addr_zipcode <>", value, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeGreaterThan(String value) {
            addCriterion("addr_zipcode >", value, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeGreaterThanOrEqualTo(String value) {
            addCriterion("addr_zipcode >=", value, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeLessThan(String value) {
            addCriterion("addr_zipcode <", value, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeLessThanOrEqualTo(String value) {
            addCriterion("addr_zipcode <=", value, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeLike(String value) {
            addCriterion("addr_zipcode like", value, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeNotLike(String value) {
            addCriterion("addr_zipcode not like", value, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeIn(List<String> values) {
            addCriterion("addr_zipcode in", values, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeNotIn(List<String> values) {
            addCriterion("addr_zipcode not in", values, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeBetween(String value1, String value2) {
            addCriterion("addr_zipcode between", value1, value2, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrZipcodeNotBetween(String value1, String value2) {
            addCriterion("addr_zipcode not between", value1, value2, "addrZipcode");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneIsNull() {
            addCriterion("addr_phone is null");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneIsNotNull() {
            addCriterion("addr_phone is not null");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneEqualTo(String value) {
            addCriterion("addr_phone =", value, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneNotEqualTo(String value) {
            addCriterion("addr_phone <>", value, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneGreaterThan(String value) {
            addCriterion("addr_phone >", value, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("addr_phone >=", value, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneLessThan(String value) {
            addCriterion("addr_phone <", value, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneLessThanOrEqualTo(String value) {
            addCriterion("addr_phone <=", value, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneLike(String value) {
            addCriterion("addr_phone like", value, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneNotLike(String value) {
            addCriterion("addr_phone not like", value, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneIn(List<String> values) {
            addCriterion("addr_phone in", values, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneNotIn(List<String> values) {
            addCriterion("addr_phone not in", values, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneBetween(String value1, String value2) {
            addCriterion("addr_phone between", value1, value2, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrPhoneNotBetween(String value1, String value2) {
            addCriterion("addr_phone not between", value1, value2, "addrPhone");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameIsNull() {
            addCriterion("addr_nickname is null");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameIsNotNull() {
            addCriterion("addr_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameEqualTo(String value) {
            addCriterion("addr_nickname =", value, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameNotEqualTo(String value) {
            addCriterion("addr_nickname <>", value, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameGreaterThan(String value) {
            addCriterion("addr_nickname >", value, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("addr_nickname >=", value, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameLessThan(String value) {
            addCriterion("addr_nickname <", value, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameLessThanOrEqualTo(String value) {
            addCriterion("addr_nickname <=", value, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameLike(String value) {
            addCriterion("addr_nickname like", value, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameNotLike(String value) {
            addCriterion("addr_nickname not like", value, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameIn(List<String> values) {
            addCriterion("addr_nickname in", values, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameNotIn(List<String> values) {
            addCriterion("addr_nickname not in", values, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameBetween(String value1, String value2) {
            addCriterion("addr_nickname between", value1, value2, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrNicknameNotBetween(String value1, String value2) {
            addCriterion("addr_nickname not between", value1, value2, "addrNickname");
            return (Criteria) this;
        }

        public Criteria andAddrStateIsNull() {
            addCriterion("addr_state is null");
            return (Criteria) this;
        }

        public Criteria andAddrStateIsNotNull() {
            addCriterion("addr_state is not null");
            return (Criteria) this;
        }

        public Criteria andAddrStateEqualTo(Integer value) {
            addCriterion("addr_state =", value, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateNotEqualTo(Integer value) {
            addCriterion("addr_state <>", value, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateGreaterThan(Integer value) {
            addCriterion("addr_state >", value, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("addr_state >=", value, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateLessThan(Integer value) {
            addCriterion("addr_state <", value, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateLessThanOrEqualTo(Integer value) {
            addCriterion("addr_state <=", value, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateIn(List<Integer> values) {
            addCriterion("addr_state in", values, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateNotIn(List<Integer> values) {
            addCriterion("addr_state not in", values, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateBetween(Integer value1, Integer value2) {
            addCriterion("addr_state between", value1, value2, "addrState");
            return (Criteria) this;
        }

        public Criteria andAddrStateNotBetween(Integer value1, Integer value2) {
            addCriterion("addr_state not between", value1, value2, "addrState");
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