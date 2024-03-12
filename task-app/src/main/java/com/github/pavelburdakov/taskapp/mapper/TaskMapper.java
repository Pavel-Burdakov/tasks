package com.github.pavelburdakov.taskapp.mapper;

import com.github.pavelburdakov.taskapp.entity.Task;
import com.github.pavelburdakov.taskapp.web.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface TaskMapper {

    Task toEntity(TaskDto taskDto);

    List<Task> toEntityList(List<TaskDto> tasks);

    TaskDto toDto(Task task);

    List<TaskDto> toDtoList(List<Task> tasks);

}
