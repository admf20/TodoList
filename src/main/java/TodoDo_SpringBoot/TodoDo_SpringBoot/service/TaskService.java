package TodoDo_SpringBoot.TodoDo_SpringBoot.service;

import TodoDo_SpringBoot.TodoDo_SpringBoot.model.Task;
import TodoDo_SpringBoot.TodoDo_SpringBoot.repository.TaskReposity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskReposity taskReposity;

    public TaskService(TaskReposity taskReposity){
        this.taskReposity = taskReposity;
    }

    public List<Task> getAllTask(){
        return taskReposity.findAll();
    }

    public Optional<Task> getAllByIdTask(Long Id){
        return taskReposity.findById(Id);
    }

    public Task createdTask(Task task){
        return taskReposity.save(task);
    }

    public Optional<Task> updatedTask(Long Id, Task taskDetails){
        return taskReposity.findById(Id)
                .map(task -> {
                    task.setTitle(taskDetails.getTitle());
                    task.setDescription(taskDetails.getDescription());
                    task.setCompleted(taskDetails.getCompleted());
                    return taskReposity.save(task);
                });
    }

    public Boolean deletedTask(Long Id){
        return taskReposity.findById(Id)
                .map(task -> {
                    taskReposity.delete(task);
                    return true;
                }).orElse(false);
    }
}
