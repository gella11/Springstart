
// 1. ID : root 호출
const domContainer = document.querySelector('#root');

// 2. 리액트 렌더링 [ render( 이벤트 , 위치 ) ]
ReactDOM.render(React.createElement(MyButton), domContainer);

// 3.
// props : properties 의 약자로 쓰임 설정값.
function MyButton( props ) {

    const[ isClicked , setIsClicked ] = React.useState(false);

    return React.createElement(                 // React.createElement ( <button> )
        'button',                               // 태그명
        {onClick : () => setIsClicked(true)},   // 옵션 : 이벤트
        isClicked ? 'Clicked' : 'Click here!'   // html 작성
    )
}