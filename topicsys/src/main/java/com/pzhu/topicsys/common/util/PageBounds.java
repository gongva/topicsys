package com.pzhu.topicsys.common.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.RowBounds;

/**
 * 分页查询对象
 */
public class PageBounds implements Serializable {

	private static final long serialVersionUID = -6414350656252331011L;

	public static final int NO_ROW_OFFSET = 1;
	public static final int NO_ROW_LIMIT = 10;

	/** 页号 */
	private int page = NO_ROW_OFFSET;
	/** 分页大小 */
	private int size = NO_ROW_LIMIT;
	/** 分页排序信息 */
	protected List<Order> orders = new ArrayList<Order>();

	public PageBounds() {
	}

	public PageBounds(int page, int size) {
		this.page = page;
		this.size = size;
	}

	public PageBounds(Order... order) {
		this(NO_ROW_OFFSET, NO_ROW_LIMIT, order);
	}

	public PageBounds(int page, int size, Order... order) {
		this(page, size, Arrays.asList(order));
	}

	public PageBounds(int page, int size, List<Order> orders) {
		this.page = page;
		this.size = size;
		this.orders = orders;
	}

	public RowBounds toRowBounds() {
		int offset = 0;
		if (this.page > 0) {
			offset = (this.page - 1) * this.size;
		}
		return new RowBounds(offset, this.size);
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

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

	
}