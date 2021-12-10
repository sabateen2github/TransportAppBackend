package com.transport.dao;

import com.transport.dao.entity.LongTermRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LongTermDAO extends CrudRepository<LongTermRecord, LongTermRecord.ID> {

    public List<LongTermRecord> findByIdUserID(String userId);

    public List<LongTermRecord> findByIdBetween(String fromDate, String toDate);
}
