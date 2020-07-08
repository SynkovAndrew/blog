import React from 'react'
import './styles.css'
import 'bootstrap/dist/css/bootstrap.css';

export default class MainPage extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            topic: {
                comments: []
            }
        };
    }

    componentDidMount() {
        const topicId = this.props.match.params.topicId

        fetch("/api/v1/topic/" + topicId)
            .then(response => response.json())
            .then(json => this.setState({topics: json.content}))

        fetch('/api/v1/topic/' + bookId + '/comments' )
            .then(response => response.json())
            .then(json => this.setState({book: json}))
    }

    render() {
        return (

        )
    }
}


