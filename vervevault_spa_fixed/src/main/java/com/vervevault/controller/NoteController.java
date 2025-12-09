
package com.vervevault.controller;

import com.vervevault.model.Note;
import com.vervevault.repository.NoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {
    private final NoteRepository repo;
    public NoteController(NoteRepository repo){ this.repo = repo; }

    @GetMapping("/add")
    public String addForm(Model m){ m.addAttribute("note", new Note()); return "addNote"; }

    @PostMapping("/add")
    public String save(@ModelAttribute Note note){ repo.save(note); return "redirect:/notes/view"; }

    @GetMapping("/view")
    public String viewAll(Model m){ m.addAttribute("notes", repo.findAll()); return "viewNotes"; }
}
