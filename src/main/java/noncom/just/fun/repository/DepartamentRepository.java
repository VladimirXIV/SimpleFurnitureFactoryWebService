package noncom.just.fun.repository;

import noncom.just.fun.model.Department;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "dprtmntRepo")
public interface DepartamentRepository extends JpaRepository<Department, Long> {
    
}