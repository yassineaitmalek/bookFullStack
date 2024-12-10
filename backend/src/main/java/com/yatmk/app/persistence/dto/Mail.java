package com.yatmk.app.persistence.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;

import com.yatmk.app.common.utility.Utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

  private List<String> to;

  private List<String> copy;

  private String subject;

  private String body;

  private List<MultipartFile> files;

  public List<String> getTo() {
    return Utils.checkStream(to).distinct().collect(Collectors.toList());
  }

  public List<String> getCopy() {
    return Utils.checkStream(copy).distinct().collect(Collectors.toList());
  }

  public List<MultipartFile> getFiles() {
    return Utils.checkStream(files).distinct().collect(Collectors.toList());
  }

}
