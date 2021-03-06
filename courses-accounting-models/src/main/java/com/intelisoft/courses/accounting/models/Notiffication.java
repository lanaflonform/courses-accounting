package com.intelisoft.courses.accounting.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.intelisoft.courses.accounting.models.enums.NotifficationStatus;
import com.intelisoft.courses.accounting.models.enums.NotifficationType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "users")
@EqualsAndHashCode(callSuper = true, exclude = "users")

@Entity
@Table(name = "notiffications")
public class Notiffication extends Model {

	private static final long serialVersionUID = 5734793146922815304L;

	@Column(name = "notice_datetime", nullable = false)
	private Date noticeDateTime;

	@Column(name = "message", nullable = false)
	private String message;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private NotifficationType type;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private NotifficationStatus status;

	@OneToMany(mappedBy = "notiffication", cascade = { CascadeType.PERSIST,
			CascadeType.REFRESH }, fetch = FetchType.LAZY)
	private List<User> users = new ArrayList<User>();

}
