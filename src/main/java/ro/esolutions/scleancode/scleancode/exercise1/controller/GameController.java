package ro.esolutions.scleancode.scleancode.exercise1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.esolutions.scleancode.scleancode.exercise1.db.Game;
import ro.esolutions.scleancode.scleancode.exercise1.db.GameRepository;

import java.util.List;

@RequestMapping("/game")
@RestController
public class GameController {

    @Autowired
    private GameRepository repository;

    @GetMapping
    public List<Game> getAll() {

        return repository.GetAll();
    }

    @PostMapping
    public void save() {

    }

    @DeleteMapping
    public void delete() {

    }
}
