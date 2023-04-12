package com.example.projectmanagerapp.dto;

import com.example.projectmanagerapp.entity.Project;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDto {

    private Long parentId;
    private String name;
    private String description;

    public static ProjectDto fromProject(Project project){
        ProjectDto projectDto = new ProjectDto();
        projectDto.setParentId(project.getId());
        projectDto.setName(projectDto.getName());
        projectDto.setDescription(projectDto.getDescription());
        return projectDto;
    }



}
