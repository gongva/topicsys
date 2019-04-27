/**
 * @@company YIMAFU Co.
 * @copyright Copyright @2014, YIMAFU Co., Ltd. All right.
 * @version：1.0
 **/
package com.pzhu.topicsys.common.util;

import java.util.List;

import com.github.pagehelper.Page;

/**
 * Desc：带分页的返回格式
 */
public class PageResult {

    
	/**
	 * 当前页数
	 */
	private int page;
	
	/**
	 * 每页条数
	 */
	private int size;
	
	/**
	 * 总页数
	 */
	private int totalPage;
	
	/**
	 * 总记录数
	 */
	private Long totalCount;
	/**
	 * 记录
	 */
	private List<?> list;

	public PageResult() {
	}

	public PageResult(int page, int size, Page<?> list) {
		super();
        this.page = page;
        this.size = size;
		if (list != null) {
		    this.totalPage = list.getPages();
			this.totalCount = list.getTotal();
			this.list = list;
		}
	}

	/**
	 * @param total
	 * @param list
	 */
	public PageResult(Long total, List<?> list) {
		super();
		this.totalCount = total;
		this.list = list;
	}

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

}
