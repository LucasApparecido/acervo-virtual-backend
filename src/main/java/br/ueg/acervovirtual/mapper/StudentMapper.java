package br.ueg.acervovirtual.mapper;

import br.ueg.acervovirtual.model.dtos.CreateStudentDTO;
import br.ueg.acervovirtual.model.Student;
import br.ueg.acervovirtual.model.dtos.UpdateStudentDTO;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {
    public Student toModel(CreateStudentDTO dto){
        Student s = new Student();
        s.setCourse(dto.getCourse());
        s.setName(dto.getName());
        s.setRegisterNumber(dto.getRegisterNumber());
        return s;
    }
    public Student toModel(UpdateStudentDTO dto){
        Student s = new Student();
        s.setCourse(dto.getCourse());
        s.setName(dto.getName());
        return s;
    }
}
