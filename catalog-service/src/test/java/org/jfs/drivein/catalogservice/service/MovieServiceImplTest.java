package org.jfs.drivein.catalogservice.service;

import org.jfs.drivein.catalogservice.dao.MovieDao;
import org.jfs.drivein.catalogservice.exception.MovieTitleNotFoundException;
import org.jfs.drivein.catalogservice.model.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MovieServiceImplTest {

    @InjectMocks
    private MovieServiceImpl movieServiceImpl;

    @Mock
    private MovieDao movieDao;

    @Test
    public void saveMovieTest() {
        Movie movie = new Movie();
        movie.setTitle("Avengers");
        movie.setGenre("Action");
        movie.setDescription("Description of Avengers");
        movie.setRating(6.5);

        when(movieDao.saveMovie(any(Movie.class))).thenReturn(movie);
        Movie savedMovie = movieServiceImpl.saveMovie(movie);
        assertEquals(movie, savedMovie);
    }

    @Test
    public void updateMovieTest() throws Exception {
        String title = "Avengers";
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre("Action");
        movie.setDescription("Description of Avengers");
        movie.setRating(6.5);

        when(movieDao.viewMovie(title)).thenReturn(Optional.of(movie));
        when(movieDao.saveMovie(any(Movie.class))).thenReturn(movie);
        Movie updatedMovie = movieServiceImpl.updateMovie(title, movie);
        assertEquals(movie, updatedMovie);
    }

    @Test
    public void updateMovieNotFoundTest() {
        String title = "No Movie";
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre("Action");
        movie.setDescription("Description of Avengers");
        movie.setRating(6.5);

        when(movieDao.viewMovie(title)).thenReturn(Optional.empty());
        assertThrows(MovieTitleNotFoundException.class , () -> movieServiceImpl.updateMovie(title , movie));
    }

    @Test
    public void viewMovieTest() throws Exception {
        String title = "Avengers";
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre("Action");
        movie.setDescription("Description of Avengers");
        movie.setRating(6.5);

        when(movieDao.viewMovie(title)).thenReturn(Optional.of(movie));
        Movie viewedMovie = movieServiceImpl.viewMovie(title);
        assertEquals(movie, viewedMovie);
    }

    @Test
    public void viewMovieNotFoundTest() {
        String title = "No Movie";

        when(movieDao.viewMovie(title)).thenReturn(Optional.empty());
        assertThrows(MovieTitleNotFoundException.class, () -> movieServiceImpl.viewMovie(title));
    }

    @Test
    public void deleteMovieTest() {
        String title = "Avengers";

        movieServiceImpl.deleteMovie(title);
        verify(movieDao, times(1)).deleteMovie(title);
    }

    @Test
    public void viewAllMovieTest() {
        List<Movie> movies = Arrays.asList(new Movie(), new Movie());

        when(movieDao.viewAllMovie()).thenReturn(movies);
        List<Movie> viewedMovies = movieServiceImpl.viewAllMovie();
        assertEquals(movies, viewedMovies);
    }
}