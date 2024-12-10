package com.yatmk.app.persistence.repositories.local;

import org.springframework.stereotype.Repository;

import com.yatmk.app.persistence.models.local.Attachement;
import com.yatmk.app.persistence.repositories.config.AbstractRepository;

@Repository
public interface AttachementRepository extends AbstractRepository<Attachement, Long> {

}
