package com.in.market.commons.page;

/**
 * @author TheSevenSky
 */
public class DefaultPageSizeInfo {
    /**
     * 默认的分页大小
     */
    private static final int DEFAULT_PAGE_SIZE = 10;
    /**
     * 默认的分页起始页
     */
    private static final int DEFAULT_PAGE_NUM = 1;

    private static final int DEFAULT_HOT_PAGE_SIZE = 6;

    private static int pageSize = DEFAULT_PAGE_SIZE;
    private static int pageNum = DEFAULT_PAGE_NUM;

    public static int getDefaultPageSize() {
        return DEFAULT_PAGE_SIZE;
    }

    public static int getDefaultPageNum() {
        return DEFAULT_PAGE_NUM;
    }

    public static int getPageSize() {
        return pageSize;
    }

    public static void setPageSize(int pageSize) {
        DefaultPageSizeInfo.pageSize = pageSize;
    }

    public static int getPageNum() {
        return pageNum;
    }

    public static void setPageNum(int pageNum) {
        DefaultPageSizeInfo.pageNum = pageNum;
    }

    public static int getDefaultHotPageSize() {
        return DEFAULT_HOT_PAGE_SIZE;
    }
}
