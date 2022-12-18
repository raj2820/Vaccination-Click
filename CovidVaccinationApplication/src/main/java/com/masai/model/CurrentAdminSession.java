package com.masai.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrentAdminSession {

	@Id
    @Column(unique = true)
    private Integer adminId;
    private String uuid;
    private LocalDateTime localDateTime;

    public CurrentAdminSession() {
    }

    public CurrentAdminSession(Integer adminId, String uuid, LocalDateTime localDateTime) {
        this.adminId = adminId;
        this.uuid = uuid;
        this.localDateTime = localDateTime;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "CurrentAdminSession{" +
                "adminId=" + adminId +
                ", uuid='" + uuid + '\'' +
                ", localDateTime=" + localDateTime +
                '}';
    }
	
}
