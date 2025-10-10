package com.github.cawtoz.enfokids.mapper;

import com.github.cawtoz.enfokids.dto.request.ChildRequest;
import com.github.cawtoz.enfokids.dto.response.ChildResponse;
import com.github.cawtoz.enfokids.generic.GenericMapper;
import com.github.cawtoz.enfokids.model.user.types.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = UserMapper.class)
public interface ChildMapper extends GenericMapper<Child, ChildRequest, ChildResponse> {
    
    @Override
    @Mapping(target = "roles", source = "roles", qualifiedByName = "rolesToRoleEnums")
    ChildResponse toResponse(Child entity);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    Child toEntity(ChildRequest request);
    
    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    void updateEntityFromRequest(ChildRequest request, @MappingTarget Child entity);
}
