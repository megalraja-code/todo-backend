package com.todo.backend.controller;

import com.todo.backend.model.Task;
import com.todo.backend.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5173")
public class TaskController {

    private final TaskRepository repo;

    public TaskController(TaskRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Task> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Task create(@RequestBody Task task) {

        if (task.getText() == null || task.getText().isBlank()) {
            throw new RuntimeException("Task cannot be empty");
        }

        return repo.save(task);
    }
    @PutMapping("/{id}")
    public Task update(@PathVariable Long id, @RequestBody Task updated) {
        Task task = repo.findById(id).orElseThrow();
        task.setText(updated.getText());
        task.setDone(updated.isDone());
        return repo.save(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}