package org.hotelmanagementsystem.security;

import org.apache.log4j.Logger;
import org.hotelmanagementsystem.dto.UserInfoDTO;
import org.hotelmanagementsystem.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserDetailsService implements UserDetailsService {

    private static Logger logger = Logger.getLogger(ApplicationUserDetailsService.class);

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PassEncoder passEncoder;

    @Autowired 
    private BookingService book;
    @Autowired
    private ApplicationUserDAO applicationUserDAO;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        logger.info("Entering into Application User DAO");
        UserInfoDTO userInfo = modelMapper.map(applicationUserDAO.getUser(s), UserInfoDTO.class);
        logger.info(applicationUserDAO.getUser(s));
        if (userInfo == null) {
            logger.error("username is not in the database");
            throw new UsernameNotFoundException("username is not in the database");
        }
      
        book.setuserEmail(userInfo.getEmail());
        System.out.print(userInfo.getEmail());
        
        return new ApplicationUser(
                userInfo
        );
    }
}
