package info.freeit.sbdemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "faculties")
public class Faculty extends BaseEntity {

    @Column(name = "faculty_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "faculty")
    private List<Student> students;

}
