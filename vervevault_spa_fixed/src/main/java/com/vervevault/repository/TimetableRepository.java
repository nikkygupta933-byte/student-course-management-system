package com.vervevault.repository;

import com.vervevault.model.TimetableEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TimetableRepository extends JpaRepository<TimetableEntry, Long> {
    List<TimetableEntry> findByBranchAndSemester(String branch, String semester);
}
