package example.demo.repository;

import example.demo.model.ScadaTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScadaTagRepository extends JpaRepository<ScadaTag, String> {
    // Additional custom queries can be added here
}

