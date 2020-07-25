import React from "react"
import "./styles.css"
import "bootstrap/dist/css/bootstrap.css";

export default class AuthorsPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            authors: []
        };
    }

    componentDidMount() {
        fetch("/api/v1/authors")
            .then(response => response.json())
            .then(json => this.setState({authors: json.content}));

    }

    render() {
        return (
            <React.Fragment>
                <div>
                    <table className="table">
                        <thead className="thead-dark">
                        <tr>
                            <th scope="col">First Name</th>
                            <th scope="col">Last Name</th>
                        </tr>
                        </thead>
                        <tbody>
                        {
                            this.state.authors.map((author, index) => (
                                <tr key={index} className="table-row">
                                    <td>{author.firstName}</td>
                                    <td>{author.lastName}</td>
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


