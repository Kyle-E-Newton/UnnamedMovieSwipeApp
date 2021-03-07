//
//  User.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class User {
    
    var userName : String?
    var email : String
    var userID : String
    var likedMovies : [Movie]?
    var dislikedMovies : [Movie]?
    var picture : UIImage?
    var bio : String?
    var password : String
    var conversations : [Conversation]
    
    init(userID : String, email : String, password : String) {
        self.userID = userID
        self.email = email
        self.password = password
        self.conversations = []
    }
    
    func setUsername(name : String) {
        self.userName = name
    }
    
    func setEmail(email : String) {
        self.email = email
    }
    
    func addLikedMovie(movie : Movie) {
        self.likedMovies?.append(movie)
    }
    
    func addDislikedMove(movie : Movie) {
        self.dislikedMovies?.append(movie)
    }
    
    func setPicture(picture : UIImage) {
        self.picture = picture
    }
    
    func setBio(bio : String) {
        self.bio = bio
    }
    
    func setPassword(password : String) {
        self.password = password
    }
    
    func addConversation(conversation : Conversation) {
        self.conversations.append(conversation)
    }
}
