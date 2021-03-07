//
//  MessagesViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class MessagesViewController : UITableViewController {
    
    var conversation : Conversation?
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return self.conversation?.length() ?? 0
    }
    
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        let row = indexPath.row
        let cell = tableView.dequeueReusableCell(withIdentifier: "conversationCell", for: indexPath) as! ConversationCell
        
        cell.messageLabel.text = self.conversation?.getMessages()[row].text
        cell.senderLabel.text = self.conversation?.getMessages()[row].sender?.userName

        return cell
    }
}
