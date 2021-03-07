//
//  CommonMoviesViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class CommonMoviesViewController : UIViewController {
    
    var commonMovies : [Movie] = []
    
    @IBOutlet weak var userIDTextField: UITextField!
    @IBOutlet weak var submitButton: UIButton!
    
    @IBOutlet weak var commonMoviesTable: UITableView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.commonMovies.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {

        let row = indexPath.row
        let cell = tableView.dequeueReusableCell(withIdentifier: "movieCell", for: indexPath) as! MovieCell
        
        let movieTitle : String = self.commonMovies[row].title!
        let movieSubTitle : String = self.commonMovies[row].genre!
        
        cell.movieTitleLabel.text = movieTitle
        cell.movieSubtitleLabel.text = movieSubTitle

        return cell
    }

    func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {

    }
}
