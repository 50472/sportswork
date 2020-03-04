package com.sportswork.sportswork.controller.admin;

import com.sportswork.sportswork.core.entity.Role;
import com.sportswork.sportswork.core.entity.Game;
import com.sportswork.sportswork.core.service.dto.PageDTO;
import com.sportswork.sportswork.core.service.impl.GameServiceImp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author dengwei
 * @date 2020/2/3 12:11
 * @description
 */
@Slf4j
@Controller("gameController")
public class GameController {
    @Resource
    private GameServiceImp gameServiceImp;

    @RequestMapping("/admin/game/list")
    @PreAuthorize("hasAnyRole('admin')")
    public String List(){
        return "/pages/view/admin/game/list";
    }

    @RequestMapping("/admin/game/getAllGames")
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public Object getAllGames(){
        return new PageDTO<Game>().toPageDTO(gameServiceImp.getAllGames());
    }

    @RequestMapping(value = "/admin/game/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String add(Game game) {
        gameServiceImp.addGame(game);
        return "success";
    }


    @RequestMapping(value = "/admin/game/edit", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String edit(Game game) {
        gameServiceImp.setGame(game);
        return "success";
    }

    @RequestMapping(value = "/admin/game/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyRole('admin')")
    @ResponseBody
    public String delete(@RequestParam String id) {
        gameServiceImp.deleteGame(id);
        return "true";
    }
}
