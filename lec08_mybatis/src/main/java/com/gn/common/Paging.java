package com.gn.common;

public class Paging {
	
	//전체 게시글 개수 
	private int totalData;
	//전체 페이지 개수
	private int totalPage;
	//페이징바에 구성요소들 (12345)
	private int pageBarSize = 5;
	//페이징바에 시작,끝
	private int pageBarStart;
	private int pageBarEnd;
	
	//현재 페이지 (1인 이유 무조건 들어오면 1번 페이지여서)
	private int nowPage=1;
	// 목록에 보여질 게시글 개수(1번 부터 10번이 보임)
	private int numPerPage = 10;
	// 쿼리에 사용할 LIMIT 값 : 쿼리가 나온 이유 
	// LIMIT 10,10 = 11부터 20임 페이지수는 2임
	private int limitPageNo;
	
	//이전, 다음 여부
	private boolean prev = true;
	private boolean next = true;
	
	public int getTotalData() {
		return totalData;
	}
	public void setTotalData(int totalData) {
		this.totalData = totalData;
		calcPaging();
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageBarSize() {
		return pageBarSize;
	}
	public void setPageBarSize(int pageBarSize) {
		this.pageBarSize = pageBarSize;
	}
	public int getPageBarStart() {
		return pageBarStart;
	}
	public void setPageBarStart(int pageBarStart) {
		this.pageBarStart = pageBarStart;
	}
	public int getPageBarEnd() {
		return pageBarEnd;
	}
	public void setPageBarEnd(int pageBarEnd) {
		this.pageBarEnd = pageBarEnd;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getNumPerPage() {
		return numPerPage;
	}
	public void setNumPerPage(int numPerPage) {
		this.numPerPage = numPerPage;
	}
	public int getLimitPageNo() {
		return limitPageNo;
	}
	public void setLimitPageNo(int limitPageNo) {
		this.limitPageNo = limitPageNo;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	
	//전체 게시글 개수 set 해줬을때 동작한 메소드
	private void calcPaging( ) {
		//1. 2번 페이지(11~20) 보고싶을때 -> 10,10 앞에 있는 10은 offset 변경 해줘야함
		//2. 3번 페이지(21~30) -> 20,10
		limitPageNo = (nowPage-1)*numPerPage;
		//전체 페이지 개수 만일 내가 가지고 있는 데이터가 26개이면 ->3개의 페이지가 있음 
		// 26/10 -> 몫 -> 26개를 10 개씩 묶었을 떄 몇 몪음? ->2 그래서 2.6에서 올리 해야함
		totalPage = (int)Math.ceil((double)totalData/numPerPage);
		// 페이지바 구성 어디서부터 시작 할껀지 now페이지로 생각하기
		
		// 3번페이지에 있음 -> 1번
		// 8번페이지 -> 6번
		pageBarStart = ((nowPage-1)/pageBarSize)*pageBarSize+1; 
		// 전체 페이지가 3밖에 없을 때
		pageBarEnd = pageBarStart + pageBarSize-1;
		if(pageBarEnd > totalPage) pageBarEnd = totalPage;
		
		// 이전과 다음 구성 1번페이지가 스타트가 아니면 이전이 없음\
		if(pageBarStart == 1) prev = false;
		// 내가 가진 페이지가 5 이면 다음은 없음을 뜻함
		if(pageBarEnd >= totalPage) next = false;
		
		
		
	}
	
	
}
