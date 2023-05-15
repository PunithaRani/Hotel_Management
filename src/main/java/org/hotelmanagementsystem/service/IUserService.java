package org.hotelmanagementsystem.service;

import org.hotelmanagementsystem.dto.UserInfoDTO;

import java.util.List;

public interface IUserService {
    String storeUser(UserInfoDTO userInfoDTO);
    List<UserInfoDTO> userInfo();
    UserInfoDTO getUserInfoByEmail(String email);
    String checkUser(String email, String keyword);
    String setPassword(String email, String password);
}
