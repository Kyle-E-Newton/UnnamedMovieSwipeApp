//
//  SettingsViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class SettingsViewController : UITableViewController {
    
    var ratingsList : [String] = ["G", "PG", "PG-13", "R", "NC-17"]
    var countryList : [String] = ["United States"]
    var languageList : [String] = ["English"]
    var durationList : [String] = ["< 1 hour", "< 1.5 hours", "< 2 hours", "< 2.5 hours", "< 3 hours", "Any"]
    
    @IBOutlet weak var doneButton: UIBarButtonItem!
    
    @IBOutlet weak var ratingsView: UIView!
    @IBOutlet weak var countryView: UIView!
    @IBOutlet weak var languageView: UIView!
    @IBOutlet weak var durationView: UIView!
    
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var pictureView: UIView!
    @IBOutlet weak var bioTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
            
            if segue.identifier == "ratingsSegue" {
                let editAttributeVC = segue.destination as! EditViewController
                editAttributeVC.attribute = "Ratings"
                editAttributeVC.pickerData = self.ratingsList
            } else if segue.identifier == "countriesSegue" {
                let editAttributeVC = segue.destination as! EditViewController
                editAttributeVC.attribute = "Country"
                editAttributeVC.pickerData = self.countryList
            } else if segue.identifier == "languageSegue" {
                let editAttributeVC = segue.destination as! EditViewController
                editAttributeVC.attribute = "Language"
                editAttributeVC.pickerData = self.languageList
            } else if segue.identifier == "durationSegue" {
                let editAttributeVC = segue.destination as! EditViewController
                editAttributeVC.attribute = "Duration"
                editAttributeVC.pickerData = self.durationList
            }
    }
    
    @IBAction func unwind( _ segue: UIStoryboardSegue) {
        
        if segue.identifier == "unwindToSettings" {
            // update settings
        }
    }
    
    @IBAction func doneButtonPressed(_ sender: Any) {
        performSegue(withIdentifier: "unwindToMain", sender: self)
    }
}
