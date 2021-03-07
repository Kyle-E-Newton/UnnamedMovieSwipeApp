//
//  MainViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class MainViewController: UIViewController {
    // "/user/all"
    
    var rootURL : String = "192.168.1.19818080"
    var currentMovies : [Movie]?
    var currentUser : User?
    
    @IBOutlet weak var movieTitleLabel: UILabel!
    @IBOutlet weak var moviePosterImageView: UIImageView!
    @IBOutlet weak var movieDescriptionLabel: UILabel!
    @IBOutlet weak var movieGenreLabel: UILabel!
    @IBOutlet weak var movieRatingLabel: UILabel!
    
    @IBOutlet weak var messagesButton: UIBarButtonItem!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.registerSettingsBundle()
        
        let defaults = UserDefaults.standard
        
        self.messagesButton.isEnabled = defaults.bool(forKey: "enableMessaging")
        
        // Do any additional setup after loading the view.
        self.updateView(movieTitle: "Interstellar", moviePoster: "interstellarPoster", movieDescription: "In Earth's future, a global crop blight and second Dust Bowl are slowly rendering the planet uninhabitable. Professor Brand (Michael Caine), a brilliant NASA physicist, is working on plans to save mankind by transporting Earth's population to a new home via a wormhole.", movieGenre: "Sci-fi/Adventure", movieRating: "PG-13")
        
        self.moviePosterImageView.image = self.getMovieAPICall(url: "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX67_CR0,0,67,98_AL_.jpg")
    }
    
    func getMovieAPICall(url : String) -> UIImage? {
        let url = URL(string: url)
        let group = DispatchGroup()
        
        var image : UIImage?
        
        DispatchQueue.global().async(group: group) {
            let data = try? Data(contentsOf: url!)
            image = UIImage(data: data!)
        }
        
        group.wait()
        
        return image
    }
    
    func registerSettingsBundle() {
       let appDefaults = [String:AnyObject]()
        UserDefaults.standard.register(defaults: appDefaults)
    }
    
    func updateView(movieTitle : String, moviePoster : String, movieDescription : String, movieGenre : String, movieRating : String) {
        self.movieTitleLabel.text = movieTitle
        self.moviePosterImageView.image = UIImage(named: moviePoster)
        self.movieDescriptionLabel.text = movieDescription
        self.movieGenreLabel.text = movieGenre
        self.movieRatingLabel.text = movieRating
    }
    
    func updateView(movie : Movie) {
        self.movieTitleLabel.text = movie.title
        self.moviePosterImageView.image = self.getMovieAPICall(url: movie.imageURL)
        self.movieDescriptionLabel.text = movie.description
        self.movieGenreLabel.text = movie.genre
        self.movieRatingLabel.text = movie.rating
    }
    
    @IBAction func dislikeButtonPressed(_ sender: Any) {
        self.currentUser?.dislikedMovies?.append(self.currentMovies![0])
        self.currentMovies?.remove(at: 0)
        self.updateView(movie: self.currentMovies![0])
        // move movie to users dislike list
        // display next movie
    }
    
    @IBAction func skipButtonPressed(_ sender: Any) {
        self.currentMovies?.remove(at: 0)
        self.updateView(movie: self.currentMovies![0])
        // remove movie form movie list
        // display next movie
    }
    
    @IBAction func likeButtonPressed(_ sender: Any) {
        self.currentUser?.likedMovies?.append(self.currentMovies![0])
        self.currentMovies?.remove(at: 0)
        self.updateView(movie: self.currentMovies![0])
        // move movie to users like list
        // display next movie
    }
    
    @IBAction func unwind( _ segue: UIStoryboardSegue) {
        
        if segue.identifier == "unwindToMain" {
            // update settings
            let defaults = UserDefaults.standard
            
            self.messagesButton.isEnabled = defaults.bool(forKey: "enableMessaging")
        }
    }
}
