package com.example.projectmanagerapp.service;

import com.example.projectmanagerapp.dto.TaskDto;
import com.example.projectmanagerapp.entity.AppUser;
import com.example.projectmanagerapp.entity.Project;
import com.example.projectmanagerapp.entity.Status;
import com.example.projectmanagerapp.entity.Task;
import com.example.projectmanagerapp.repository.ProjectRepository;
import com.example.projectmanagerapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ProjectRepository projectRepository;

    public void userCreateTask(TaskDto taskDto) {
        Task task = toTask(taskDto);
        task.setCreateDate(new Date());
        task.setModifyDate(new Date());
        task.setAuthor(getCurrentUser());
        taskRepository.save(task);
    }

    private AppUser getCurrentUser(){
        return (AppUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    private Task toTask(TaskDto taskDto){
        Task task = new Task();
        task.setStatus(taskDto.getStatus());
        task.setImplementerType(taskDto.getImplementerType());
        task.setMessage(taskDto.getMessage());
        Project project = projectRepository.findById(taskDto.getProjectId()).orElse(null);
        task.setProject(project);
        return task;
    }


    public boolean userUpdateTaskStatus(long id, Status status) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            if (!task.getStatus().equals(status))
                task.setModifyDate(new Date());
            task.setStatus(status);
            taskRepository.save(task);
            return true;
        } else
            return false;
    }

    public boolean userDeleteTask(long id) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task!=null && task.getAuthor().getUsername().equals(getCurrentUser().getUsername())){
            taskRepository.deleteById(id);
            return true;
        } else
            return false;
    }

    public List<TaskDto> findTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream().map(TaskDto::fromTask).toList();

    }

    public boolean adminUpdateTask(long id, TaskDto taskDto) {
        Task task = taskRepository.findById(id).orElse(null);
        if (task != null) {
            if (!task.getStatus().equals(taskDto.getStatus()))
                task.setModifyDate(new Date());
            task.setStatus(taskDto.getStatus());
            task.setMessage(taskDto.getMessage());
            task.setImplementerType(taskDto.getImplementerType());
            Project project = projectRepository.findById(taskDto.getProjectId()).orElse(null);
            task.setProject(project);
            taskRepository.save(task);
            return true;
        } else
            return false;
    }

    public void adminDeleteTask(long id) {
        taskRepository.deleteById(id);
    }
}
