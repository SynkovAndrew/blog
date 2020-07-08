import React from "react"
import "./styles.css"
import "bootstrap/dist/css/bootstrap.css";

export default class TopicsPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            topics: []
        };
    }

    componentDidMount() {
        fetch("/api/v1/topics")
            .then(response => response.json())
            .then(json => this.setState({topics: json.content}));

    }

    render() {
        return (
            <React.Fragment>
                <div className="side-margin-30">
                    <div className="card-deck">
                        {
                            this.state.topics.map((topic) => (
                                <div className="card topic">
                                    <div className="card-header"><h5>{topic.title}</h5></div>
                                    <div className="card-body">
                                        <p className="card-text">{topic.text}</p>
                                    </div>
                                    <div className="card-footer">
                                        <small className="text-muted">{topic.createdAt}</small>
                                    </div>
                                </div>
                            ))
                        }
                    </div>
                </div>
            </React.Fragment>
        )
    }
}


