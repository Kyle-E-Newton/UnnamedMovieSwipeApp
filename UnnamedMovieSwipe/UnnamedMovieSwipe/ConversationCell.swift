//
//  ConversationCell.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import Foundation
import UIKit

class ConversationCell : UITableViewCell {
    
    @IBOutlet weak var messageLabel: UILabel!
    @IBOutlet weak var senderLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
}
