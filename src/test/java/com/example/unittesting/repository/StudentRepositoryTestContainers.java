package com.example.unittesting.repository;


import com.example.unittesting.model.Student;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class StudentRepositoryTests {

    @Autowired
    private StudentRepository studentRepository;

    private Student student;
    
    @Test
    @DisplayName("JUnit Test for Save Student")
    public void saveStudentTest(){
        //given
        student = Student.builder()
                .firstName("Dele")
                .lastName("Joshua")
                .email("dele.joshua@gmail.com")
                .build();
        //when
        Student savedStudent= studentRepository.save(student);
        //then
        assertThat(savedStudent).isNotNull();
        assertThat(savedStudent.getId()).isNotNull();

    }

}
