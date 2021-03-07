//
//  SettingsViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class SettingsViewController : UITableViewController {
    
    var attributeToEdit : String = ""
    
    var rating : String?
    var country : String? = "USA"
    var duration : String? = "Any"
    
    var ratingsList : [String] = ["G", "PG", "PG-13", "R", "NC-17"]
    var countryList : [String] = ["USA"]
    var durationList : [String] = ["< 1 hour", "< 1.5 hours", "< 2 hours", "< 2.5 hours", "< 3 hours", "Any"]
    
    @IBOutlet weak var doneButton: UIBarButtonItem!
    
    @IBOutlet weak var ratingsView: UIView!
    @IBOutlet weak var countryView: UIView!
    @IBOutlet weak var messagingSwitch: UISwitch!
    @IBOutlet weak var durationView: UIView!
    
    @IBOutlet weak var nameTextField: UITextField!
    @IBOutlet weak var pictureView: UIView!
    @IBOutlet weak var bioTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        self.getSettings()
    }
    
    func getSettings() {
        let defaults = UserDefaults.standard
        
        // Ratings setting
        if defaults.value(forKey: "rating") == nil {
            self.rating = "PG-13"
        } else {
            self.rating = defaults.string(forKey: "rating")
        }
        
        // Country setting
        if defaults.value(forKey: "country") == nil {
            self.country = "USA"
        } else {
            self.country = defaults.string(forKey: "country")
        }
        
        // Messaging Setting
        if defaults.value(forKey: "enableMessaging") == nil {
            self.messagingSwitch.isOn = true
        } else {
            self.messagingSwitch.isOn = defaults.bool(forKey: "enableMessaging")
        }
        
        // Duration setting
        if defaults.value(forKey: "duration") == nil {
            self.duration = "Any"
        } else {
            self.duration = defaults.string(forKey: "duration")
        }
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
        } else if segue.identifier == "durationSegue" {
            let editAttributeVC = segue.destination as! EditViewController
            editAttributeVC.attribute = "Duration"
            editAttributeVC.pickerData = self.durationList
        } else if segue.identifier == "unwindToMain" {
            let defaults = UserDefaults.standard
            defaults.set(self.messagingSwitch.isOn, forKey: "enableMessaging")
        }
    }
    
    @IBAction func unwind( _ segue: UIStoryboardSegue) {
        
        if segue.identifier == "unwindToSettings" {

        }
    }
    
    @IBAction func doneButtonPressed(_ sender: Any) {
        performSegue(withIdentifier: "unwindToMain", sender: self)
    }
}
