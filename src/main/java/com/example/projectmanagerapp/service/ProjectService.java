package com.example.projectmanagerapp.service;

import com.example.projectmanagerapp.dto.ProjectDto;
import com.example.projectmanagerapp.entity.Project;
import com.example.projectmanagerapp.repository.ProjectRepository;
import com.example.projectmanagerapp.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    public void saveProject(ProjectDto projectDto){
        projectRepository.save(toProject(projectDto));
    }

    public List<Project> findAll(){
        return projectRepository.findByParent(null);
    }

    public Project findById(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    private Project toProject(ProjectDto projectDto){
        Project project = new Project();
        if (projectDto.getParentId()!=null)
            project.setParent(projectRepository.findById(projectDto.getParentId()).orElse(null));
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        return project;
    }

    public boolean userUpdateProject(ProjectDto projectDto, long id) {
        Project project = projectRepository.findById(id).orElse(null);
        if (project!=null){
            project.setName(projectDto.getName());
            if (projectDto.getParentId()!=null)
                project.setParent(projectRepository.findById(projectDto.getParentId()).orElse(null));
            projectRepository.save(project);
            return true;
        } else
            return false;
    }

    @Transactional
    public void deleteProject(Long id){
        Project project = projectRepository.findById(id).orElse(null);
        if (project==null)
            return;
        recursiveTaskDelete(project);
        projectRepository.deleteById(id);
    }

    private void recursiveTaskDelete(Project project){
        taskRepository.deleteByProject(project);
        for (Project childProject : project.getChildren())
            recursiveTaskDelete(childProject);
    }


}
