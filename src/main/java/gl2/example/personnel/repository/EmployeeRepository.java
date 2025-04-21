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
            "(:name IS NULL OR e.name LIKE %:name%) AND " +
            "(:position IS NULL OR e.position = :position) AND " +
            "(:minSalary IS NULL OR e.salary >= :minSalary)")
    List<Employee> findByFilters(@Param("name") String name,
                                 @Param("position") String position,
                                 @Param("minSalary") String minSalary);

}

