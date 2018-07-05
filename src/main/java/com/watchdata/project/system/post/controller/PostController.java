package com.watchdata.project.system.post.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.watchdata.framework.aspectj.lang.annotation.Log;
import com.watchdata.framework.aspectj.lang.constant.BusinessType;
import com.watchdata.framework.web.controller.BaseController;
import com.watchdata.framework.web.domain.AjaxResult;
import com.watchdata.framework.web.page.TableDataInfo;
import com.watchdata.project.system.post.domain.Post;
import com.watchdata.project.system.post.service.IPostService;

/**
 * 岗位信息操作处理
 * 
 * @author
 */
@Controller
@RequestMapping("/system/post")
public class PostController extends BaseController
{
    private String prefix = "system/post";

    @Autowired
    private IPostService postService;

    @RequiresPermissions("system:post:view")
    @GetMapping()
    public String operlog()
    {
        return prefix + "/post";
    }

    @RequiresPermissions("system:post:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Post post)
    {
        startPage();
        List<Post> list = postService.selectPostList(post);
        return getDataTable(list);
    }


    @RequiresPermissions("system:post:remove")
    @Log(title = "岗位管理", action = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            postService.deletePostByIds(ids);
            return success();
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    /**
     * 新增岗位
     */
    @Log(title = "岗位管理", action = BusinessType.INSERT)
    @RequiresPermissions("system:post:add")
    @GetMapping("/add")
    public String add(Model model)
    {
        return prefix + "/add";
    }

    /**
     * 修改岗位
     */
    @Log(title = "岗位管理", action = BusinessType.UPDATE)
    @RequiresPermissions("system:post:edit")
    @GetMapping("/edit/{postId}")
    public String edit(@PathVariable("postId") Long postId, Model model)
    {
        Post post = postService.selectPostById(postId);
        model.addAttribute("post", post);
        return prefix + "/edit";
    }

    /**
     * 保存岗位
     */
    @Log(title = "岗位管理", action = BusinessType.SAVE)
    @RequiresPermissions("system:post:save")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(Post post)
    {
        if (postService.savePost(post) > 0)
        {
            return success();
        }
        return error();
    }

}
