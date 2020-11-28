package info.freeit.sbdemo.controller;

import info.freeit.sbdemo.model.Faculty;
import info.freeit.sbdemo.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/faculties")
public class FacultyController {

    private final FacultyRepository facultyRepository;

    @Autowired
    public FacultyController(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    @PostMapping
    public Long createFacult(@RequestBody Faculty faculty) {
        return facultyRepository.save(faculty).getId();
    }
}
