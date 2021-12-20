package com.transport.dao;

import com.transport.dao.entity.LongTermRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface LongTermDAO extends CrudRepository<LongTermRecord, LongTermRecord.ID> {

    public List<LongTermRecord> findByIdUserId(String userId);

    public List<LongTermRecord> findByIdInstantBetween(Instant fromDate, Instant toDate);
}
