import React, {Component} from 'react'

export class DeleteCommentButton extends Component {
    constructor(props) {
        super(props);
    }

    deleteComment = () => {
        fetch('/api/v1/comment?id=' + this.props.commentId, {
            method: "DELETE"
        })
            .then(response => this.props.reloadComments())
    }

    render() {
        return (
            <React.Fragment>
                <button onClick={this.deleteComment}
                        className="btn btn-danger"
                        type='button'>Delete
                </button>
            </React.Fragment>
        )
    }
}