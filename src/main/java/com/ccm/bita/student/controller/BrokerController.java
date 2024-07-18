package com.ccm.bita.student.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ccm.bita.student.model.Students;
import com.ccm.bita.student.repository.studentRepository;

@RestController
@RequestMapping("/api/v1/")

public class BrokerController {

    @Autowired
        private studentRepository studentRepository;
    private Object Bro;
    private Students existingstudent;

        @GetMapping("/all")
        public ResponseEntity<List<Students>> getAllstudents() {
            List<Students> Bro = studentRepository.findAll();
            return new ResponseEntity<>(Bro, HttpStatus.OK);
        }
     @PostMapping("/save")
     public  Students addStudent(@RequestBody Students student){
        return studentRepository.save(student);

     }


@GetMapping("/{id}")
    public ResponseEntity <Students> getStudentId (@PathVariable Long id)
{
    Optional<Students> Bro = studentRepository .findById(id);
    return new ResponseEntity<>(Bro.get(),HttpStatus.OK);

}
@DeleteMapping("/{id}")
public ResponseEntity<String> deleleStudent(@PathVariable Long id){
studentRepository.deleteById(id);
return new ResponseEntity<>("Delete data succes", HttpStatus.OK);

}
@PutMapping("/{id}")
public ResponseEntity<Students> updateStudent(@PathVariable Long id,@RequestBody Students Bro){
    Bro.setId(id);
    existingstudent.setUsername(Bro.getUsername());
    existingstudent.setAdress(Bro.getAdress());
    existingstudent.setPhoneNumber(Bro.getPhoneNumber());
    existingstudent.setGender(Bro.getGender());
    existingstudent.setCountry(Bro.getCountry());
    existingstudent.setHouse(Bro.getHouse());
    Students updateStudent = studentRepository.save(existingstudent);
    return new ResponseEntity<>(updateStudent, HttpStatus.CREATED);

    
}
}

    

