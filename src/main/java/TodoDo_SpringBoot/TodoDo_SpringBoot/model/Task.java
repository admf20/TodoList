package TodoDo_SpringBoot.TodoDo_SpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "Titulo Obligatorio")
    @Size(min = 5, max = 15, message = "El Titulo debe tener un minimo de 5 caracteres a maximo 15")
    private String title;

    @Size(min = 10, max = 90, message = "La Descripcion debe tener un minimo de 10 caracteres a maximo 90")
    private String description;

    @NotNull(message = "El Estado es Obligatorio")
    private Boolean completed;

    public Task(){}

    public Task(Long id, String title, String description, Boolean completed) {
        this.Id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
