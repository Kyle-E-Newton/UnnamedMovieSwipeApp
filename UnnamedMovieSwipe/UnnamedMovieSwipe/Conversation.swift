//
//  Conversation.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import Foundation

class Conversation {
    
    var messages : [Message] = []
    var person1 : User?
    var person2 : User?
    
    init(person1 : User, person2 : User) {
        self.person1 = person1
        self.person2 = person2
    }
    
    func addMessage(message : Message) {
        messages.append(message)
    }
    
    func getMessages() -> [Message] {
        return self.messages
    }
    
    func length() -> Int {
        return messages.count
    }
}
