//
//  MessagesCell.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class MessagesCell : UITableViewCell {
    
    @IBOutlet weak var userLabel: UILabel!
    @IBOutlet weak var messagePreviewLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
}
