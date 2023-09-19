package com.education.projects.birds.manager.mapper;
import com.education.projects.birds.manager.dto.request.BirdDtoReq;
import com.education.projects.birds.manager.dto.response.BirdDtoResp;
import com.education.projects.birds.manager.entity.Bird;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BirdMapper {
    BirdDtoResp birdToBirdDto(Bird bird);
    Bird birdDtoToBird(BirdDtoReq birdDtoReq);
    List<BirdDtoResp> birdListToBirdDtoList(List<Bird> birds);
}
