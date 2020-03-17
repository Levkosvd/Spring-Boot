package mate.academy.boot.service;

import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mate.academy.boot.entity.Review;
import mate.academy.boot.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImp implements ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    @Override
    public List<Review> saveAllReviewToDataBase(List<Review> reviews) {
        return reviewRepository.saveAll(reviews);
    }

    @Override
    public List<Review> reviewParser(String filename) throws IOException {
        CSVReader csvReader;
        String[] nextline;
        List<Review> addList = new ArrayList<>();
        csvReader = new CSVReader(new FileReader(filename));
        csvReader.readNext();
        while ((nextline = csvReader.readNext()) != null) {
            if (nextline != null) {
                Review newReview = new Review();
                newReview.setId(Long.valueOf(nextline[0]));
                newReview.setUserId(nextline[2]);
                newReview.setDescription(nextline[9]);
                addList.add(newReview);
            }
        }
        return addList;
    }
}
