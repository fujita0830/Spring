package com.fujita.springboot.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;

@Entity
@Table
public class Contents {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contents_id", nullable = false)
	private long contentsId;

	@Column(name = "account_id", nullable = false)
	private long accountId;

	@Column(name = "login_id", nullable = false)
	private String loginId;

	@Column(nullable = false)
	private String title;

	@Column
	@Pattern(regexp = "(https?|ftp)(:\\/\\/[-_.!~*\\'()a-zA-Z0-9;\\/?:\\@&=+\\$,%#]+)", message = "urlを入力してください")
	private String url;

	@Column(name = "read_status", nullable = false)
	private String readStatus;

	@Column(name = "share_status", nullable = false)
	private String shareStatus;

	@Column(name = "useful_category")
	private String usefulCategory;

	@Column
	private String tag;

	@Column
	private String comment;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "insert_date")
	private Date insertDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "update_date")
	private Date updateDate;

	@PrePersist
	public void prePersist() {
		Date date = new Date();
		insertDate = date;
		updateDate = date;
	}

	@PreUpdate
	public void preUpdate() {
		updateDate = new Date();
	}

	@ManyToOne
	public long getContentsId() {
		return contentsId;
	}

	public void setContentsId(long contentsId) {
		this.contentsId = contentsId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}

	public String getShareStatus() {
		return shareStatus;
	}

	public void setShareStatus(String shareStatus) {
		this.shareStatus = shareStatus;
	}

	public String getUsefulCategory() {
		return usefulCategory;
	}

	public void setUsefulCategory(String usefulCategory) {
		this.usefulCategory = usefulCategory;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
