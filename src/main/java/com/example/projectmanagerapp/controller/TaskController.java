package com.example.projectmanagerapp.controller;


import com.example.projectmanagerapp.dto.TaskDto;
import com.example.projectmanagerapp.entity.Status;
import com.example.projectmanagerapp.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Любой пользователь может создать задачу для любого уровня проекта\подпроекта,
// изменить статус, удалить свою задачу, посмотреть все задачи.
// Любой администратор может редактировать, удалить задачу.

@RestController
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    @PostMapping("user/tasks")
    public HttpStatus userCreateTask(@RequestBody TaskDto taskDto){
        taskService.userCreateTask(taskDto);
        return HttpStatus.CREATED;
    }

    @PutMapping("user/tasks/{id}")
    public HttpStatus userUpdateTaskStatus(@PathVariable("id") long id, @RequestBody Status status){
        final boolean updated = taskService.userUpdateTaskStatus(id, status);
        return updated ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping("user/tasks/{id}")
    public HttpStatus userDelete(@PathVariable("id") long id){
        final boolean deleted = taskService.userDeleteTask(id);
        return deleted ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }

    @GetMapping("user/tasks")
    public List<TaskDto> userFindTasks(){
        return taskService.findTasks();
    }

    @PutMapping("admin/tasks/{id}")
    public HttpStatus adminUpdateTask(@PathVariable("id") long id, @RequestBody TaskDto taskDto){
        final boolean updated = taskService.adminUpdateTask(id, taskDto);
        return updated ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping("admin/tasks/{id}")
    public HttpStatus userDeleteTask(@PathVariable("id") long id){
        taskService.adminDeleteTask(id);
        return HttpStatus.OK;
    }


}
