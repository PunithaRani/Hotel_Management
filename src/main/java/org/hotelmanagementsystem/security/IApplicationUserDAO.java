package org.hotelmanagementsystem.security;

import org.hotelmanagementsystem.model.UserInfo;

public interface IApplicationUserDAO {
    UserInfo getUser(String username);
}
