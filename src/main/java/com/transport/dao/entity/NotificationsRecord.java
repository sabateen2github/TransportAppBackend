package com.transport.dao.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.Instant;

@Entity
@Getter
@Setter
public class NotificationsRecord {

    @EmbeddedId
    private ID id;
    private Double latitude;
    private Double longitude;


    @Embeddable
    @Getter
    @Setter
    public static class ID implements Serializable {
        private Instant instant;
        private String userId;
    }
}
