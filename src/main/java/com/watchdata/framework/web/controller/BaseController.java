package com.watchdata.framework.web.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.watchdata.common.utils.StringUtils;
import com.watchdata.common.utils.security.ShiroUtils;
import com.watchdata.framework.web.page.PageDomain;
import com.watchdata.framework.web.page.TableDataInfo;
import com.watchdata.framework.web.page.TableSupport;
import com.watchdata.project.system.user.domain.User;

/**
 * web层通用数据处理
 * 
 * @author 
 */
public class BaseController
{
    /**
     * 设置请求分页数据
     */
    protected void startPage()
    {
        PageDomain pageDomain = TableSupport.buildPageRequest();
        Integer pageNum = pageDomain.getPageNum();
        Integer pageSize = pageDomain.getPageSize();
        if (StringUtils.isNotNull(pageNum) && StringUtils.isNotNull(pageSize))
        {
            String orderBy = pageDomain.getOrderBy();
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    /**
     * 响应请求分页数据
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    protected TableDataInfo getDataTable(List<?> list)
    {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(new PageInfo(list).getTotal());
        return rspData;
    }

    public User getUser()
    {
        return ShiroUtils.getUser();
    }

    public void setUser(User user)
    {
        ShiroUtils.setUser(user);
    }

    public Long getUserId()
    {
        return getUser().getUserId();
    }

    public String getLoginName()
    {
        return getUser().getLoginName();
    }
}
