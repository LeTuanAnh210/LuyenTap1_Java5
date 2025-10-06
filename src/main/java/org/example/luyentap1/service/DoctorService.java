package org.example.luyentap1.service;

import lombok.Setter;
import org.example.luyentap1.entity.Doctor;
import org.example.luyentap1.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    public void deleDoctor(Long id) {
        this.doctorRepository.deleteById(id);
    }
}
