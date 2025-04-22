package TodoDo_SpringBoot.TodoDo_SpringBoot.repository;

import TodoDo_SpringBoot.TodoDo_SpringBoot.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskReposity extends JpaRepository<Task, Long> {}
