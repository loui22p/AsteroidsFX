package dk.sdu.mmmi.cbse.common.playerscoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PlayerScoringApplication {

    private int totalScore = 0;

    public static void main(String[] args) {
        SpringApplication.run(PlayerScoringApplication.class, args);
    }

    @GetMapping("/score")
    public int calculateNewScore(@RequestParam(value = "point") int point) {
        totalScore += point;
        return totalScore ;
    }
}
