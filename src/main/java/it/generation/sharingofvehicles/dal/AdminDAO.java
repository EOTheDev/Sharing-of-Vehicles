package it.generation.sharingofvehicles.dal;

import org.springframework.data.jpa.repository.JpaRepository;

import it.generation.sharingofvehicles.entities.Admin;

public interface AdminDAO extends JpaRepository<Admin, Integer> {

}
