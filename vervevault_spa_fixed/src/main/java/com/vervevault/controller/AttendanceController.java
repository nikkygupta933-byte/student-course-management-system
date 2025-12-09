
package com.vervevault.controller;

import com.vervevault.model.Attendance;
import com.vervevault.repository.AttendanceRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    private final AttendanceRepository repo;
    public AttendanceController(AttendanceRepository repo){ this.repo = repo; }

    @GetMapping("/add")
    public String addForm(Model m){ m.addAttribute("attendance", new Attendance()); return "addAttendance"; }

    @PostMapping("/add")
    public String save(@ModelAttribute Attendance attendance, @RequestParam String date){
        try { attendance.setDate(LocalDate.parse(date)); } catch(Exception e){}
        repo.save(attendance);
        return "redirect:/attendance/view";
    }

    @GetMapping("/view")
    public String viewAll(Model m){ m.addAttribute("records", repo.findAll()); return "viewAttendance"; }
}
