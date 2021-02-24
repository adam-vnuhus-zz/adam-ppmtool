package com.adamvnuhus.ppmtool.services;

import com.adamvnuhus.ppmtool.domain.Backlog;
import com.adamvnuhus.ppmtool.domain.Project;
import com.adamvnuhus.ppmtool.domain.ProjectTask;
import com.adamvnuhus.ppmtool.exceptions.ProjectNotFoundException;
import com.adamvnuhus.ppmtool.repositories.BacklogRepository;
import com.adamvnuhus.ppmtool.repositories.ProjectRepository;
import com.adamvnuhus.ppmtool.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ppmtool
 *
 * @author anhdt
 * @created_at 19/02/2021 - 5:12 PM
 * @created_by anhdt
 * @since 19/02/2021
 */
@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){

        //Exception: Project not found

        /*
        {
            ProjectNotFound: "Project not found"
        }
         */

        try {
            //PTs to be added to a specific project, project != null, BL exists
            Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
            //Set the backlog to the projectTask
            projectTask.setBacklog(backlog);
            //we want our project sequence to be like this: IDPRO-1 IDPRO-2 ...100
            Integer BacklogSequence = backlog.getPTSequence();
            //Update the BL SEQUENCE
            BacklogSequence++;

            backlog.setPTSequence(BacklogSequence);

            //Add Sequence to Project Task
            projectTask.setProjectSequence(projectIdentifier + "-" + BacklogSequence);
            projectTask.setProjectIdentifier(projectIdentifier);

            //INITIAL priority when priority null
//        if (projectTask.getPriority() == 0 || projectTask.getPriority() == null) {
//            projectTask.setPriority(3);
//        }
            //INITIAL status when status is null
            //projectTask.getStatus()==null cannot call func equals()
            if (projectTask.getStatus() == null || projectTask.getStatus().equals("")) {
                projectTask.setStatus("TO_DO");
            }

            if (projectTask.getPriority() == null || projectTask.getPriority()==0) { //In the future we need projectTask.getPriority() == 0 to handle the form
                projectTask.setPriority(3);
            }

            return projectTaskRepository.save(projectTask);
        } catch (Exception e){
            throw new ProjectNotFoundException("Project not Found!!!");
        }


    }

    public Iterable<ProjectTask> findBacklogById(String id){

        Project project = projectRepository.findByProjectIdentifier(id);

        if (project == null) {
            throw new ProjectNotFoundException("Project with ID: '" + id + "' does not exist!!!");
        }

        return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
    }

    public ProjectTask findPTByProjectSequence(String backlog_id, String pt_id){

        //make sure we are searching on the right backlog
        Backlog backlog = backlogRepository.findByProjectIdentifier(backlog_id);
        if (backlog == null) {
            throw new ProjectNotFoundException("Project with ID: '" + backlog_id + "' does not exist!!!");
        }
        //make sure that our task exists
        ProjectTask projectTask = projectTaskRepository.findByProjectSequence(pt_id);

        if (projectTask == null) {
            throw new ProjectNotFoundException("Project Task: '" + pt_id + "' not found!!!");
        }
        //make sure that the backlog/project id in the path correspond to the right project
        if (!projectTask.getProjectIdentifier().equals(backlog_id)) {
            throw new ProjectNotFoundException("Project Task '" + pt_id + "' does not exist in project: '" + backlog_id);
        }

        return projectTask;
    }

    public ProjectTask updateByProjectSequence(ProjectTask updateTask, String backlog_id, String pt_id){

        ProjectTask projectTask = findPTByProjectSequence(backlog_id,pt_id);

        projectTask = updateTask;

        return projectTaskRepository.save(projectTask);
    }

    public void deletePTByProjectSequence(String backlog_id, String pt_id){
        ProjectTask projectTask = findPTByProjectSequence(backlog_id, pt_id);

//        Backlog backlog = projectTask.getBacklog();
//        List<ProjectTask> pts = backlog.getProjectTasks();
//        pts.remove(projectTask);
//        backlogRepository.save(backlog);

        projectTaskRepository.delete(projectTask);
    }
}
