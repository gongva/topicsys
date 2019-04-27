package com.pzhu.topicsys.modules.comm.model;

/**
 * Desc：只有一个notice的Entity
 *
 */
public class NoticeEntity {

    private String notice;

    public NoticeEntity(String notice) {
        this.notice = notice;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

}
