package ro.esolutions.scleancode.scleancode.exercise1.controller;

import org.springframework.web.bind.annotation.*;
import ro.esolutions.scleancode.scleancode.exercise1.db.Account;

import java.util.List;


@RestController
@RequestMapping("/account")
public class AccountController {

    @GetMapping
    public List<Account> getAll() {

        return null;
    }

    @PostMapping
    public void save() {

    }

    @DeleteMapping
    public void delete() {

    }
}

