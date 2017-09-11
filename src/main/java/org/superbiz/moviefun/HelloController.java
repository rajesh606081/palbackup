package org.superbiz.moviefun;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;

@Controller
public class HelloController {

    private MoviesBean moviesBean;

    public HelloController(MoviesBean moviesBean) {
        this.moviesBean = moviesBean;
    }

    @RequestMapping("/")
    public ModelAndView  defaultStart() {

        String message = "Hello World, Spring 3.0!";
        return new ModelAndView("index", "message", message);
        //model.addAttribute("name", name);
        //  return "index";
    }

    @RequestMapping("/setup")
//    @Transactional
    public String  fetchMovie(Map<String, Object> model ) {

        moviesBean.addMovie(new Movie("Wedding Crashers", "David Dobkin", "Comedy", 7, 2005));
        moviesBean.addMovie(new Movie("Starsky & Hutch", "Todd Phillips", "Action", 6, 2004));
        moviesBean.addMovie(new Movie("Shanghai Knights", "David Dobkin", "Action", 6, 2003));
        moviesBean.addMovie(new Movie("I-Spy", "Betty Thomas", "Adventure", 5, 2002));
        moviesBean.addMovie(new Movie("The Royal Tenenbaums", "Wes Anderson", "Comedy", 8, 2001));
        moviesBean.addMovie(new Movie("Zoolander", "Ben Stiller", "Comedy", 6, 2001));
        moviesBean.addMovie(new Movie("Shanghai Noon", "Tom Dey", "Comedy", 7, 2000));

        model.put("movies", moviesBean.getMovies());
        return "setup";

/*        String message = "Hello World, Spring 3.0!";
        return new ModelAndView("setup", "message", message);*/
        //model.addAttribute("name", name);
      //  return "index";
    }
}
