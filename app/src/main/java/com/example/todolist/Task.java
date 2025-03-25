package com.example.to_dolistapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Task represents a single task in the to-do list.
 * It is an entity class used by Room to create a table in the database.
 */

@Entity(tableName = "tasks")

public class Task {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String task;

    // Constructor
    public Task(String task) {
        this.task = task;
    }

    // Getter for task
    public String getTask() {
        return task;
    }

    // Setter for task
    public void setTask(String task) {
        this.task = task;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }
}
