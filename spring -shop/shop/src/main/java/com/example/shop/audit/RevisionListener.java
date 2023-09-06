package com.example.shop.audit;

import org.springframework.security.core.context.SecurityContextHolder;

public class RevisionListener implements org.hibernate.envers.RevisionListener {

    @Override
    public void newRevision(Object revisionEntity) {
        RevInfo revInfo = (RevInfo) revisionEntity;
        String modifiedBy = SecurityContextHolder.getContext().getAuthentication().getName();
        revInfo.setModifiedBy(modifiedBy);
    }
}