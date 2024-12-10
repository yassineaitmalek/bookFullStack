package com.yatmk.app.infrastructure.services;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yatmk.app.persistence.exception.config.ServerSideException;
import com.yatmk.app.persistence.presentation.ApiDownloadInput;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileWriterService {

  public String saveToTXTFile(StringBuilder stringBuilder, String folderPath, String fileName) {
    String fullPath = Paths.get(folderPath, fileName + "." + "txt").toAbsolutePath().normalize().toString();
    try (FileWriter fileWriter = new FileWriter(fullPath); BufferedWriter writer = new BufferedWriter(fileWriter);) {
      log.info("file {} is created", fileName);
      log.info("start writing to file {}", fileName);

      writer.append(Optional.ofNullable(stringBuilder).map(StringBuilder::toString).orElseGet(String::new));

      log.info("writing to file {} is complete", fileName);
      log.info("the full path of the file  {}", fullPath);
      return fullPath;

    } catch (Exception e) {
      throw new ServerSideException(e);
    }

  }

  public ApiDownloadInput generateTXTBytes(StringBuilder stringBuilder, String fileName) {
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
      log.info("start writing to OutputStream ");

      baos.write(Optional.ofNullable(stringBuilder).map(StringBuilder::toString).orElseGet(String::new)
          .getBytes(StandardCharsets.UTF_8));

      log.info("writing to OutputStream is complete");
      return ApiDownloadInput.builder().bytes(baos.toByteArray()).fileName(fileName).ext("txt").build();
    } catch (Exception e) {
      throw new ServerSideException(e);
    }

  }

}
