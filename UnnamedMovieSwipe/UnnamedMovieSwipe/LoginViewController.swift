//
//  LoginViewController.swift
//  UnnamedMovieSwipe
//
//  Created by David Ott on 3/7/21.
//

import UIKit

class LoginViewController : UIViewController {
    
    @IBOutlet weak var usernameTextField: UITextField!
    @IBOutlet weak var passwordTextField: UITextField!
    
    @IBOutlet weak var submitButton: UIButton!
    @IBOutlet weak var createAccountButton: UIButton!
    
    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    @IBAction func submitButtonPressed(_ sender: Any) {
        if let username = usernameTextField.text {
            if let password = passwordTextField.text {
                if username != "" && password != "" {
                    self.loginAPI(username: username, password: password)
                }
            }
        }
        // make api call to login
        // if succesful:
        // - segue to main
        // else: print error message
    }
    
    func loginAPI(username : String, password : String) {
        
        // let url = URL(string: url)
        let group = DispatchGroup()
        
        // var image : UIImage?
        
        DispatchQueue.global().async(group: group) {
            // let data = try? Data(contentsOf: url!)
            // image = UIImage(data: data!)
        }
        
        group.wait()
    }
    
    @IBAction func createAccountButtonPressed(_ sender: Any) {
        // make api call to register account
        // if succesful:
        //  - segue to main
        // else: print error message
    }
    
    func createAccountAPI(username : String, password : String) {
        
        // let url = URL(string: url)
        let group = DispatchGroup()
        
        // var image : UIImage?
        
        DispatchQueue.global().async(group: group) {
            // let data = try? Data(contentsOf: url!)
            // image = UIImage(data: data!)
        }
        
        group.wait()
    }
}
