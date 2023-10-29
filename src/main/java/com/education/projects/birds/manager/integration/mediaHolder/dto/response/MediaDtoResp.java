package com.education.projects.birds.manager.integration.mediaHolder.dto.response;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.Instant;
import java.util.UUID;
import org.springframework.core.io.Resource;
public class MediaDtoResp  {

    @Schema(name = "id", description = "File ID", example = "c8d385d8-652d-4851-b015-5aa94a8ffe19")
    private UUID id;
    @Schema(name="time",description = "Upload time", example = "2023-09-24T08:10:19.270612Z")
    private Instant uploadTime;

    @Schema(name="name",description = "File nickname", example = "Media1")
    public String name;

    @Schema(name="file description", description = "File description", example = "Very interesting media")
    public String description;


    @Schema(name="type",description = "Type of media: 1 - IMG, 2 - AUD, 3 - VID", example = "2")
    public int type;

    @Schema(name="file name",description = "File name", example = "whistle12345.wav")
    public String fileName;


    @Schema(name="file size", description = "File size", example = "12345")
    public long fileSize;

    @Schema(name ="file body", description = "File body")
    public Resource fileBody;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Instant uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public Resource getFileBody() {
        return fileBody;
    }

    public void setFileBody(Resource fileBody) {
        this.fileBody = fileBody;
    }
}