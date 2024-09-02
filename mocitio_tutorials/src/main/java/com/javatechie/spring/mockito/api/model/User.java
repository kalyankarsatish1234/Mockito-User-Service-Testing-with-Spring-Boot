package com.javatechie.spring.mockito.api.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "mockito_user")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private String address;

}
