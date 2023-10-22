package ma.ouhami.tp.students;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    
    @Autowired
    private StudentRepository studentRepository;

    // Get Mappings

    @GetMapping("/all")
    public List<Student> findAll(){
        return studentRepository.findAll();
    }

    @GetMapping("/count")
    public long countStudent(){
        return studentRepository.count();
    }

    @GetMapping("/byYear")
    public List<Object[]> findByYear(){
        return studentRepository.findNbrStudentByYear();
    }

    // Put Mapping

    @PostMapping("/save")
    public void addStudent(@RequestBody Student student){
        studentRepository.save(student);
    }

    // Delete mapping

    @DeleteMapping("/delete")
    public void deleteStudent(@RequestParam Integer id){
        studentRepository.deleteById(id);
    }
}
