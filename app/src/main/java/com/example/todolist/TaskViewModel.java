package com.example.to_dolistapp;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import java.util.List;

/**
 * TaskViewModel manages UI-related data in a lifecycle-conscious way.
 * It interacts with the TaskRepository to fetch and update tasks.
 */

public class TaskViewModel extends AndroidViewModel {

    private final TaskRepository repository;
    private final LiveData<List<Task>> allTasks;
    public TaskViewModel(@NonNull Application application) {

        super(application);
        repository = new TaskRepository(application);
        allTasks = repository.getAllTasks();
    }
    public void insert(Task task) {
        repository.insert(task);
    }
    public void update(Task task) {
        repository.update(task);
    }
    public void delete(Task task) {
        repository.delete(task);
    }

    public LiveData<List<Task>> getAllTasks() {

        return allTasks;
    }
}
