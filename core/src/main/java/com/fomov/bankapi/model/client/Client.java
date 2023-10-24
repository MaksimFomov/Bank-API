package com.fomov.bankapi.model.client;

import com.fomov.bankapi.model.account.Account;
import com.fomov.bankapi.model.security.Role;
import com.fomov.bankapi.model.transaction.Transaction;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class Client {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany(cascade = {CascadeType.MERGE})
	@JoinTable(
			name = "user_role",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")}
	)
	private Set<Role> roles;

	@CreationTimestamp
	@Column(name = "date_of_creation", nullable = false)
	private LocalDateTime dateOfCreation;

	@UpdateTimestamp
	@Column(name = "date_of_change", nullable = false)
	private LocalDateTime dateOfChange;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "patronymic", nullable = false)
	private String patronymic;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@OneToMany(mappedBy = "client")
	private List<Transaction> transactions;

	@OneToMany(mappedBy = "owner")
	private List<Account> accounts;

	@Column(name = "gender", nullable = false)
	private Gender gender;

	@Column(name = "birthday", nullable = false)
	private LocalDate birthday;

	@Column(name = "country", nullable = false)
	private String country;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "phone_number", nullable = false, unique = true)
	private String phoneNumber;

	@Column(name = "account_not_locked", nullable = false)
	private Boolean accountNonLocked;
}
