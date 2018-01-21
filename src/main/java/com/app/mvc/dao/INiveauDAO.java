package com.app.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mvc.entity.Niveau;

public interface INiveauDAO extends JpaRepository<Niveau, Long> {

}
