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
                <div>
                    {
                        this.state.topics.map((topic) => (
                            <div className="card text-white bg-primary mb-3 main-div">
                                <div className="card-header">{topic.title}</div>
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
            </React.Fragment>
        )
    }
}


