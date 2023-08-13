package com.powernode.pojo;

/**
 * User: hallen
 * Date: 2023/8/8
 * Time: 21:44
 */

public class User {
    private String userId;
    private String cardType;
    private String cardNo;
    private String userName;
    private String userSex;
    private String userAge;
    private String userRole;

    public User() {
    }

    public User(String userId, String cardType, String cardNo, String userName, String userSex, String userAge, String userRole) {
        this.userId = userId;
        this.cardType = cardType;
        this.cardNo = cardNo;
        this.userName = userName;
        this.userSex = userSex;
        this.userAge = userAge;
        this.userRole = userRole;
    }

    /**
     * 获取
     * @return userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取
     * @return cardType
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 设置
     * @param cardType
     */
    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * 获取
     * @return cardNo
     */
    public String getCardNo() {
        return cardNo;
    }

    /**
     * 设置
     * @param cardNo
     */
    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    /**
     * 获取
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取
     * @return userSex
     */
    public String getUserSex() {
        return userSex;
    }

    /**
     * 设置
     * @param userSex
     */
    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    /**
     * 获取
     * @return userAge
     */
    public String getUserAge() {
        return userAge;
    }

    /**
     * 设置
     * @param userAge
     */
    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    /**
     * 获取
     * @return userRole
     */
    public String getUserRole() {
        return userRole;
    }

    /**
     * 设置
     * @param userRole
     */
    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String toString() {
        return "User{userId = " + userId + ", cardType = " + cardType + ", cardNo = " + cardNo + ", userName = " + userName + ", userSex = " + userSex + ", userAge = " + userAge + ", userRole = " + userRole + "}";
    }
}
