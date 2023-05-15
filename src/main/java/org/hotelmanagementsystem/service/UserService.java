package org.hotelmanagementsystem.service;

import org.hotelmanagementsystem.dao.UserDAO;
import org.hotelmanagementsystem.dto.RoomDetailsDTO;
import org.hotelmanagementsystem.dto.UserInfoDTO;
import org.hotelmanagementsystem.model.RoomDetails;
import org.hotelmanagementsystem.model.UserInfo;
import org.hotelmanagementsystem.security.PassEncoder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("userService")
public class UserService implements IUserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PassEncoder passwordEncoder;

    public String storeUser(UserInfoDTO userInfoDTO) {
        userInfoDTO.setPassword(passwordEncoder.encoder().encode(userInfoDTO.getPassword()));
        UserInfo userInfo = modelMapper.map(userInfoDTO, UserInfo.class);
        return userDAO.saveUser(userInfo);
    }

    public List<UserInfoDTO> userInfo() {
        return userDAO.getAllUserInfo().stream()
                .map(userInfo -> modelMapper.map(userInfo, UserInfoDTO.class))
                .collect(Collectors.toList());
    }

    public UserInfoDTO getUserInfoByEmail(String email) {
        UserInfo userInfo = userDAO.getUserByEmail(email);
        if (userInfo != null) {
            return modelMapper.map(userInfo, UserInfoDTO.class);
        }
        return null;
    }

    public String checkUser(String email, String keyword) {
        return userDAO.checkUser(email, keyword);
    }

    public String setPassword(String email, String password) {
        return userDAO.setPassword(email, passwordEncoder.encoder().encode(password));
    }
    
    
    ///////
    public String updateUser(UserInfoDTO userInfoDTO,String email) {
      //  UserInfo userDetails = modelMapper.map(userInfoDTO, UserInfo.class);
       // logger.info(REDIRECT_MESSAGE);
    	// UserInfo userDetails=getUserInfoByEmail(userInfoDTO.getEmail());
        return userDAO.updateUserDetails(userInfoDTO,email);
    }
    
    public List<String> userEmail() {
        return userDAO.getAllEmail();
    }
}
