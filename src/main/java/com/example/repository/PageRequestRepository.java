package com.example.repository;

import java.util.Objects;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PageRequestRepository {

	private Integer pageNo = 0;
	private Integer pageSize = 2;

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Pageable getPageable(PageRequestRepository dto) {

		Integer page = Objects.nonNull(dto.getPageNo()) ? dto.getPageNo() : this.pageNo;
		Integer size = Objects.nonNull(dto.getPageSize()) ? dto.getPageSize() : this.pageSize;

		PageRequest request = PageRequest.of(page, size);
		return request;
	}

}
