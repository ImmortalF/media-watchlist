package com.balkovyy.watchlist.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.balkovyy.watchlist.Entities.Media;
import com.balkovyy.watchlist.Repository.MediaRepository;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    public MediaRepository mediaRepository;

    public MediaController(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Media>> searchMediaByName(@RequestParam("name") String name) {
        List<Media> mediaList = mediaRepository.findByNameContaining(name);
        if (!mediaList.isEmpty()) {
            return ResponseEntity.ok(mediaList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/searchByType")
    public ResponseEntity<List<Media>> searchMediaByType(@RequestParam("type") String type) {
        List<Media> mediaList = mediaRepository.findByType(type);
        if (!mediaList.isEmpty()) {
            return ResponseEntity.ok(mediaList);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
