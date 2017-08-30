package cn.jbit.news.bean;

/**
 * 分页包装类
 * @author Administrator
 *
 */
public class PageInfo {
	private int currentPage;
	private int pageCount;
	private PageInfo(int page,int count){
		if(page<1)page=1;
		if(page>count)page=count;
		currentPage = page;
		pageCount = count;
	};
	private PageInfo(int count){
		this(1, count);
	};
	public static PageInfo valueOf(int count) {
		return new PageInfo(count);
	}
	public static PageInfo valueOf(int page,int count) {
		return new PageInfo(page,count);
	}
	public PageInfo getNextPage() {
		return valueOf(currentPage+1,pageCount);
	}
	public PageInfo getPrevPage() {
		return valueOf(currentPage-1,pageCount);
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getEndPage() {
		return pageCount;
	}
}
