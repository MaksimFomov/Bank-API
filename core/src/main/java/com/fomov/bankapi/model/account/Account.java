package com.fomov.bankapi.model.account;

import com.fomov.bankapi.model.client.Client;
import com.fomov.bankapi.model.transaction.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "accounts")
public class Account {
	@Id
	@Column(name = "account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@CreationTimestamp
	@Column(name = "date_of_creation", nullable = false)
	private LocalDateTime dateOfCreation;

	@UpdateTimestamp
	@Column(name = "date_of_change", nullable = false)
	private LocalDateTime dateOfChange;

	@Column(name = "account_number", nullable = false)
	private String accountNumber;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client owner;

	@Column(name = "type", nullable = false)
	private Type type;

	@Column(name = "currency", nullable = false)
	private Currency currency;

	@Column(name = "balance", nullable = false)
	private BigDecimal balance;

	@OneToMany(mappedBy = "sourceAccount")
	private List<Transaction> sentTransactions;

	@OneToMany(mappedBy = "targetAccount")
	private List<Transaction> receivedTransactions;
}
