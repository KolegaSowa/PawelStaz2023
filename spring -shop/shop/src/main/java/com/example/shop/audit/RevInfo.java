package com.example.shop.audit;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.DefaultRevisionEntity;
import org.hibernate.envers.RevisionEntity;

@Getter
@Setter
@Entity
@RevisionEntity(RevisionListener.class)
public class RevInfo extends DefaultRevisionEntity {

    String modifiedBy;
}
