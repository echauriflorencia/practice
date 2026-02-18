import cx from 'classnames';
import { Component } from 'react';

export default class LikeButton extends Component {
    state = {
        likes: 100,
        liked: false
    }

    handleClick = () => {
        if (this.state.liked) {
            this.setState({
                likes: this.state.likes - 1,
                liked: false
            })
        } else {
            this.setState({
                likes: this.state.likes + 1,
                liked: true
            })
        }
    }

    render() {
        return (
            <>
                <button className={cx("like-button", { "liked": this.state.liked })}
                    onClick={this.handleClick}>
                    Like | <span className="likes-counter">
                        {this.state.likes}
                    </span>
                </button>
                <style>{`
                    .like-button {
                        font-size: 1rem;
                        padding: 5px 10px;
                        color:  #585858;
                    }
                   .liked {
                        font-weight: bold;
                        color: #1565c0;
                   }
                `}</style>
            </>
        );
    }
}