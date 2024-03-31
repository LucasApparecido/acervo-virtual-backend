package br.ueg.acervovirtual.service;

import br.ueg.acervovirtual.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> listAll();
    Student create(Student dado);
    Student update(Student dado);
    List<Student> listYesterdayRegisters();

    Student getById(Long id);
}
