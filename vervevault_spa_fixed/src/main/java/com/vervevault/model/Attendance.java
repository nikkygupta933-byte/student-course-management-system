
package com.vervevault.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Attendance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    private LocalDate date;
    private boolean present;

    public Attendance() {}
    public Attendance(String studentName, LocalDate date, boolean present){ this.studentName=studentName; this.date=date; this.present=present; }
    public Long getId(){ return id; }
    public String getStudentName(){ return studentName; }
    public void setStudentName(String studentName){ this.studentName=studentName; }
    public LocalDate getDate(){ return date; }
    public void setDate(LocalDate date){ this.date=date; }
    public boolean isPresent(){ return present; }
    public void setPresent(boolean present){ this.present = present; }
}
