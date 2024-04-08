package edu.miu.repository;

import edu.miu.domain.ActivityLog;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityLogRepository extends ListCrudRepository<ActivityLog, Long> {
}
