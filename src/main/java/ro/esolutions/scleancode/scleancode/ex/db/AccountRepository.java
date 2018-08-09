package ro.esolutions.scleancode.scleancode.ex.db;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class AccountRepository {
    private List<Account> accounts = Arrays.asList(
            new Account("uncle", "bobo", "uncle.bobo@gmail.com"),
            new Account("martin", "fowler", "mflowrer.@gmail.com"),
            new Account("titi", "stanciu", "tstanciu@gmail.com"),
            new Account("gigi", "masinuta", "gmasinuta@gmail.com"),
            new Account("super", "man", "superman@gmail.com"));

    public List<Account> GetAll() {
        return accounts;
    }

    public Optional<Account> getbyemail(final String email) {
        return accounts.stream().filter(cc -> cc.getEmail().equals(email)).findFirst();
    }

    public void deleteByemail(String mail) {
        accounts = accounts.stream().filter(cc -> !cc.getEmail().equals(mail)).collect(Collectors.toList());
    }

}
