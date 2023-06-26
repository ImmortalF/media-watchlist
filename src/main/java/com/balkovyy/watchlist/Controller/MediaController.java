package com.balkovyy.watchlist.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balkovyy.watchlist.Entities.Media;
import com.balkovyy.watchlist.Service.MediaService;

@RestController
@RequestMapping("/api/media")
public class MediaController {

    private final MediaService mediaService;

    public MediaController(MediaService mediaService) {
        this.mediaService = mediaService;
    }

    // Get media by ID
    @GetMapping("/{mediaId}")
    public ResponseEntity<Media> getMedia(@PathVariable Long mediaId) {
        Media media = mediaService.getMediaById(mediaId);
        if (media != null) {
            return ResponseEntity.ok(media);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add new media
    @PostMapping
    public ResponseEntity<Media> addMedia(@RequestBody Media newMedia) {
        Media media = mediaService.addMedia(newMedia);
        return ResponseEntity.ok(media);
    }

    // Update media
    @PutMapping("/{mediaId}")
    public ResponseEntity<Media> updateMedia(
            @PathVariable Long mediaId,
            @RequestBody Media updatedMedia) {
        Media media = mediaService.updateMedia(mediaId, updatedMedia);
        if (media != null) {
            return ResponseEntity.ok(media);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete media
    @DeleteMapping("/{mediaId}")
    public ResponseEntity<Void> deleteMedia(@PathVariable Long mediaId) {
        boolean deleted = mediaService.deleteMedia(mediaId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
