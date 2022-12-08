import React , {useState, useEffect} from 'react';
import Calendar from 'react-calendar';
import 'react-calendar/dist/Calendar.css'; // css import
import Styles from './PersonAdd.css'
import moment from 'moment';

export default function PersoneEdit(){


   // 날짜
           // 날짜 변수 선언
           // 달력 on / off 변수 선언
           // 선택한 날짜 포맷
           // 달력 on / off 변수 동작
           const [value, onChange] = useState(new Date());
           const [ isFull , setIsFull  ] = useState( false );
           const nowTime = moment(value).format('YYYY-MM-DD');
           const btn = () => {  setIsFull(!isFull); } ;



    return(
        <div className="addbox">
                <div>
                    <select>
                        <option  value="" selected disabled hidden>부서</option>
                        <option  value="기획">기획</option>
                        <option  value="운영">운영</option>
                        <option  value="개발">개발</option>
                    </select>
                </div>
                <div>
                   <select>
                       <option  value="" selected disabled hidden>직책</option>
                       <option  value="기획">사원</option>
                       <option  value="운영">주임</option>
                       <option  value="개발">대리</option>
                       <option  value="과장">과장</option>
                       <option  value="차장">차장</option>
                       <option  value="부장">부장</option>
                       <option  value="수석">수석</option>
                   </select>
                </div>
                <div>
                    <input type="text" className="name" placeholder="이름" />
                </div>
                <div>
                    <input type="text" className="birth" placeholder="생년월일" />
                </div>
                <div>
                    <input type="text" className="phone" placeholder="전화번호" />
                </div>
                <div>
                    <input type="text" className="email" placeholder="이메일" />
                </div>
                <div>
                    { isFull && <div className="calbox"> <Calendar onChange={onChange} value={value} /> </div>  }
                    <input type="text" value={nowTime} onClick={btn} / > <br/>
                    <button onClick={btn}> 입사일 </button>
                </div>
                <div>
                    <input type="text" className="pay" placeholder="연봉" /> 만 원
                </div>
                <div>
                    <select>
                       <option  value="" selected disabled hidden>프로젝트</option>
                       <option  value="싸이콘서트">싸이콘서트</option>
                       <option  value="장보기">장보기</option>
                       <option  value="요리레시피찾기">요리레시피찾기</option>
                   </select>
                </div>
            </div>

    );
}