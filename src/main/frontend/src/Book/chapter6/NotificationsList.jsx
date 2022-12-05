import React from 'react';
import Notification from './Notification'

const reservedNotifications = [
    { id : 1 , message : " 1. 안녕하세요"},
    { id : 2 , message : " 2. 점심 시간"},
    { id : 3 , message : " 3. 곧 퇴근"},
]

var timer;

// 클래스를 이용한 컴포넌트 만들기
class NotificationsList extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            notifications: [],
        }
    }
    componentDidMount() {
        const { notifications } = this.state;
        timer = setInterval(() =>{
            if(notifications.length < reservedNotifications.length){
                const index = notifications.length;
                notifications.push(reservedNotifications[index]);
                this.setState({
                    notifications : notifications,
                    })
            }else{
                this.setState({notifications :[]})
                //clearInterval(timer);
            }
        }, 2000)
    }

    // 추가코드 ] List 컴포넌트 사망시[끝났을 때 ] timer 초기화
    // 생명주기를 넣어서 확 꺼짐 방지
    componentWillUnmount(){
        if(timer){  // timer 변수에 setInterval 함수가 있으면
            clearInterval(timer);   // setInterval 종료
        }
    }

    render() {
        return (
            <div>
                {this.state.notifications.map((n) =>{
                    return <Notification id={n.id} message={n.message} />
                    })};
            </div>
        )
    }
}

export default NotificationsList;