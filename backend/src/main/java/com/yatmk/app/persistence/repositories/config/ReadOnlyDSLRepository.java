package com.yatmk.app.persistence.repositories.config;

import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ReadOnlyDSLRepository<T, U> extends ReadOnlyRepository<T, U> {

}