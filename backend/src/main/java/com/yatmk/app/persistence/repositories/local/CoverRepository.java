package com.yatmk.app.persistence.repositories.local;

import org.springframework.stereotype.Repository;

import com.yatmk.app.persistence.models.local.attachement.Cover;
import com.yatmk.app.persistence.repositories.config.AbstractRepository;

@Repository
public interface CoverRepository extends AbstractRepository<Cover, Long> {

}
