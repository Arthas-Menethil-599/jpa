package org.itstep.jpa.repo;

import org.itstep.jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findAllByAgeGreaterThanEqual(Integer value);

    List<Student> findAllByAgeLessThanEqual(Integer value);

    List<Student> findAllByNameContaining(String value);

    List<Student> findAllByNameLike(String value);


}
