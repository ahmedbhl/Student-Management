package com.app.mvc.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.mvc.entity.Parcours;

public interface IParcoursDAO extends JpaRepository<Parcours, Long> {

}
