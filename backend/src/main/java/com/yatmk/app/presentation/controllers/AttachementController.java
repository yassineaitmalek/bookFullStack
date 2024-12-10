package com.yatmk.app.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import com.yatmk.app.infrastructure.services.AttachementService;
import com.yatmk.app.presentation.config.AbstractController;

import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/attachement")
@RequiredArgsConstructor
public class AttachementController implements AbstractController {

  private final AttachementService attachementService;

  @GetMapping("/download/{id}")
  public ResponseEntity<StreamingResponseBody> download(@PathVariable Long id) {
    return downloadLarge(attachementService.downloadAttachementLarge(id));
  }

}
