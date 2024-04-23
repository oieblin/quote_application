package com.ccufs.quotes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
  @NotNull
  private String surname;
  @NotNull
  private String name;
  @NotBlank
  private String patronymic;
  @NotEmpty
  private String faculty;
  @JsonIgnore
  @OneToMany(mappedBy = "author")
  private Set<Quote> quotes;
}
