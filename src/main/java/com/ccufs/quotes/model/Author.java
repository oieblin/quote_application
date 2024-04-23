package com.ccufs.quotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Author.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NotNull
@Table(name = "author")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String surname;
  private String name;
  private String patronymic;
  private String faculty;
  @JsonIgnore
  @OneToMany(mappedBy = "author")
  private Set<Quote> quotes;
}
