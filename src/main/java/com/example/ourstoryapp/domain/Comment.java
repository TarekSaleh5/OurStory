package com.example.ourstoryapp.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity

public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "memory")
	private Memory memory;

	@ManyToOne
	@JoinColumn(name = "users")
	private User users;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(name = "tag_in_comment", joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "tag_name", referencedColumnName = "tag_name"))
	private Set<Tag> tags;
	
	private Date createDate;
	private String text;



	public Comment() {
		// super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Memory memory, Date createDate, User users, String text) {
		super();
		this.memory = memory;
		this.createDate = createDate;
		this.users = users;
		this.text = text;
	}

	public Comment(Memory memory, Date d2, String text) {
		super();
		this.memory = memory;
		this.createDate = d2;
		this.text = text;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return users;
	}

	public void setUser(User users) {
		this.users = users;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Memory getMemory() {
		return memory;
	}

	public void setMemory(Memory memory) {
		this.memory = memory;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
