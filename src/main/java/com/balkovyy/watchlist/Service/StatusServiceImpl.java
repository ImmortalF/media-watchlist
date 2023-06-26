package com.balkovyy.watchlist.Service;

import org.springframework.stereotype.Service;

import com.balkovyy.watchlist.Entities.Media;
import com.balkovyy.watchlist.Entities.Status;
import com.balkovyy.watchlist.Entities.User;
import com.balkovyy.watchlist.Repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {

    private final StatusRepository statusRepository;

    public StatusServiceImpl(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public Status getStatusByUserAndMedia(Long userId, Long mediaId) {
        return statusRepository.findByUserIdAndMediaId(userId, mediaId).orElse(null);
    }

    @Override
    public Status updateStatus(Long userId, Long mediaId, Status updatedStatus) {
        Status existingStatus = statusRepository.findByUserIdAndMediaId(userId, mediaId).orElse(null);
        if (existingStatus != null) {
            // Perform the necessary updates to the existingStatus object
            existingStatus.setStatus(updatedStatus.getStatus());
            // Save the updated status
            return statusRepository.save(existingStatus);
        }
        return null;
    }

    @Override
    public boolean deleteStatus(Long userId, Long mediaId) {
        if (statusRepository.existsByUserIdAndMediaId(userId, mediaId)) {
            statusRepository.deleteByUserIdAndMediaId(userId, mediaId);
            return true;
        }
        return false;
    }

    @Override
    public Status addStatus(User user, Media media, Status newStatus) {
        newStatus.setUser(user);
        newStatus.setMedia(media);
        return statusRepository.save(newStatus);
    }
}
