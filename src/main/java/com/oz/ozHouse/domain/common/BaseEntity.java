package com.oz.ozHouse.domain.common;

import java.time.LocalDate;
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
public abstract class BaseEntity {
	@CreatedDate
	@Column(name = "regdate", updatable = false)
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate regDate;
	
	@LastModifiedDate
	@Column(name = "moddate")
	@DateTimeFormat(pattern = "yy/MM/dd")
	private LocalDate modDate;
}
