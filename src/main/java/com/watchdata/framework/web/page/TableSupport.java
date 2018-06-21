package com.watchdata.framework.web.page;

import com.watchdata.common.utils.ServletUtils;
import com.watchdata.common.constant.Constants;

/**
 * 表格数据处理
 * 
 * @author ruoyi
 */
public class TableSupport
{
    /**
     * 封装分页对象
     */
    public static PageDomain getPageDomain()
    {
        PageDomain pageDomain = new PageDomain();
        pageDomain.setPageNum(ServletUtils.getIntParameter(Constants.PAGENUM));
        pageDomain.setPageSize(ServletUtils.getIntParameter(Constants.PAGESIZE));
        pageDomain.setOrderByColumn(ServletUtils.getStrParameter(Constants.ORDERBYCOLUMN));
        pageDomain.setIsAsc(ServletUtils.getStrParameter(Constants.ISASC));
        return pageDomain;
    }

    public static PageDomain buildPageRequest()
    {
        return getPageDomain();
    }

}
