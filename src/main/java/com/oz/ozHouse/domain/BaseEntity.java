package com.oz.ozHouse.domain;

import java.time.LocalDateTime;

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
abstract class BaseEntity {
	@CreatedDate
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	@Column(name = "regdate", updatable = false)
	private LocalDateTime regDate;
	
	@LastModifiedDate
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yy/MM/dd")
	@Column(name = "moddate")
	private LocalDateTime modDate;
}
