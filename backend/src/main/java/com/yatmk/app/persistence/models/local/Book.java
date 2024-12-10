package com.yatmk.app.persistence.models.local;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.yatmk.app.persistence.models.config.BaseEntity;
import com.yatmk.app.persistence.models.local.attachement.Cover;
import com.yatmk.app.persistence.models.local.attachement.Content;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Book extends BaseEntity {

  private String author;

  private String country;

  private String language;

  private Long pages;

  private String title;

  private Long year;

  @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
  private Cover cover;

  @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
  private Content content;
}
