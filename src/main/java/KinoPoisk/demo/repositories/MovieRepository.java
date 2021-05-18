package KinoPoisk.demo.repositories;

import KinoPoisk.demo.entities.Genre;
import KinoPoisk.demo.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MovieRepository extends JpaRepository<Movies, Long> {
    List<Movies> findAllByOrderByYearDesc();
    List<Movies> findAllByOrderByRatingDesc();
    List<Movies> findAllByGenres(Genre genre);
}
