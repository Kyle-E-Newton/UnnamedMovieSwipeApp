//
//  Movie.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import Foundation

class Movie {
    
    var uniqueID : String?
    var title : String?
    var release : Date?
    var genre : String?
    var duration : Int? // will be in minutes
    var country : String?
    var language : String?
    var rating : String?
    var description : String?
    var imageURL : String
    
    init(uniqueID : String, title : String, release : Date, genre : String, duration : Int, country : String, language : String, rating : String, description : String, imageURL : String) {
        
        self.uniqueID = uniqueID
        self.title = title
        self.release = release
        self.genre = genre
        self.duration = duration
        self.country = country
        self.language = language
        self.rating = rating
        self.description = description
        self.imageURL = imageURL
    }
}
