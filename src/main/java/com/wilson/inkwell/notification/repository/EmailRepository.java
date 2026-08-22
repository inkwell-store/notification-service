package com.wilson.inkwell.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wilson.inkwell.notification.entity.Email;

public interface EmailRepository extends JpaRepository<Email, Long> {

}
