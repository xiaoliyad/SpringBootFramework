package com.watchdata.project.system.user.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.watchdata.framework.config.SystemConfig;
import com.watchdata.framework.web.controller.BaseController;
import com.watchdata.project.system.menu.domain.Menu;
import com.watchdata.project.system.menu.service.IMenuService;
import com.watchdata.project.system.user.domain.User;

/**
 * 首页 业务处理
 * 
 * @author 
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    @Autowired
    private SystemConfig systemConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(Model model)
    {
        // 取身份信息
        User user = getUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUserId(user.getUserId());
        model.addAttribute("menus", menus);
        model.addAttribute("user", user);
        model.addAttribute("copyrightYear", systemConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(Model model)
    {
        model.addAttribute("version", systemConfig.getVersion());
        return "main";
    }

}
