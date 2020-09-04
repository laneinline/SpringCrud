package site.laneinline.SpringCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import site.laneinline.SpringCrud.model.Employee;




@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}
