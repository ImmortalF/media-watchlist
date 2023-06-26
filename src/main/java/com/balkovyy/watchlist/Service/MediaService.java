package com.balkovyy.watchlist.Service;

import com.balkovyy.watchlist.Entities.Media;

public interface MediaService {

    Media getMediaById(Long mediaId);

    Media addMedia(Media newMedia);

    Media updateMedia(Long mediaId, Media updatedMedia);

    boolean deleteMedia(Long mediaId);

}
