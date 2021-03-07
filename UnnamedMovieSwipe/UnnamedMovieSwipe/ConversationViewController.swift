//
//  ConversationViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class ConversationViewController : UITableViewController {
    
    var conversation : Conversation?
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.conversation!.length()
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let row = indexPath.row
        let cell = tableView.dequeueReusableCell(withIdentifier: "conversationCell", for: indexPath) as! ConversationCell
        
        cell.messageLabel.text = conversation!.messages[conversation!.messages.count - 1 - row].text
        cell.senderLabel.text = conversation!.messages[row].sender?.userName

        return cell
    }
}
