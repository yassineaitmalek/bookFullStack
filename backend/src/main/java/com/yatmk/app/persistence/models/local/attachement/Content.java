package com.yatmk.app.persistence.models.local.attachement;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yatmk.app.persistence.models.local.Attachement;
import com.yatmk.app.persistence.models.local.Book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Content extends Attachement {

  @JsonIgnore
  @OneToOne
  private Book book;

}
