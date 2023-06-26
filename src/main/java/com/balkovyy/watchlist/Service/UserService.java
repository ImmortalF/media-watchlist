package com.balkovyy.watchlist.Service;

import com.balkovyy.watchlist.Entities.User;

public interface UserService {

    User getUserById(Long userId);

    User updateUser(Long userId, User updatedUser);

    boolean deleteUser(Long userId);

}
