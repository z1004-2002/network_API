package com.vetrix.network_API.demo.student;

import com.vetrix.network_API.demo.address.Address;
import com.vetrix.network_API.demo.address.AddressRepository;
import com.vetrix.network_API.demo.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {
    final StudentRepository studentRepository;
    final AddressRepository addressRepository;
    final AddressService addressService;

    @Autowired
    public StudentService(StudentRepository studentRepository, AddressRepository addressRepository, AddressService addressService) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
        this.addressService = addressService;
    }

    public Student addStudent(Student student, UUID id){
        if (!addressRepository.existsById(id)){
            throw new IllegalStateException("This address does no exist");
        }
        Address address = addressRepository.findById(id).orElseThrow(()->new IllegalStateException("This address does no exist"));
        student.setAddress(address);
        studentRepository.save(student);
        return student;
    }
    public void updateStudent(UUID id, Student student){
        boolean exists = studentRepository.existsById(id);
        if (!exists)
            throw new IllegalStateException("This Student does not exists");

        studentRepository.findById(id).map(s ->{
            //s.setAddress(student.getAddress());
            s.setDepartment(student.getDepartment());
            s.setName(student.getName());
            return studentRepository.save(s);
        });
    }
    public void deleteStudent(UUID id){
        boolean exists = studentRepository.existsById(id);
        if (!exists)
            throw new IllegalStateException("This Student does not exists");

        studentRepository.deleteById(id);
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public Optional<Student> getStudentById(UUID id){
        return studentRepository.findById(id);
    }
    public List<Student> getByDepart(String depart){
        return studentRepository.getByDepartment(depart);
    }
}
