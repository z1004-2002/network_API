package com.vetrix.network_API.demo.student;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@CrossOrigin("*")
@RequestMapping("/student")
@RestController
@Tag(name = "Student")
public class StudentController {
    final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudents();
    }
    @GetMapping("/{id}")
    public Optional<Student> getById(@PathVariable UUID id){
        return studentService.getStudentById(id);
    }
    @GetMapping("/department/{depart}")
    public List<Student> getByDepart(@PathVariable String depart){
        return studentService.getByDepart(depart);
    }
    @PostMapping("/add/{id}")
    public Student addStudent(@RequestBody Student student,@PathVariable UUID id){
        return studentService.addStudent(student,id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable UUID id){
        studentService.deleteStudent(id);
    }
    @PutMapping("/update/{id}")
    public void updateStudent(@PathVariable UUID id, @RequestBody Student student){
        studentService.updateStudent(id, student);
    }

}
