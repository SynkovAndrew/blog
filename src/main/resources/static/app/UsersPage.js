import React from "react"
import "./styles.css"
import "bootstrap/dist/css/bootstrap.css";

export default class UsersPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            users: []
        };
    }

    componentDidMount() {
        fetch("/api/v1/users")
            .then(response => response.json())
            .then(json => this.setState({users: json.content}));

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
                            this.state.users.map((user, index) => (
                                <tr key={index} className="table-row">
                                    <td>{user.firstName}</td>
                                    <td>{user.lastName}</td>
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


