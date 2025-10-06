package org.example.luyentap1.controller;


import jakarta.validation.Valid;
import org.example.luyentap1.entity.Doctor;
import org.example.luyentap1.service.DoctorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctors")
    public String doctors(Model model) {
        List<Doctor> doctors = doctorService.getAll();
        model.addAttribute("doctors", doctors);
        return "views/doctors";
    }

    @GetMapping("/doctors/deleteDoctor/{id}")
    public String deleteDoctor(@PathVariable("id") Long id){
        doctorService.deleDoctor(id);
        return "redirect:/doctors";
    }

    @GetMapping("/doctors/showFormSaveDocter")
    public String showFormSaveDocter(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctors", doctor);
        return "views/new_doctor";
    }

    @PostMapping("/doctors/saveDoctor")
    public String saveDoctor(@Valid @ModelAttribute("doctor") Doctor doctor, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "views/doctors";
        }
        doctorService.saveDoctor(doctor);
        return "redirect:/doctors";
    }
}
