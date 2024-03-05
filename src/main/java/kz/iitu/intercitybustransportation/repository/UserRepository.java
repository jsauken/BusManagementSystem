package kz.iitu.intercitybustransportation.repository;

import kz.iitu.intercitybustransportation.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
