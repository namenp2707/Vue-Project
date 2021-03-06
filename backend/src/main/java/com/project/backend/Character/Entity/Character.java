package com.project.backend.Character.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@Entity
@NoArgsConstructor
@Table(name = "CHARACTER")
public class Character {
  @Id
  @SequenceGenerator(name = "Character_seq", sequenceName = "Character_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "Character_seq")
  @Column(name = "Character_id", unique = true, nullable = true)
  private Long id;

  @NotNull
  @Column(name = "NAME")
  private String name;

  @NotNull
  @Column(name = "IMG_SMALL")
  private String img_small;

  @NotNull
  @Column(name = "IMG_BIG")
  private String img_big;


  @ManyToMany(fetch = FetchType.EAGER, targetEntity = TypeHeroes.class)
  @JoinColumn(name = "typeHeroes_id", insertable = true)
  @NotNull
  private List<TypeHeroes> types = new ArrayList<>();

  public void addTypeHero(TypeHeroes type) {
    this.types.add(type);
  }

  @ManyToMany(fetch = FetchType.EAGER, targetEntity = Skill.class)
  @JoinColumn(name = "skill_id", insertable = true)
  @NotNull
  private List<Skill> skills = new ArrayList<>();

  public void addSkill(Skill skill) {
    this.skills.add(skill);
  }

}
