package com.balkovyy.watchlist.Service;

import org.springframework.stereotype.Service;

import com.balkovyy.watchlist.Entities.Media;
import com.balkovyy.watchlist.Repository.MediaRepository;

@Service
public class MediaServiceImpl implements MediaService {

    private final MediaRepository mediaRepository;

    public MediaServiceImpl(MediaRepository mediaRepository) {
        this.mediaRepository = mediaRepository;
    }

    @Override
    public Media getMediaById(Long mediaId) {
        return mediaRepository.findById(mediaId).orElse(null);
    }

    @Override
    public Media addMedia(Media newMedia) {
        return mediaRepository.save(newMedia);
    }

    @Override
    public Media updateMedia(Long mediaId, Media updatedMedia) {
        Media existingMedia = mediaRepository.findById(mediaId).orElse(null);
        if (existingMedia != null) {
            // Perform the necessary updates to the existingMedia object
            existingMedia.setName(updatedMedia.getName());
            existingMedia.setDescription(updatedMedia.getDescription());
            existingMedia.setType(updatedMedia.getType());
            // Save the updated media
            return mediaRepository.save(existingMedia);
        }
        return null;
    }

    @Override
    public boolean deleteMedia(Long mediaId) {
        if (mediaRepository.existsById(mediaId)) {
            mediaRepository.deleteById(mediaId);
            return true;
        }
        return false;
    }
}
