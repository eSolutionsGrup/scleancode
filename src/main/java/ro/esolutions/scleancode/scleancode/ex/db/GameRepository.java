package ro.esolutions.scleancode.scleancode.ex.db;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class GameRepository {
    private List<Game> accounts = Arrays.asList(
            new Game("CS Go", "1.3", "Valve","shooter"),
            new Game("WoW", "BFA", "blizzard","MMORPG"),
            new Game("CiV6", "6", "Sid Meiers","Strategy"),
            new Game("Gothic", "1", "Piranha Bytes","RPG"),
            new Game("Dota 2", "2", "Valve","MOBA"));

    public List<Game> GetAll() {
        return accounts;
    }

    public Optional<Game> getbyemail(final String email) {
        return accounts.stream().filter(cc -> cc.getName().equals(email)).findFirst();
    }

    public void DELETE_by_Name(String mail) {
        accounts = accounts.stream().filter(cc -> !cc.getName().equals(mail)).collect(Collectors.toList());
    }
}
