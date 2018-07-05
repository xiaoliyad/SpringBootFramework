package com.watchdata.project.system.dict.controller;

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
import com.watchdata.project.system.dict.domain.DictType;
import com.watchdata.project.system.dict.service.IDictTypeService;

/**
 * 数据字典信息
 * 
 * @author
 */
@Controller
@RequestMapping("/system/dict")
public class DictTypeController extends BaseController
{
    private String prefix = "system/dict/type";

    @Autowired
    private IDictTypeService dictTypeService;

    @RequiresPermissions("system:dict:view")
    @GetMapping()
    public String dictType()
    {
        return prefix + "/type";
    }

    @PostMapping("/list")
    @RequiresPermissions("system:dict:list")
    @ResponseBody
    public TableDataInfo list(DictType dictType)
    {
        startPage();
        List<DictType> list = dictTypeService.selectDictTypeList(dictType);
        return getDataTable(list);
    }

    /**
     * 修改字典类型
     */
    @Log(title = "字典类型", action = BusinessType.UPDATE)
    @RequiresPermissions("system:dict:edit")
    @GetMapping("/edit/{dictId}")
    public String edit(@PathVariable("dictId") Long dictId, Model model)
    {
        DictType dict = dictTypeService.selectDictTypeById(dictId);
        model.addAttribute("dict", dict);
        return prefix + "/edit";
    }

    /**
     * 新增字典类型
     */
    @Log(title = "字典类型", action = BusinessType.INSERT)
    @RequiresPermissions("system:dict:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 保存字典类型
     */
    @Log(title = "字典类型", action = BusinessType.SAVE)
    @RequiresPermissions("system:dict:save")
    @PostMapping("/save")
    @ResponseBody
    public AjaxResult save(DictType dict)
    {
        if (dictTypeService.saveDictType(dict) > 0)
        {
            return success();
        }
        return error();
    }

    @Log(title = "字典类型", action = BusinessType.DELETE)
    @RequiresPermissions("system:dict:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        int rows = dictTypeService.deleteDictTypeByIds(ids);
        if (rows > 0)
        {
            return success();
        }
        return error();
    }

    /**
     * 查询字典详细
     */
    @RequiresPermissions("system:dict:list")
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") Long dictId, Model model)
    {
        DictType dict = dictTypeService.selectDictTypeById(dictId);
        model.addAttribute("dict", dict);
        return "system/dict/data/data";
    }

    /**
     * 校验字典类型
     */
    @PostMapping("/checkDictTypeUnique")
    @ResponseBody
    public String checkDictTypeUnique(DictType dictType)
    {
        String uniqueFlag = "0";
        if (dictType != null)
        {
            uniqueFlag = dictTypeService.checkDictTypeUnique(dictType);
        }
        return uniqueFlag;
    }
}
