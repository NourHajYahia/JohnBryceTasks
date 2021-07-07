package app.core.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.core.entities.Job;

public interface JobRepository extends JpaRepository<Job, Long> {
	
	List<Job> findByEndDateBefore(LocalDate endDate);
	List<Job> findAllByEndDateBetween(LocalDate start, LocalDate end);
	
	@Query(value = "from Job where employee_id=?1")
	List<Job> getJobsByEmployeeId(Long employeeID);

}
