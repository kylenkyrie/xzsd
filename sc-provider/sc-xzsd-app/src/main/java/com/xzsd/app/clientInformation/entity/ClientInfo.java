package com.xzsd.app.clientInformation.entity;
/**
 * 用户邀请码实体类
 */
public class ClientInfo {
    /**
     * 用户id
     */
    private String userId;
    /**
     * 邀请码
     */
    private String inviteCode;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
