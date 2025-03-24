package com.example.todolist;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            editTextTask = findViewById(R.id.editTextTask);
            Button buttonAdd = findViewById(R.id.buttonAdd);
            RecyclerView recyclerViewTasks = findViewById(R.id.recyclerViewTasks);
    
            taskAdapter = new TaskAdapter(new ArrayList<>());
            recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewTasks.setAdapter(taskAdapter);
    
            taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);
            taskViewModel.getAllTasks().observe(this, tasks -> taskAdapter.setTasks(tasks));
    
            buttonAdd.setOnClickListener(v -> {
                String task = editTextTask.getText().toString();
                if (!task.isEmpty()) {
                    taskViewModel.insert(new Task(task));
                    editTextTask.setText("");
                }
            });
    
            taskAdapter.setOnItemClickListener(task -> taskViewModel.delete(task));
        });
    }
}