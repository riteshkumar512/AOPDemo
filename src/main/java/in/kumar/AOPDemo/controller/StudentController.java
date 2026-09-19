package in.kumar.AOPDemo.controller;

import in.kumar.AOPDemo.dto.Student;
import in.kumar.AOPDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return ResponseEntity.ok(
                studentService.createStudent(student));
    }
    @GetMapping
    public ResponseEntity<String> dummyMrthod(){
        String s = "ritesh";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
