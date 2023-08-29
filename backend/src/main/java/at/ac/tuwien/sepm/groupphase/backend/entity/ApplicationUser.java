package at.ac.tuwien.sepm.groupphase.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name="application_user")
public class ApplicationUser {

    @Column(name = "name", nullable = false)
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public ApplicationUser() {
    }

    public ApplicationUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
