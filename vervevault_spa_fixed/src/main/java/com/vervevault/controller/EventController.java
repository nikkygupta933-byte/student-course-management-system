
package com.vervevault.controller;

import com.vervevault.model.Event;
import com.vervevault.repository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Controller
@RequestMapping("/events")
public class EventController {
    private final EventRepository repo;
    public EventController(EventRepository repo){ this.repo = repo; }

    @GetMapping("/add")
    public String addForm(Model m){ m.addAttribute("event", new Event()); return "addEvent"; }

    @PostMapping("/add")
    public String save(@ModelAttribute Event event, @RequestParam String date){
        // parse date (yyyy-MM-dd)
        try { event.setDate(LocalDate.parse(date)); } catch(Exception e){}
        repo.save(event);
        return "redirect:/events/view";
    }

    @GetMapping("/view")
    public String viewAll(Model m){ m.addAttribute("events", repo.findAll()); return "viewEvents"; }
}
