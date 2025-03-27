package com.example.to_dolistapp;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
import android.os.AsyncTask;

public class TaskRepository
{
    private final TaskDao taskDao;
    private final LiveData<List<Task>> allTasks;

    public TaskRepository(Application application) {
        TaskDatabase database = TaskDatabase.getInstance(application);
        taskDao = database.taskDao();
        allTasks = taskDao.getAllTasks();
    }
    public void insert(Task task) {
        new InsertTaskAsyncTask(taskDao).execute(task);
    }
    public void update(Task task) {
        new UpdateTaskAsyncTask(taskDao).execute(task);
    }
    public void delete(Task task) {
        new DeleteTaskAsyncTask(taskDao).execute(task);
    }
    public LiveData<List<Task>> getAllTasks()
    {
        return allTasks;
    }
    private static class InsertTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        private final TaskDao taskDao;

        private InsertTaskAsyncTask(TaskDao taskDao) {
            this.taskDao = taskDao;
        }
        @Override protected Void doInBackground(Task... tasks) {
            taskDao.insert(tasks[0]);
            return null;
        }
    }
    private static class UpdateTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        private final TaskDao taskDao;
        private UpdateTaskAsyncTask(TaskDao taskDao) {
            this.taskDao = taskDao;
        }
        @Override protected Void doInBackground(Task... tasks) {
            taskDao.update(tasks[0]); return null;
        }
    }
    private static class DeleteTaskAsyncTask extends AsyncTask<Task, Void, Void> {
        private final TaskDao taskDao;
        private DeleteTaskAsyncTask(TaskDao taskDao) {
            this.taskDao = taskDao;
        }
        @Override protected Void doInBackground(Task... tasks) {
            taskDao.delete(tasks[0]);
            return null;
        }
    }
}