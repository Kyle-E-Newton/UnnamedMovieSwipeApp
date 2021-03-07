//
//  EditViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/6/21.
//

import UIKit

class EditViewController : UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    
    var pickerData: [String] = [String]()
    var attribute : String?
    
    @IBOutlet weak var attributeLabel: UILabel?
    @IBOutlet weak var attributePicker: UIPickerView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        self.attributeLabel?.text = self.attribute
        self.attributePicker.delegate = self
        self.attributePicker.dataSource = self
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "unwindToSettings" {
            // update settings
        }
    }
    
    @IBAction func saveButtonPressed(_ sender: Any) {
        performSegue(withIdentifier: "unwindToSettings", sender: self)
    }
    
    
    // Number of columns of data
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    
    // The number of rows of data
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return pickerData.count
    }
    
    // The data to return fopr the row and component (column) that's being passed in
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return pickerData[row]
    }
    
    func pickerView(pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int)
    {
        let defaults = UserDefaults.standard
        // use the row to get the selected row from the picker view
        // using the row extract the value from your datasource (array[row])
        if attribute == "Ratings" {
            defaults.set(self.pickerData[row], forKey: "rating")
        } else if attribute == "Country" {
            defaults.set(self.pickerData[row], forKey: "country")
        } else if attribute == "Duration" {
            defaults.set(self.pickerData[row], forKey: "duration")
        }
    }
}
