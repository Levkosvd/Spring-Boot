package mate.academy.boot.service;

import java.io.IOException;
import java.util.List;
import mate.academy.boot.entity.Review;

public interface ReviewService {

    List<Review> saveAllReviewToDataBase(List<Review> reviews);

    List<Review> reviewParser(String filename) throws IOException;
}
