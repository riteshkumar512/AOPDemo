package in.kumar.AOPDemo.service;

import in.kumar.AOPDemo.dto.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public Student createStudent(Student student){
        System.out.println("Student saved");
//        throw new RuntimeException("Error Occured");
        return student;
    }

    public String dummyMethod(String s) {
        return s;
    }
}
