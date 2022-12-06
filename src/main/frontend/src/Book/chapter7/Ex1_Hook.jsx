
/*
    리액트 : SPA , 컴포넌트 단위 개발
    State : 데이터 관리 변수
    1) 클래스 : 생성자에서 this.state 선언
    2) 함수   : useState 라이브러리
*/


import React , {useState} from 'react';

export default function Counter( props ){

     const [ count ,setCount ] = useState(0);
     // const : 상수선언
     // useState : 상수(변수) 값을 변경시켜주는 함수

   // JS 혹은 라이브러리
    return (
        <div>
            <p> 총  {count}번 클릭했습니다. </p>
            <button onClick={ () => setCount(count+1) }>
                클릭
            </button>
        </div>
    );
}

/*
export default function Counter( props ){
    // * 오류 : return이 한 번이기 때문에 재로딩이 안되어 화면에 표시되지 않음.
     var count = 0;

   // JS 혹은 라이브러리
    return (
        <div>
            <p> 총  {count}번 클릭했습니다. </p>
            <button onClick={ () => count++}>
                클릭
            </button>
        </div>
    );
}
*/
