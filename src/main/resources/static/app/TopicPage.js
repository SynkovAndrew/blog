import React from 'react'
import './styles.css'
import 'bootstrap/dist/css/bootstrap.css';
import {DeleteCommentButton} from "./DeleteCommentButton";

export default class TopicPage extends React.Component {
    constructor(props) {
        super(props)
        this.state = {
            topic: {},
            comments: [],
            text: ""
        }
    }

    componentDidMount() {
        fetch("/api/v1/topic/" + this.props.match.params.topicId)
            .then(response => response.json())
            .then(json => this.setState({topic: json}))

        this.reloadComments()
    }

    reloadComments = () => {
        fetch("/api/v1/comments?topicId=" + this.props.match.params.topicId)
            .then(response => response.json())
            .then(json => this.setState({comments: json.content}))
    }

    goToTopicsPage = () => {
        const {history} = this.props;
        history.push('/')
    }

    addComment = () => {
        const text = this.state.text;

        if (text !== null && text !== "") {
            fetch('/api/v1/comment', {
                method: "POST",
                body: JSON.stringify({
                    topicId: this.props.match.params.topicId,
                    userId: 1,
                    text: text
                }),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
                .then(response => {
                    this.reloadComments()
                    this.setState({
                        text: ""
                    });
                })
        }
    }

    onCommentTextChange = (event, commentId) => {
        this.setState({
            comments: this.state.comments
                .map(comment => {
                    if (comment.id === commentId) {
                        comment["text"] = event.target.value
                    }
                    return comment
                })
        });
    }

    onTextChange = (event) => {
        this.setState({
            text: event.target.value
        });
    }

    checkAccess = () => {
        return true
    }

    render() {
        return (
            <React.Fragment>
                {
                    this.state.comments.map((comment, index) => (
                        <ul className="list-group">
                            <li className="list-group-item" key={index}>
                                <span>
                                    <p><span className="badge badge-dark badge-pill">
                                        {comment.user.firstName + ' ' + comment.user.lastName}
                                    </span></p>
                                    <textarea className="comment-text-field"
                                              disabled={!this.checkAccess}
                                              onChange={event => this.onCommentTextChange(event, comment.id)}
                                              value={comment.text}/>
                                    <p className="margin-bottom-0"><small>{comment.createdAt}</small></p>
                                </span>
                                <span>
                                    <button>Edit</button>
                                    <DeleteCommentButton commentId={comment.id}
                                                         reloadComments={this.reloadComments}/>
                                </span>
                            </li>
                        </ul>
                    ))
                }
                <div>
                    <div className="form-group margin-5">
                        <textarea rows={4}
                                  value={this.state.text}
                                  onChange={this.onTextChange}
                                  className="form-control"/>
                    </div>
                </div>
                <div>
                    <button className="btn btn-primary margin-5"
                            onClick={this.addComment}>Comment
                    </button>
                    <button className="btn btn-secondary margin-5"
                            onClick={this.goToTopicsPage}>Back
                    </button>
                </div>
            </React.Fragment>
        )
    }
}


