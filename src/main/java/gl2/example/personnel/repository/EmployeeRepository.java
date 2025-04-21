package gl2.example.personnel.repository;

import gl2.example.personnel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM Employee e WHERE " +
            "(:name IS NULL OR e.name LIKE %:name%) ")
    List<Employee> findByFilters(String name);
}

