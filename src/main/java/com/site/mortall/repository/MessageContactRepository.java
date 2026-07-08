package com.site.mortall.repository;

import com.site.mortall.entity.MessageContact;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MessageContactRepository extends JpaRepository<MessageContact, Long> {
    List<MessageContact> findAllByOrderByDateEnvoiDesc();
    List<MessageContact> findByLuFalseOrderByDateEnvoiDesc();
}