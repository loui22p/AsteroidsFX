package dk.sdu.mmmi.cbse.common.playerscoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PlayerScoringApplication {

    private int totalScore;

    public static void main(String[] args) {
        SpringApplication.run(PlayerScoringApplication.class, args);
    }

    @GetMapping("/newScore")
    public int calculateNewScore(@RequestParam(value = "point") int point) {
        totalScore += point;
        System.out.println(totalScore);
        return totalScore ;
    }

    @GetMapping("/getScore")
    public int getScore() {
        return totalScore;
    }
}
