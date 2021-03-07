//
//  MainViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class MainViewController: UIViewController {
    
    @IBOutlet weak var movieTitleLabel: UILabel!
    @IBOutlet weak var movieDescriptionLabel: UILabel!
    @IBOutlet weak var movieGenreLabel: UILabel!
    @IBOutlet weak var movieRatingLabel: UILabel!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        // Do any additional setup after loading the view.
        self.updateView(movieTitle: "Interstellar", movieDescription: "In Earth's future, a global crop blight and second Dust Bowl are slowly rendering the planet uninhabitable. Professor Brand (Michael Caine), a brilliant NASA physicist, is working on plans to save mankind by transporting Earth's population to a new home via a wormhole.", movieGenre: "Sci-fi/Adventure", movieRating: "PG-13")
    }
    
    func updateView(movieTitle : String, movieDescription : String, movieGenre : String, movieRating : String) {
        self.movieTitleLabel.text = movieTitle
        self.movieDescriptionLabel.text = movieDescription
        self.movieGenreLabel.text = movieGenre
        self.movieRatingLabel.text = movieRating
    }
    
    @IBAction func dislikeButtonPressed(_ sender: Any) {
        // do something
    }
    
    @IBAction func likeButtonPressed(_ sender: Any) {
        // do something
    }
    
    @IBAction func unwind( _ segue: UIStoryboardSegue) {
        
        if segue.identifier == "unwindToMain" {
            // update settings
        }
    }
}
