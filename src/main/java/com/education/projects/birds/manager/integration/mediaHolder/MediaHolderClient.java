package com.education.projects.birds.manager.integration.mediaHolder;
import com.education.projects.birds.manager.integration.mediaHolder.dto.response.MediaDtoResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@FeignClient(
        name = "mediaHolder-client",
        url = "http://localhost:8081"
)
public interface MediaHolderClient {




    @PostMapping("/media")
    List<MediaDtoResp> getMedias();

    @GetMapping("/media/{id}")
    MediaDtoResp getMediasById(@PathVariable(value = "id") UUID id);

    @GetMapping("/mediaByIdList")
    List<MediaDtoResp> getMediasByIdList(@RequestParam(value = "uuidSet") Set<UUID> uuidSet);
}
