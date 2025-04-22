package TodoDo_SpringBoot.TodoDo_SpringBoot.controller;

import TodoDo_SpringBoot.TodoDo_SpringBoot.model.Task;
import TodoDo_SpringBoot.TodoDo_SpringBoot.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll(){
        return taskService.getAllTask();
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Task> getAllByIdTask(@PathVariable Long Id){
        return taskService.getAllByIdTask(Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Task> createdTask(@Valid @RequestBody Task task){
        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createdTask(task));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Task> updatedTask(@PathVariable Long Id,@Valid @RequestBody Task task){
        return taskService.updatedTask(Id, task)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deletedTask(@PathVariable Long Id){
        Boolean taskDeleted = taskService.deletedTask(Id);
        return taskDeleted
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}
