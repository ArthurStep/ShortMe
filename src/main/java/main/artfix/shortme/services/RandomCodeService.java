package main.artfix.shortme.services;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomCodeService {
    public String randomCode() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            char c = (char)(random.nextInt(26) + 'a');
            sb.append(c);
        }
        return sb.toString();
    }
}
