package mate.academy.boot.controllers;

import java.io.IOException;
import java.util.List;
import mate.academy.boot.entity.Review;
import mate.academy.boot.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/init")
public class InitController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public void dataInit() throws IOException {
        long time = System.currentTimeMillis();
        List<Review> addList = reviewService.reviewParser("src/main/resources/Reviews.csv");
        reviewService.saveAllReviewToDataBase(addList);
        System.out.println((System.currentTimeMillis() - time) / 1000);
    }
}
