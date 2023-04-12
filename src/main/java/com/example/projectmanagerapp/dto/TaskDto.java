package com.example.projectmanagerapp.dto;

import com.example.projectmanagerapp.entity.ImplementerType;
import com.example.projectmanagerapp.entity.Status;
import com.example.projectmanagerapp.entity.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDto {
    private Long id;
    private Status status;
    private ImplementerType implementerType;
    private String message;
    private Long projectId;

    public static TaskDto fromTask(Task task){
        return new TaskDto(task.getId(),
                task.getStatus(),
                task.getImplementerType(),
                task.getMessage(),
                task.getProject().getId());
    }
}
