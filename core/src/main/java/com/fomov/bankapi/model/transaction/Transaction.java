package com.fomov.bankapi.model.transaction;

import com.fomov.bankapi.model.account.Account;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@CreationTimestamp
	@Column(name = "date_and_time", nullable = false)
	private LocalDateTime dateAndTime;

	@Column(name = "type", nullable = false)
	private Type type;

	@ManyToOne
	@JoinColumn(name = "source_account_id")
	private Account sourceAccount;

	@ManyToOne
	@JoinColumn(name = "target_account_id")
	private Account targetAccount;

	@Column(name = "amount", nullable = false)
	private BigDecimal amount;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "state", nullable = false)
	private State state;
}
