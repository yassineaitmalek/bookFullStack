package com.yatmk.app.presentation.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yatmk.app.persistence.presentation.ApiDataResponse;
import com.yatmk.app.presentation.config.AbstractController;

import lombok.RequiredArgsConstructor;

@Validated
@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestController implements AbstractController {

}
