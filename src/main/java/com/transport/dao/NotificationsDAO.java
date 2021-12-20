package com.transport.dao;

import com.transport.dao.entity.NotificationsRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface NotificationsDAO extends CrudRepository<NotificationsRecord, NotificationsRecord.ID> {

    public List<NotificationsRecord> findByIdUserId(String userId);

    public List<NotificationsRecord> findByIdInstantBetween(Instant fromDate, Instant toDate);
}
