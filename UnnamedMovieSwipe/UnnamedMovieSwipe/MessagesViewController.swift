//
//  MessagesViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class MessagesViewController : UITableViewController {
    
    var conversations : [Conversation] = []
    
    var conversationVC : ConversationViewController?
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let user1 : User = User(userID: "1234", email: "email@email.com", password: "1234")
        user1.userName = "BoJack"
        let user2 : User = User(userID: "5678", email: "email2@email.com", password: "5678")
        user2.userName = "Burn447"
        let message : Message = Message(sender: user1, recipient: user2, text:"Hey friend. I like your taste in movies")
        
        conversations.append(Conversation(person1: user1, person2: user2))
        conversations[0].addMessage(message: message)
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if segue.identifier == "viewChat" {
            self.conversationVC = (segue.destination as! ConversationViewController)
        }
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.conversations.count
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let row = indexPath.row
        let cell = tableView.dequeueReusableCell(withIdentifier: "messageCell", for: indexPath) as! MessagesCell
        
        let convo = self.conversations[row].messages
        
        cell.messagePreviewLabel.text = convo[convo.count - 1].text
        cell.userLabel.text = self.conversations[row].person1?.userName

        return cell
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        let selectedConvo = self.conversations[indexPath.row]
        self.conversationVC?.conversation = selectedConvo
    }
}
