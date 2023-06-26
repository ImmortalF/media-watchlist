package com.balkovyy.watchlist.Service;

import com.balkovyy.watchlist.Entities.Media;
import com.balkovyy.watchlist.Entities.Status;
import com.balkovyy.watchlist.Entities.User;

public interface StatusService {

    Status getStatusByUserAndMedia(Long userId, Long mediaId);

    Status updateStatus(Long userId, Long mediaId, Status updatedStatus);

    boolean deleteStatus(Long userId, Long mediaId);

    Status addStatus(User user, Media media, Status newStatus);
}
