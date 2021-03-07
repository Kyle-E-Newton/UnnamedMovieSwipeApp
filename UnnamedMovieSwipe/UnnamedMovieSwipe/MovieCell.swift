//
//  MovieCell.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class MovieCell : UITableViewCell {
    
    @IBOutlet weak var movieTitleLabel: UILabel!
    @IBOutlet weak var movieSubtitleLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }
    
    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)
    }
}
