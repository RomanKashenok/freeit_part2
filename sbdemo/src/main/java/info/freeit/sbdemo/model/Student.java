package info.freeit.sbdemo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "students", indexes = @Index(name = "id_ind", columnList = "id"))
public class Student extends BaseEntity{

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "faculty_id")
    private Faculty faculty;

}
