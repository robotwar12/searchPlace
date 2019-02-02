package com.place.domain;
 
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class TrendKeyword {

	@Id
	@GeneratedValue
	private Long keywordId;

	@Column
	private String keyword;

	@Column
	private int keywordSearchCount = 1;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date InsertDate;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date UpdateDate;

	public Long getKeywordId() {
		return keywordId;
	}

	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getKeywordSearchCount() {
		return keywordSearchCount;
	}

	public void setKeywordSearchCount(int keywordSearchCount) {
		this.keywordSearchCount = keywordSearchCount;
	}

	public Date getInsertDate() {
		return InsertDate;
	}

	public void setInsertDate(Date insertDate) {
		InsertDate = insertDate;
	}

	public Date getUpdateDate() {
		return UpdateDate;
	}

	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}

	@Override
	public String toString() {
		return "TrandKeyword [keywordId=" + keywordId + ", keyword=" + keyword + ", keywordSearchCount="
				+ keywordSearchCount + ", InsertDate=" + InsertDate + ", UpdateDate=" + UpdateDate + "]";
	}

}
