package com.example.projectmanagerapp.controller;

import com.example.projectmanagerapp.dto.ProjectDto;
import com.example.projectmanagerapp.entity.Project;
import com.example.projectmanagerapp.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Иерархическая структура проектов и подпроектов.
// Создавать, редактировать, удалять может админ.


@RestController
@RequiredArgsConstructor
public class ProjectController {
    // Получить структуру может любой пользователь.
    private final ProjectService projectService;
    @GetMapping("user/projects")
    public List<Project> findAll(){
        return projectService.findAll();
    }

    // Создавать, редактировать, удалять может админ.
    @PostMapping("admin/projects")
    public HttpStatus addProject(@RequestBody ProjectDto projectDto){
        projectService.saveProject(projectDto);
        return HttpStatus.CREATED;
    }

    @PutMapping("admin/projects/{id}")
    public HttpStatus update(@PathVariable("id") long id, @RequestBody ProjectDto projectDto) {
        final boolean updated = projectService.userUpdateProject(projectDto, id);
        return updated ? HttpStatus.OK : HttpStatus.NOT_MODIFIED;
    }

    @DeleteMapping("admin/projects/{id}")
    public HttpStatus delete(@PathVariable("id") long id){
        projectService.deleteProject(id);
        return HttpStatus.OK;
    }




}
