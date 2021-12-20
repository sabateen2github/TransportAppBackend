package com.transport.dao;

import com.transport.dao.entity.LongTermBusRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface LongTermBusDAO extends CrudRepository<LongTermBusRecord, LongTermBusRecord.ID> {

    public List<LongTermBusRecord> findByIdBusId(String busID);

    public List<LongTermBusRecord> findByIdInstantBetween(Instant fromDate, Instant toDate);
}
