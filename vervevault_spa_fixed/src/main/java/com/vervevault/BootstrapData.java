package com.vervevault;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.vervevault.repository.TimetableRepository;
import com.vervevault.model.TimetableEntry;

@Component
public class BootstrapData implements CommandLineRunner {

    @Autowired
    private TimetableRepository timetableRepository;

    @Override
    public void run(String... args) throws Exception {
        timetableRepository.deleteAll();
        add("Monday","9AM","DBMS","CSE","5");
        add("Monday","10AM","OS","CSE","5");
        add("Tuesday","9AM","CN","CSE","5");
        add("Tuesday","10AM","DAA","CSE","5");
        add("Wednesday","9AM","TOC","CSE","5");
        add("Wednesday","10AM","SE","CSE","5");
        add("Thursday","9AM","DBMS-LAB","CSE","5");
        add("Friday","9AM","OS-LAB","CSE","5");
    }

    private void add(String day, String slot, String subject, String branch, String sem) {
        TimetableEntry e = new TimetableEntry();
        e.setDay(day);
        e.setSlot(slot);
        e.setSubject(subject);
        e.setBranch(branch);
        e.setSemester(sem);
        timetableRepository.save(e);
    }
}
