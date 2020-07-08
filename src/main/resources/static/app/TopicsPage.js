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
                    <table className="table">
                        <thead className="thead-dark">
                        <tr>
                            <th scope="col">Title</th>
                            <th scope="col">Text</th>
                            <th scope="col">Created At</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.topics.map((topic, index) => (
                                <tr key={index} className="table-row">
                                    <td>{topic.title}</td>
                                    <td>{topic.text}</td>
                                    <td>{topic.createdAt}</td>
                                </tr>
                            ))
                        }
                        </tbody>
                    </table>
                </div>
            </React.Fragment>
        )
    }
}


