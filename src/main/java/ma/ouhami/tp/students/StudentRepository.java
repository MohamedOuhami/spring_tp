package ma.ouhami.tp.students;

import org.hibernate.mapping.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT YEAR(s.dateNaissance) as year, COUNT(s) as nbr " +
           "FROM Student s " +
           "GROUP BY YEAR(s.dateNaissance) " +
           "ORDER BY year")
    List<Object[]> findNbrStudentByYear();
}
