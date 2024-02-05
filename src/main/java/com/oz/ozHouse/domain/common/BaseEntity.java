package com.oz.ozHouse.domain.common;


import java.sql.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;

@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yy/MM/dd")
	@Column(name = "regdate", updatable = false)
	private Date regDate;
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yy/MM/dd")
	@Column(name = "moddate")
	private Date modDate;
}
