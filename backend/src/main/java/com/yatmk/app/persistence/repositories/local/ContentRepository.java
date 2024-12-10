package com.yatmk.app.persistence.repositories.local;

import org.springframework.stereotype.Repository;

import com.yatmk.app.persistence.models.local.attachement.Content;
import com.yatmk.app.persistence.repositories.config.AbstractRepository;

@Repository
public interface ContentRepository extends AbstractRepository<Content, Long> {

}
