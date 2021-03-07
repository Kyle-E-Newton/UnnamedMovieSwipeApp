//
//  Message.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import Foundation

class Message {
    
    var sender : User?
    var recipient : User?
    var text : String?
    var time : Date
    
    init(sender : User, recipient : User, text : String) {
        self.sender = sender
        self.recipient = recipient
        self.text = text
        self.time = Date()
    }
}
