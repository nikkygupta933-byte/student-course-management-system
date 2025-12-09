
package com.vervevault.controller;

import com.vervevault.model.Task;
import com.vervevault.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskRepository repo;
    public TaskController(TaskRepository repo){ this.repo = repo; }

    @GetMapping("/add")
    public String addForm(Model m){ m.addAttribute("task", new Task()); return "addTask"; }

    @PostMapping("/add")
    public String save(@ModelAttribute Task task){ repo.save(task); return "redirect:/tasks/view"; }

    @GetMapping("/view")
    public String viewAll(Model m){ m.addAttribute("tasks", repo.findAll()); return "viewTasks"; }

    @PostMapping("/toggle/{id}")
    public String toggle(@PathVariable Long id){
        var t = repo.findById(id).orElse(null);
        if(t!=null){ t.setCompleted(!t.isCompleted()); repo.save(t); }
        return "redirect:/tasks/view";
    }
}
