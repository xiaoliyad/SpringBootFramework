package com.watchdata.project.monitor.logininfor.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.watchdata.framework.aspectj.lang.annotation.Log;
import com.watchdata.framework.aspectj.lang.constant.BusinessType;
import com.watchdata.framework.web.controller.BaseController;
import com.watchdata.framework.web.domain.AjaxResult;
import com.watchdata.framework.web.page.TableDataInfo;
import com.watchdata.project.monitor.logininfor.domain.Logininfor;
import com.watchdata.project.monitor.logininfor.service.ILogininforService;

/**
 * 系统访问记录
 * 
 * @author
 */
@Controller
@RequestMapping("/monitor/logininfor")
public class LogininforController extends BaseController
{
    private String prefix = "monitor/logininfor";

    @Autowired
    private ILogininforService logininforService;

    @RequiresPermissions("monitor:logininfor:view")
    @GetMapping()
    public String logininfor()
    {
        return prefix + "/logininfor";
    }

    @RequiresPermissions("monitor:logininfor:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Logininfor logininfor)
    {
        startPage();
        List<Logininfor> list = logininforService.selectLogininforList(logininfor);
        return getDataTable(list);
    }

    @RequiresPermissions("monitor:logininfor:remove")
    @Log(title = "登陆日志", action = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        int rows = logininforService.deleteLogininforByIds(ids);
        if (rows > 0)
        {
            return success();
        }
        return error();
    }
}
