package info.freeit.sbdemo.controller;

import info.freeit.sbdemo.model.Faculty;
import info.freeit.sbdemo.model.Student;
import info.freeit.sbdemo.repository.FacultyRepository;
import info.freeit.sbdemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, FacultyRepository facultyRepository) {
        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping
    public Long createStudent(@RequestBody Student student) {
        Faculty faculty = facultyRepository.findById(student.getFaculty().getId())
                .orElseThrow(() -> new IllegalArgumentException("No such faculty exception: " + student.getFaculty().getId()));
        student.setFaculty(faculty);
        return studentRepository.save(student).getId();
    }

}
