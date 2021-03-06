import React from 'react'
import { Tabs, Tab, Sonnet, Button } from 'react-bootstrap'

class BootstrapTab extends React.Component{
    render(){
        return(
            <div>
              <Tabs defaultActiveKey="profile" id="uncontrolled-tab-example">
                    <Tab eventKey="Swipe" title="Swipe" defaultActiveKey>
                    </Tab>
                    <Tab eventKey="Recommend" title="Recommend">
                    </Tab>
                    <Tab eventKey="Profile" title="Profile">
                        <Button>test</Button>
                    </Tab>
                </Tabs>  
            </div>
        )
    }
}
export default BootstrapTab;