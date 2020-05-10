package com.sportswork.sportswork.controller;

/**
 * @author dengwei
 * @date 2020/2/3 13:53
 * @description
 */

import com.sportswork.sportswork.config.SecurityUserInfo;
import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.Teaching;
import com.sportswork.sportswork.core.entity.User;
import com.sportswork.sportswork.core.help.Menu;
import com.sportswork.sportswork.core.mapper.RoleMapper;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.dto.UserDTO;
import com.sportswork.sportswork.core.service.impl.MenuServiceImp;
import com.sportswork.sportswork.core.service.impl.RoleServiceImp;
import com.sportswork.sportswork.core.service.impl.TeachingServiceImp;
import com.sportswork.sportswork.core.service.impl.UserServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
public class HomeController {
    @Resource
    private UserServiceImp userServiceImp;
    @Resource
    private MenuServiceImp menuServiceImp;
    @Resource
    private TeachingServiceImp teachingServiceImp;

    @RequestMapping({"/", "/index"})
    public String index(HttpServletRequest httpServletRequest,Model model) {
        if(httpServletRequest.getRemoteUser() == null) {
            return "pages/login";
        } else {
            return "pages/index";
        }
    }

    @RequestMapping({"/details"})
    public String details() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User user = userServiceImp.getUserByUsername(userDetails.getUsername());
        if(user.getRoleCode().equals("ROLE_teacher")) {
            return "redirect:/teacher/details";
        } else if(user.getRoleCode().equals("ROLE_student")){
            return "redirect:/student/details";
        }
        return "pages/view/home";
    }

    @RequestMapping({"/home"})
    public String home() {
        return "pages/view/home";
    }

    @RequestMapping({"/test"})
    public String test() {
        return "pages/test";
    }

    @RequestMapping("/404")
    public String error() {
        return "pages/error404";
    }

    @RequestMapping("/login")
    public String login(){
        return "pages/login";
    }

    @RequestMapping("/register")
    public String register(Model model){
        return "pages/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doRegister(UserDTO userDTO){
        // 此处省略校验逻辑
        userDTO.setRoleCode("ROLE_user");
        if (userServiceImp.addUser(userDTO)) {
            log.info("自动登陆成功，登陆账户：" + userDTO.getUsername());
            User user = userServiceImp.getUserByUsername(userDTO.getUsername());
            SecurityUserInfo userInfo = new SecurityUserInfo(user, true, true, true);
            Authentication auth = new UsernamePasswordAuthenticationToken(userInfo, userInfo.getPassword(), userInfo.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            return "redirect:/home";
        }
        return "redirect:/register?error";
    }

    @RequestMapping(value = "/session/invalid")
    public String sessionInvalid(Model model, HttpServletRequest req) {
        model.addAttribute("url", "/login");
        return "pages/session_invalid";
    }

    @RequestMapping("/menu")
    @PreAuthorize("permitAll()")
    @ResponseBody
    public List<Menu> getMenu(){
        List<Menu> menuList = new ArrayList<>();
        SecurityUserInfo userDetails = (SecurityUserInfo) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String rolesName = userDetails.getRoleCode();
        String[] strings = rolesName.split(",");
        for(String roleName : strings) {
            menuList.addAll(menuServiceImp.getFirstLevelMenusByRoleName(roleName));
        }
        return menuList;
    }

    @RequestMapping("/getTimeAxes")
    @ResponseBody
    public Object getTimeAxes(String timeDate) {
        int week = getWeek(timeDate);
        return new PageDTO<Teaching>().toPageDTO(
                teachingServiceImp.getTeachingsByWeek(week));
    }

    /**
     * 1-7表示 星期日至星期六
     * @param dates
     * @return
     */
    public int getWeek(String dates)
    {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Date d=null;
        try {
            d=f.parse(dates);
        } catch (ParseException e) {

            e.printStackTrace();
        }
        cal.setTime(d);
        int w=cal.get(Calendar.DAY_OF_WEEK)-1;
        return w+1;
    }
}

