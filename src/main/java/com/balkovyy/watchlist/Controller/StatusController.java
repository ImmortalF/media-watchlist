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

import com.balkovyy.watchlist.Entities.Status;
import com.balkovyy.watchlist.Service.StatusService;

@RestController
@RequestMapping("/api/status")
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    // Get status by user and media
    @GetMapping("/{userId}/{mediaId}")
    public ResponseEntity<Status> getStatusByUserAndMedia(
            @PathVariable Long userId,
            @PathVariable Long mediaId) {
        Status status = statusService.getStatusByUserAndMedia(userId, mediaId);
        if (status != null) {
            return ResponseEntity.ok(status);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Update status
    @PutMapping("/{userId}/{mediaId}")
    public ResponseEntity<Status> updateStatus(
            @PathVariable Long userId,
            @PathVariable Long mediaId,
            @RequestBody Status updatedStatus) {
        Status status = statusService.updateStatus(userId, mediaId, updatedStatus);
        if (status != null) {
            return ResponseEntity.ok(status);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete status
    @DeleteMapping("/{userId}/{mediaId}")
    public ResponseEntity<Void> deleteStatus(
            @PathVariable Long userId,
            @PathVariable Long mediaId) {
        boolean deleted = statusService.deleteStatus(userId, mediaId);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /*
     * // Add new status
     * 
     * @PostMapping("/{userId}/{mediaId}")
     * public ResponseEntity<Status> addStatus(
     * 
     * @PathVariable Long userId,
     * 
     * @PathVariable Long mediaId,
     * 
     * @RequestBody Status newStatus) {
     * Status status = statusService.addStatus(userId, mediaId, newStatus);
     * if (status != null) {
     * return ResponseEntity.ok(status);
     * } else {
     * return ResponseEntity.notFound().build();
     * }
     * }
     */
}
