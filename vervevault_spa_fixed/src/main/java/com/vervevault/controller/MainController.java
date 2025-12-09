package com.vervevault.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.vervevault.repository.TimetableRepository;

@Controller
public class MainController {

    @Autowired
    private TimetableRepository timetableRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/timetable-view")
    public String timetableView(Model model,
                                @RequestParam(name = "branch", required = false) String branch,
                                @RequestParam(name = "sem", required = false) String sem) {
        String b = (branch == null) ? "CSE" : branch;
        String s = (sem == null) ? "5" : sem;
        model.addAttribute("timetableEntries",
                timetableRepository.findByBranchAndSemester(b, s));
        return "timetable-view";
    }
}
