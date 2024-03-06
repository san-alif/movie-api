package dev.ihsan.movies.controller;

import dev.ihsan.movies.entity.Movie;
import dev.ihsan.movies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.allMovie());
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<?> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

}
