package com.app.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mvc.entity.Classe;

public interface IClasseDAO extends JpaRepository<Classe, Long> {

}
